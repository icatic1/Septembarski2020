package ba.unsa.etf.rpr;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class Main {
/*
    public static void main(String[] args) throws NeispravanFormatPoruke {


         Messenger messenger;
         List<Poruka> poruke = new ArrayList<>();
         Korisnik korisnik1, korisnik2, korisnik3, korisnik4;
        LocalDateTime datum;

        korisnik1 = new Korisnik("Miki", "Maus", "miki123");
        korisnik2 = new Korisnik("Paja", "Patak", "paja123");
        korisnik3 = new Korisnik("Mini", "Maus", "minica");
        korisnik4 = new Korisnik("Betty", "Boop", "bettyb");
        datum = LocalDateTime.of(
                LocalDate.of(2020, 12, 12),
                LocalTime.of(17,0,0,0)
        );

        poruke.add(new Poruka(korisnik1, korisnik2, datum, "Kako si?"));
        poruke.add(new Poruka(korisnik1, korisnik3, datum.plusHours(1), "Šta ima?"));
        poruke.add(new Poruka(korisnik3, korisnik2, datum.plusHours(4), "Ispit je bio jako lagan."));
        poruke.add(new Poruka(korisnik2, korisnik3, datum.plusHours(5), "Slažem se :)"));
        poruke.add(new Poruka(korisnik1, korisnik4, datum.minusHours(3), "Nećeš nikada pogoditi šta se desilo!!! :o"));
        poruke.add(new Poruka(korisnik4, korisnik2, datum.minusHours(1), "Ima li nešto novo?"));
        poruke.add(new Poruka(korisnik3, korisnik4, datum.plusHours(4), "Imaš li za prolaza?"));

        messenger = new Messenger();
        poruke.forEach(poruka -> poruka.setStatusPoruke(StatusPoruke.NEPROCITANA));

//test2
        messenger.posaljiPoruke(poruke);

        List<Poruka> filtrirane  = messenger.dajStarijeOd(korisnik3, datum.plusHours(2));


        for(var x:filtrirane){
            System.out.println(x.getDatumSlanja());
            System.out.println(x);
        }
    }
    */
}
