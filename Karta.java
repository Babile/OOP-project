package program;

public class Karta{
    private int id;
    private String sala;
    private int brSedista;
    private String film;
    private double cena;


    public Karta(int id, String sala, int brSedista, String film, double cena){
        this.id = id;
        this.sala = sala;
        this.brSedista = brSedista;
        this.film = film;
        this.cena = cena;
    }


    public int getId(){
        return id;
    }

    public void setId(int id){
        this.id = id;
    }

    public String getSala(){
        return sala;
    }

    public void setSala(String sala){
        this.sala = sala;
    }

    public int getBrSedista(){
        return brSedista;
    }

    public void setBrSedista(int brSedista){
        this.brSedista = brSedista;
    }

    public String getFilm(){
        return film;
    }

    public void setFilm(String film){
        this.film = film;
    }

    public double getCena(){
        return cena;
    }

    public void setCena(double cena){
        this.cena = cena;
    }
}
