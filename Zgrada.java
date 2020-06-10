package program;

public abstract class Zgrada{
    protected String ime;
    protected String adresa;
    protected String[] sale;
    protected boolean[][] mesta;

    public Zgrada(String ime, String adresa){
        this.ime = ime;
        this.adresa = adresa;
    }
}
