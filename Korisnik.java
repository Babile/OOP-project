package program;

public class Korisnik{
    private String ime;
    private String prezime;
    private Karta karta;

    public Korisnik(String ime, String prezime){
        this.ime = ime;
        this.prezime = prezime;
    }

    public String getIme(){
        return this.ime;
    }

    public void setIme(String ime){
        this.ime = ime;
    }

    public String getPrezime(){
        return this.prezime;
    }

    public void setPrezime(String prezime){
        this.prezime = prezime;
    }

    public Karta getKarta(){
        return this.karta;
    }

    public void setKarta(Karta karta){
        this.karta = karta;
    }
}
