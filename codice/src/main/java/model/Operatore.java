package model;

import java.util.Optional;

public class Operatore {
    private int x;
    private int y;
    private Direzione direzione;
    private Collo colloTrasportato;
    private int xpTotali;

    public Operatore(int startX, int startY) {
        this.x = startX;
        this.y = startY;
        this.direzione = Direzione.GIU;
        this.colloTrasportato = null;
        this.xpTotali = 0;
    }
    
    //la gestione degli ostacoli avviene in un'altra classe
    public void muovi(Direzione nuovaDir, int nuovaX, int nuovaY) {
        this.direzione = nuovaDir;
        this.x = nuovaX;
        this.y = nuovaY;
    }

    public boolean staTrasportandoCollo() {
        return colloTrasportato != null;
    }

    public boolean raccogliCollo(Collo collo) {
        if (staTrasportandoCollo() || collo == null) {
            return false;
        }
        this.colloTrasportato = collo;
        return true;
    }

    public Collo rilasciaCollo() {
        Collo temp = this.colloTrasportato;
        this.colloTrasportato = null;
        return temp;
    }

    public void aggiungiXp(int punti) {
        this.xpTotali = Math.max(0, this.xpTotali + punti);
    }

    public int getX() { return x; }
    public int getY() { return y; }
    
    public Direzione getDirezione() { return direzione; }
    
    public Optional<Collo> getColloTrasportato() { return Optional.ofNullable(colloTrasportato); }
    
    public int getXpTotali() { return xpTotali; }
}