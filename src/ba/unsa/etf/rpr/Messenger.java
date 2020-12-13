package ba.unsa.etf.rpr;



import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Messenger {

    private ArrayList<Poruka> poruke;

    public Messenger() {
        this.poruke = new ArrayList<>();
    }

    public List<Poruka> dajSvePoruke(){
        return poruke;
    }

    public void posaljiPoruku(Korisnik posiljalac, Korisnik primalac, String tekst) throws NeispravanFormatPoruke {
        poruke.add(new Poruka(posiljalac,primalac,LocalDateTime.now(),tekst));
    }

    public void posaljiPoruku(Poruka p) {
        if(!poruke.contains(p))poruke.add(p);
    }

    public void posaljiPoruke(List<Poruka> por) {
        poruke.addAll(por);
    }

    public void ponistiSlanje(Poruka p) throws NeispravnaAkcija {
        if(!poruke.contains(p)) throw new NeispravnaAkcija("Nije moguće poništiti slanje poruke koja nije nikada poslana!");
        if(p.getStatusPoruke()==StatusPoruke.PROCITANA) throw new NeispravnaAkcija("Nije moguće poništiti slanje poruke koja je već pročitana!");
        poruke.remove(p);
    }

    public void procitajPoruku(Poruka p) throws NeispravnaAkcija {
        if(!poruke.contains(p)) throw new NeispravnaAkcija("Nije moguće pročitati poruku koja nije nikada poslana!");
        poruke.stream().forEach(poruka -> {if(poruka.equals(p))poruka.setStatusPoruke(StatusPoruke.PROCITANA);});

    }

    public void oznaciKaoNeprocitano(List<Poruka> por) throws NeispravnaAkcija {
        AtomicBoolean greska = new AtomicBoolean(false);
        por.forEach(poruka -> {if(!poruke.contains(poruka)) greska.set(true);});
        if(greska.get()) throw new NeispravnaAkcija("Neke od poruka koje pokušavate označiti kao nepročitane nisu poslane!");
        poruke.forEach(poruka -> {if(por.contains(poruka))poruka.setStatusPoruke(StatusPoruke.NEPROCITANA);});
    }

    public Map<Korisnik,List<Poruka>> dajNeprocitanePoruke(){
        Map<Korisnik,List<Poruka>> povratna = new HashMap<>();
        List<Korisnik> lista = new ArrayList<>();
        poruke.forEach(poruka -> {if(!lista.contains(poruka.getPrimalac()))lista.add(poruka.getPrimalac());});
        for(var x:lista){
            List<Poruka> por = new ArrayList<>();
            poruke.forEach(poruka -> {if(poruka.getPrimalac().equals(x) && poruka.getStatusPoruke()==StatusPoruke.NEPROCITANA)por.add(poruka);});
            povratna.put(x,por);
        }
        return  povratna;
    }


    public List<Poruka> dajPristiglePorukeZaKorisnika(Korisnik korisnik2) {
        return poruke.stream().filter(poruka -> poruka.getPrimalac().equals(korisnik2)).collect(Collectors.toList());

    }

    public List<Poruka> dajPorukeZaKorisnika(Korisnik korisnik, StatusPoruke sp) {
        return poruke.stream().filter(poruka -> poruka.getPrimalac().equals(korisnik) && poruka.getStatusPoruke()==sp).collect(Collectors.toList());
    }

    public List<Poruka> filtrirajPoruke(Predicate<Poruka> fil){
        return poruke.stream().filter(fil).collect(Collectors.toList());
    }

    public List<Poruka> dajStarijeOd(Korisnik korisnik1, LocalDateTime datum) {
        return this.filtrirajPoruke(poruka -> poruka.getPosiljalac().equals(korisnik1) && (poruka.getDatumSlanja().isBefore(datum) || poruka.getDatumSlanja().isEqual(datum)));
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        poruke.forEach(poruka -> sb.append(poruka.toString()+"\n"));

        return sb.toString().trim();
    }
}
