package program;

public class Predstava{
    private String naziv;
    private String zanr;
    private String minutaza;
    private String sala;
    private String vremePredstave;


    public Predstava(String naziv, String zanr, String minutaza, String sala, String vremePredstave){
        this.naziv = naziv;
        this.zanr = zanr;
        this.minutaza = minutaza;
        this.sala = sala;
        this.vremePredstave = vremePredstave;
    }

    public String getNaziv(){
        return this.naziv;
    }

    public String getSala(){
        return this.sala;
    }

    public String getVremePredstave(){
        return this.vremePredstave;
    }

    @Override
    public String toString(){
        return "Naziv: " +  this.naziv + ", Zanr: " + this.zanr + ", trajanje: " + this.minutaza + ", Saka: " + this.sala + ", Film pocinje: " + this.vremePredstave;
    }
}
