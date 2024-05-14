package Eccezioni;

public class EtichettaNonCreata extends Exception{
    public EtichettaNonCreata(){
        super ("Errore durante la creazione dell'Etichetta");
    }
}
