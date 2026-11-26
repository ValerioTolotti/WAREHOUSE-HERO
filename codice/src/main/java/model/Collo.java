package model;

import java.util.Objects;

public class Collo {
    private final String codiceSeriale; //non cambia mai, quindi final
    private final String marca;
    private final boolean urgente;
    private int tempoRimanenteSec; // usato solo se urgente == true

    //collo standard
    
    public Collo(String codiceSeriale, String marca) {  
        this(codiceSeriale, marca, false, 0);
    }

    //collo urgente
    
    public Collo(String codiceSeriale, String marca, boolean urgente, int tempoRimanenteSec) {
        this.codiceSeriale = Objects.requireNonNull(codiceSeriale, "Il seriale non può essere nullo");
        this.marca = Objects.requireNonNull(marca, "La marca non può essere nulla");
        this.urgente = urgente;
        this.tempoRimanenteSec = Math.max(0, tempoRimanenteSec); //per evitare valori negativi
    }

    public String getCodiceSeriale() {
        return codiceSeriale;
    }

    public String getMarca() {
        return marca;
    }

    public boolean isUrgente() {
        return urgente;
    }

    public int getTempoRimanenteSec() {
        return tempoRimanenteSec;
    }
    
    //decrementa il tempo rimanente solo se urgente e se il tempo rimanente è maggiore di 0
    
    public void decrementaTempo(int secondi) {
        if (urgente && tempoRimanenteSec > 0) {
            tempoRimanenteSec = Math.max(0, tempoRimanenteSec - secondi);
        }
    }

    public boolean isScaduto() {
        return urgente && tempoRimanenteSec == 0;
    }

    @Override //utilizzo equals perchè voglio confrontare due oggetti Collo e non dei singoli parametri
    public boolean equals(Object o) {
        if (this == o) return true; //controllo rapido se sono lo stesso oggetto
        if (!(o instanceof Collo)) return false; //serve per controllare il tipo dell'oggetto, evitando ClassCastException
        Collo collo = (Collo) o;
        return codiceSeriale.equalsIgnoreCase(collo.codiceSeriale)
                && marca.equalsIgnoreCase(collo.marca);	//se il seriale e la marca sono uguali, restituisce true
    }

    @Override
    public int hashCode() {
        return Objects.hash(codiceSeriale.toLowerCase(), marca.toLowerCase());
    }

    @Override
    public String toString() { 
        return marca + " [" + codiceSeriale + "]" + (urgente ? " (URGENTE: " + tempoRimanenteSec + "s)" : "");
    }
}