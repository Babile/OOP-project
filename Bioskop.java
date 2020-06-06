package program;

import java.util.LinkedList;
import java.util.Random;

public class Bioskop extends Zgrada implements Validacija{
    private LinkedList<Karta> kartaLinkedList;
    private LinkedList<Film> filmLinkedList;

    public Bioskop(String ime, String adresa){
        super(ime, adresa);
        this.sale = new String[3];
        this.mesta = new boolean[3][30];
        kartaLinkedList = new LinkedList<Karta>();
        filmLinkedList = new LinkedList<Film>();
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


    }

    @Override
    public boolean proveraSlobodnihMesta(String sala, int mesto){
        int sala1Mesta = 0;
        int sala2Mesta = 0;
        int sala3Mesta = 0;

        for(int i = 0; i < this.sale.length; i++) {
            for(int j = 0; j < this.mesta[i].length; j++) {
                if(i == 0) {
                    if(this.mesta[i][j] == false) {
                        sala1Mesta++;
                    }
                }
                else if(i == 1) {
                    if(this.mesta[i][j] == false) {
                        sala2Mesta++;
                    }
                }
                else if(i == 2) {
                    if(this.mesta[i][j] == false) {
                        sala3Mesta++;
                    }
                }
            }
        }

        System.out.println("Sala 1 ima slobodnih mesta: " + sala1Mesta + " Sala 2 ima slobodnih mesta: " + sala2Mesta + " Sala 3 ima slobodnih mesta: " + sala3Mesta);

        for(int i = 0; i < this.sale.length; i++) {
            if(this.sale.equals(sala)) {
                for(int j = 0; j < this.mesta[i].length; j++) {
                    if(j == mesto) {
                        if(this.mesta[i][j] == false){
                            return true;
                        }
                    }
                }
            }
        }
        System.out.println("Sala ili mesto koje ste odabrali je nije slobodno, birajte drugo ponudjeno mesto");
        return false;
    }

    @Override
    public void rezervacija(String sala, int mesto){
        for(int i = 0; i < this.sale.length; i++) {
            if(this.sale.equals(sala)) {
                for(int j = 0; j < this.mesta[i].length; j++) {
                    if(j == mesto) {
                        this.mesta[i][j] = true;
                       // kartaLinkedList.add(new Karta(1, sala, mesto, ));
                    }
                }
            }
        }
    }
}
