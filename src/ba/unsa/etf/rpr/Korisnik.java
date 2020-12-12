package ba.unsa.etf.rpr;

import java.util.Objects;

public class Korisnik {

    private String ime;
    private String prezime;
    private String nadimak;


    public Korisnik(String ime, String prezime, String nadimak) {

        if(ime==null || prezime==null  || nadimak==null ) throw new IllegalArgumentException("Ime, prezime i nadimak ne smiju biti null!");
        if(ime.isEmpty() || prezime.isEmpty() || nadimak.isEmpty()) throw new IllegalArgumentException("Ime, prezime i nadimak ne smiju biti prazni!");
        if(nadimak.length()<5) throw new IllegalArgumentException("Nadimak mora imati 5 ili više karaktera!");
        this.ime = ime;
        this.prezime = prezime;
        this.nadimak = nadimak;
    }


    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        if(ime==null ) throw new IllegalArgumentException("Ime, prezime i nadimak ne smiju biti null!");
        if(ime.isEmpty() ) throw new IllegalArgumentException("Ime, prezime i nadimak ne smiju biti prazni!");


        this.ime = ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {

        if(prezime==null ) throw new IllegalArgumentException("Ime, prezime i nadimak ne smiju biti null!");
        if(prezime.isEmpty() ) throw new IllegalArgumentException("Ime, prezime i nadimak ne smiju biti prazni!");

        this.prezime = prezime;
    }

    public String getNadimak() {
        return nadimak;
    }

    public void setNadimak(String nadimak) {

        if(nadimak==null ) throw new IllegalArgumentException("Ime, prezime i nadimak ne smiju biti null!");
        if(nadimak.isEmpty() ) throw new IllegalArgumentException("Ime, prezime i nadimak ne smiju biti prazni!");
        if(nadimak.length()<5) throw new IllegalArgumentException("Nadimak mora imati 5 ili više karaktera!");

        this.nadimak = nadimak;
    }

    @Override
    public String toString() {
        return  ime +" " + prezime + " (" +nadimak+")";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Korisnik korisnik = (Korisnik) o;
        return Objects.equals(ime, korisnik.ime) &&
                Objects.equals(prezime, korisnik.prezime) &&
                Objects.equals(nadimak, korisnik.nadimak);
    }
}
