package program;

public class Karta{
    private int id;
    private String sala;
    private int brSedista;
    private String film;
    private double cena;
    private String vreme;

    public Karta(){
        this.id = 0;
        this.sala = "nema u ponudi";
        this.brSedista = 0;
        this.film = "nema u ponudi";
        this.cena = 0.0;
        this.vreme = "NaN";
    }

    public Karta(int id, String sala, int brSedista, String film, double cena, String vreme){
        this.id = id;
        this.sala = sala;
        this.brSedista = brSedista;
        this.film = film;
        this.cena = cena;
        this.vreme = vreme;
    }


    public int getId(){
        return this.id;
    }

    public void setId(int id){
        this.id = id;
    }

    public String getSala(){
        return this.sala;
    }

    public void setSala(String sala){
        this.sala = sala;
    }

    public int getBrSedista(){
        return this.brSedista;
    }

    public void setBrSedista(int brSedista){
        this.brSedista = brSedista;
    }

    public String getFilm(){
        return this.film;
    }

    public void setFilm(String film){
        this.film = film;
    }

    public double getCena(){
        return this.cena;
    }

    public void setCena(double cena){
        this.cena = cena;
    }

    @Override
    public String toString(){
        return "ID karte: " + this.id + " ,Sala" + this.sala + ", Broj sedista: " + this.brSedista + ", Film:" + this.film + ", Cena:" + this.cena + ", Vreme:" + this.vreme;
    }
}
