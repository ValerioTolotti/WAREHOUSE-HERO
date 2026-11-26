package model;

public enum Direzione { 
    SU(0, -1),
    GIU(0, 1),
    SINISTRA(-1, 0),
    DESTRA(1, 0);

	/*(asse orizzontale, asse verticale), la convenzione parte come posizione iniziale (0,0)
	  poi incrementa asse orizzontale verso destra e asse verticale verso il basso ) */
	
    private final int dx;
    private final int dy;

    //gli enum sono sempre privati
    Direzione(int dx, int dy) {
        this.dx = dx;
        this.dy = dy;
    }

    public int getDx() {
        return dx;
    }

    public int getDy() {
        return dy;
    }
}