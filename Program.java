package program;

import javafx.scene.Scene;

import java.util.Scanner;

public class Program{
    public static void main(String[] args) {
        Korisnik[] korisniks = new Korisnik[3];
        Bioskop bioskop = new Bioskop("Roda Cineplex", "Pozeska 83a");
        Pozoriste pozoriste = new Pozoriste("Teatar Na Brdu", "Turgenjevljeva 5");

        for(int i = 0; i < korisniks.length; i++) {
            korisniks[i] = new Korisnik("Korisnik_ime" + i, "Korisnik_prezime" + i);
        }

        boolean test = false;

        while(!test){
            for(int i = 0; i < korisniks.length; i++) {
                boolean test2 = false;
                while(!test2){
                    if(i % 2 == 0){
                        System.out.println("Ponuda filmova:");
                        bioskop.ponudaFilmova();
                        System.out.print("Koji film zelite da gledate: ");
                        Scanner scanner = new Scanner(System.in);
                        String imeFilm = scanner.nextLine();
                        bioskop.slobodnaMesta();
                        while(!test2){

                            System.out.print("Koje mesto zelite: ");
                            int mesto = scanner.nextInt();

                            if(bioskop.proveraSlobodnihMesta(imeFilm, mesto)){
                                korisniks[i].setKarta(bioskop.rezervacija(imeFilm, mesto));
                                test2 = true;
                            }
                        }
                    }
                    else{
                        System.out.println("Ponuda predstava:");
                        pozoriste.ponudaPredstava();
                        System.out.print("Koji predstavu zelite da gledate: ");
                        Scanner scanner = new Scanner(System.in);
                        String imeFilm = scanner.nextLine();
                        pozoriste.slobodnaMesta();

                        while(!test2){

                            System.out.print("Koje mesto zelite: ");
                            int mesto = scanner.nextInt();

                            if(pozoriste.proveraSlobodnihMesta(imeFilm, mesto)){
                                korisniks[i].setKarta(pozoriste.rezervacija(imeFilm, mesto));
                                test2 = true;
                            }
                        }
                    }
                }
            }
            test = true;
        }
        System.out.println("Rezervisane karte u bioskopu:");
        bioskop.rezervisaneKarte();
        System.out.println("Rezervisane karte u pozoristu:");
        pozoriste.rezervisaneKarte();
        
        System.out.println("Uzivaj te");
    }
}
