package program;

import java.util.LinkedList;
import java.util.Random;

public class Pozoriste extends Zgrada implements Validacija{
    private LinkedList<Karta> karte;
    private LinkedList<Predstava> predstavas;
    private int indeksPrestave;

    public Pozoriste(String ime, String adresa){
        super(ime, adresa);
        this.sale = new String[2];
        this.mesta = new boolean[2][50];
        karte = new LinkedList<Karta>();
        predstavas = new LinkedList<Predstava>();
        indeksPrestave = 0;
        populate();
    }

    private void populate(){
        for(int i = 0; i < this.sale.length; i++) {
            this.sale[i] = "Sala " + i;
        }

        Random random = new Random();
        for(int i = 0; i < this.mesta.length; i++) {
            for(int j = 0; j < this.mesta[i].length; j++) {
                switch(random.nextInt(2)){
                    case 0:
                        this.mesta[i][j] = false;
                        break;
                    case 1:
                        this.mesta[i][j] = true;
                        break;
                    default:
                        break;
                }
            }
        }

        predstavas.add(new Predstava("Hipnoza jedne ljubavi", "Drama", "1h 50min", "Sala 0", "21:00"));
        predstavas.add(new Predstava("Cigani lete u nebo", "Mjuzikl", "2h 4min", "Sala 1", "22:20"));
        predstavas.add(new Predstava("Slučajna smrt jednog anarhiste", "Komedija", "1h 10min", "Sala 1", "21:00"));
        predstavas.add(new Predstava("Siroti B.B.", "Drama", "1h 40min", "Sala 1", "19:10"));
        predstavas.add(new Predstava("Vrat od stakla", "Drama", "1h 35min", "Sala 0", "19:15"));
    }

    @Override
    public boolean proveraSlobodnihMesta(String filmPredstava, int mesto){
        boolean hasFilm = false;
        for(int i = 0; i < predstavas.size(); i++) {
            if(predstavas.get(i).getNaziv().equals(filmPredstava)){
                hasFilm = true;
                indeksPrestave = i;
            }
        }

        if(!hasFilm){
            System.out.println("Nemamo predstavu u ponudi");
            return false;
        }

        for(int i = 0; i < this.sale.length; i++) {
            if(this.sale[i].equals(this.predstavas.get(indeksPrestave).getSala())){
                for(int j = 0; j < this.mesta[i].length; j++) {
                    if(j == mesto){
                        if(this.mesta[i][j]){
                            System.out.println("Mesto je rezervisano, rezervisite drugo mesto");
                            return false;
                        }
                        else{
                            return true;
                        }
                    }
                }
            }
        }

        return false;
    }

    @Override
    public Karta rezervacija(String filmPredstava, int mesto){
        for(int i = 0; i < this.predstavas.size(); i++) {
            if(this.predstavas.get(i).getNaziv().equals(filmPredstava)) {
                for(int j = 0; j <  this.sale.length; j++) {
                    if(this.sale[j].equals(this.predstavas.get(i).getSala())){
                        for(int k = 0; k < this.mesta[j].length; k++) {
                            if(k == mesto) {
                                Random random = new Random();
                                this.mesta[j][k] = true;
                                int idKarte = random.nextInt(20000);
                                this.karte.add(new Karta(idKarte, predstavas.get(i).getSala(), mesto, filmPredstava, 300, predstavas.get(i).getVremePredstave()));
                                System.out.println("Karta rezervisana. Uzivaj te!");
                                return new Karta(idKarte, predstavas.get(i).getSala(), mesto, filmPredstava, 300, predstavas.get(i).getVremePredstave());
                            }
                        }
                    }
                }
            }
        }
        return new Karta();
    }

    public void slobodnaMesta(){
        System.out.print("Slobodna mesta u " + predstavas.get(indeksPrestave).getSala() + ": ");
        StringBuilder stringBuilder = new StringBuilder();
        for(int i = 0; i <  this.sale.length; i++) {
            if(this.sale[i].equals(this.predstavas.get(indeksPrestave).getSala())){
                for(int j = 0; j < this.mesta[i].length; j++) {
                    if(!this.mesta[i][j]){
                        stringBuilder.append(String.valueOf(j) + ", ");
                    }
                }
            }
        }
        System.out.println(stringBuilder.toString());
    }

    public void ponudaPredstava(){
        for(int i = 0; i < this.predstavas.size(); i++) {
            System.out.println(this.predstavas.get(i).toString());
        }
    }

    public void rezervisaneKarte(){
        for(int i = 0; i < this.karte.size(); i++) {
            System.out.println(this.karte.get(i).toString());
        }
    }

}
