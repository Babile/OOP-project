package program;

public class Film{
    private String naziv;
    private String zanr;
    private String minutaza;
    private String sala;
    private String vremeFilma;


    public Film(String naziv, String zanr, String minutaza, String sala, String vremeFilma){
        this.naziv = naziv;
        this.zanr = zanr;
        this.minutaza = minutaza;
        this.sala = sala;
        this.vremeFilma = vremeFilma;
    }

    public String getNaziv(){
        return this.naziv;
    }

    public String getSala(){
        return this.sala;
    }

    public String getVremeFilma(){
        return this.vremeFilma;
    }

    @Override
    public String toString(){
        return "Naziv: " +  this.naziv + ", Zanr: " + this.zanr + ", trajanje: " + this.minutaza + ", Saka: " + this.sala + ", Film pocinje: " + this.vremeFilma;
    }
}
