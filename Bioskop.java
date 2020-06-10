package program;

import java.util.LinkedList;
import java.util.Random;

public class Bioskop extends Zgrada implements Validacija{
    private LinkedList<Karta> kartaLinkedList;
    private LinkedList<Film> filmLinkedList;
    private int indeksFilmaP;

    public Bioskop(String ime, String adresa){
        super(ime, adresa);
        this.sale = new String[3];
        this.mesta = new boolean[3][30];
        kartaLinkedList = new LinkedList<Karta>();
        filmLinkedList = new LinkedList<Film>();
        indeksFilmaP = 0;
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

        filmLinkedList.add(new Film("The Gentlemen", "Action, Comedy, Crime", "1h 53min", "Sala 0", "21:00"));
        filmLinkedList.add(new Film("Bad Boys for Life", "Action, Comedy, Crime", "2h 4min", "Sala 1", "21:00"));
        filmLinkedList.add(new Film("The Lodge", "Drama, Horror, Thriller", "1h 48min", "Sala 2", "21:00"));
        filmLinkedList.add(new Film("Willy Wonka & the Chocolate Factory", "Family, Fantasy, Musical", "1h 40min", "Sala 1", "20:10"));
        filmLinkedList.add(new Film("The Lighthouse", "Drama, Fantasy, Horror", "1h 49min", "Sala 0", "19:15"));
    }

    @Override
    public boolean proveraSlobodnihMesta(String filmPredstava, int mesto){
        boolean hasFilm = false;
        for(int i = 0; i < filmLinkedList.size(); i++) {
            if(filmLinkedList.get(i).getNaziv().equals(filmPredstava)){
                hasFilm = true;
                indeksFilmaP = i;
            }
        }

        if(!hasFilm){
            System.out.println("Nemamo film u ponudi");
            return false;
        }

        System.out.print("Slobodna mesta u " + filmLinkedList.get(indeksFilmaP).getSala() + ": ");
        StringBuilder stringBuilder = new StringBuilder();
        for(int i = 0; i <  this.sale.length; i++) {
           if(this.sale[i].equals(filmLinkedList.get(indeksFilmaP).getSala())){
               for(int j = 0; j < this.mesta[i].length; j++) {
                   if(!this.mesta[i][j]){
                       stringBuilder.append(String.valueOf(j) + ", ");
                   }
               }
           }
        }
        System.out.println(stringBuilder.toString());

        for(int i = 0; i < this.sale.length; i++) {
            if(this.sale[i].equals(this.filmLinkedList.get(indeksFilmaP).getSala())){
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
        for(int i = 0; i < this.filmLinkedList.size(); i++) {
            if(this.filmLinkedList.get(i).getNaziv().equals(filmPredstava)) {
                for(int j = 0; j < this.sale.length; j++) {
                    if(this.sale[j].equals(this.filmLinkedList.get(i).getSala())){
                        for(int l = 0; l < this.mesta[j].length; l++) {
                            if(l == mesto) {
                                Random random = new Random();
                                this.mesta[j][l] = true;
                                int idKarte = random.nextInt(20000);
                                this.kartaLinkedList.add(new Karta(idKarte, filmLinkedList.get(i).getSala(), mesto, filmPredstava, 350, filmLinkedList.get(i).getVremeFilma()));
                                System.out.println("Karta rezervisana. Uzivaj te!");
                                return new Karta(idKarte, filmLinkedList.get(i).getSala(), mesto, filmPredstava, 350, filmLinkedList.get(i).getVremeFilma());
                            }
                        }
                    }
                }
            }
        }
        return new Karta();
    }

    public void slobodnaMesta(){
        System.out.print("Slobodna mesta u " + this.filmLinkedList.get(indeksFilmaP).getSala() + ": ");
        StringBuilder stringBuilder = new StringBuilder();
        for(int i = 0; i <  this.sale.length; i++) {
            if(this.sale[i].equals(this.filmLinkedList.get(indeksFilmaP).getSala())){
                for(int j = 0; j < this.mesta[i].length; j++) {
                    if(!this.mesta[i][j]){
                        stringBuilder.append(String.valueOf(j) + ", ");
                    }
                }
            }
        }
        System.out.println(stringBuilder.toString());
    }

    public void ponudaFilmova(){
        for(int i = 0; i < filmLinkedList.size(); i++) {
            System.out.println(filmLinkedList.get(i).toString());
        }
    }

    public void rezervisaneKarte(){
        for(int i = 0; i < kartaLinkedList.size(); i++) {
            System.out.println(kartaLinkedList.get(i).toString());
        }
    }
}
