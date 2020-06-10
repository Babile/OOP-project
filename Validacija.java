package program;

public interface Validacija{
    boolean proveraSlobodnihMesta(String filmPredstava, int mesto);
    Karta rezervacija(String filmPredstava, int mesto);
}
