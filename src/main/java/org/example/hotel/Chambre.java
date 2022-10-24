package org.example.hotel;

public class Chambre {

    int numero ;
    boolean statut;
    int tarif;
    int capacite;

    public Chambre(int numero, boolean statut, int tarif, int capacite) {
        this.numero = numero;
        this.statut = statut;
        this.tarif = tarif;
        this.capacite = capacite;
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

    public int getTarif() {
        return tarif;
    }

    public void setTarif(int tarif) {
        this.tarif = tarif;
    }

    public int getCapacite() {
        return capacite;
    }

    public void setCapacite(int capacite) {
        this.capacite = capacite;
    }

    @Override
    public String toString() {
        return "Chambre{" +
                "numero=" + numero +
                ", statut=" + statut +
                ", tarif=" + tarif +
                ", capacite=" + capacite +
                '}';
    }
}
