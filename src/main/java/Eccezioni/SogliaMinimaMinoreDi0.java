package Eccezioni;

public class SogliaMinimaMinoreDi0 extends Exception{
    public SogliaMinimaMinoreDi0(){
        super ("Il valore di soglia minima non può essere minore o uguale a 0");
    }
}
