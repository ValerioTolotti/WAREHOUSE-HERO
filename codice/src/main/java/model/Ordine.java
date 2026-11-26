package model;

import java.util.Objects;

public class Ordine {
    private final String idOrdine;
    private final String marcaRichiesta;
    private final String serialeRichiesto;
    private final int ricompensaXp;
    private boolean completato;

    public Ordine(String idOrdine, String marcaRichiesta, String serialeRichiesto, int ricompensaXp) {
        this.idOrdine = idOrdine;
        this.marcaRichiesta = Objects.requireNonNull(marcaRichiesta, "La marca richiesta non può essere nulla");
        this.serialeRichiesto = Objects.requireNonNull(serialeRichiesto, "Il seriale richiesto non può essere nullo");
        this.ricompensaXp = Math.max(0, ricompensaXp);
        this.completato = false;
    }
   
     //Verifica se il collo consegnato corrisponde all'ordine
    
    public boolean verificaCorrispondenza(Collo collo) {   //uso un metodo perché verifico solo marca e seriale
        if (collo == null) return false;
        return marcaRichiesta.equalsIgnoreCase(collo.getMarca())
                && serialeRichiesto.equalsIgnoreCase(collo.getCodiceSeriale());
    }

    public String getIdOrdine() {
        return idOrdine;
    }

    public String getMarcaRichiesta() {
        return marcaRichiesta;
    }

    public String getSerialeRichiesto() {
        return serialeRichiesto;
    }

    public int getRicompensaXp() {
        return ricompensaXp;
    }

    public boolean isCompletato() {
        return completato;
    }

    public void segnaCompletato() {
        this.completato = true;
    }
}
