package org.example.hotel;

public class Reservation {
    int numero;
    boolean statut;
    Client client;
    Chambre chambre;

    private static int count = 0;

    public Reservation( boolean statut, Client client, Chambre chambre) {
        this.numero = ++count;
        this.statut = statut;
        this.client = client;
        this.chambre = chambre;

    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public boolean isStatut() {
        return statut;
    }

    public void setStatut(boolean statut) {
        this.statut = statut;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Chambre getChambre() {
        return chambre;
    }

    public void setChambre(Chambre chambre) {
        this.chambre = chambre;
    }

    @Override
    public String toString() {
        return "Reservation{" +
                "numero=" + numero +
                ", statut=" + statut +
                ", client=" + client +
                ", chambre=" + chambre +
                '}';
    }
}
