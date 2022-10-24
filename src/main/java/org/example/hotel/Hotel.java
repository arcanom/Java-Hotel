package org.example.hotel;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Hotel {
    public static String name;
    public static  List<Chambre> chambres = new ArrayList<Chambre>();
    public static List<Reservation> reservations=  new ArrayList<Reservation>();
    public static  List<Client> clients  = new ArrayList<Client>();

    public Hotel(List<Chambre> chambres) {
        this.chambres = chambres;
    }

    public Hotel(String name, List<Reservation> reservations, List<Client> clients) {
        this.name = name;
        this.reservations = reservations;
        this.clients = clients;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Chambre> getChambres() {
        return chambres;
    }

    public void setChambres(List<Chambre> chambres) {
        this.chambres = chambres;
    }

    public List<Reservation> getReservations() {
        return reservations;
    }

    public void setReservations(List<Reservation> reservations) {
        this.reservations = reservations;
    }

    public List<Client> getClients() {
        return clients;
    }

    public void setClients(List<Client> clients) {
        this.clients = clients;
    }

    public static void createChamber(){
        for(int i=1; i<=20;i++){

            Random random = new Random();
            boolean statut = random.nextBoolean();


            int tarif = (int) Math.floor(Math.random()*1000);
            int capacite = (int) Math.floor(Math.random()*10);
            Chambre chambre = new Chambre(i,statut,tarif,capacite);
            chambres.add(chambre);
        }
    }

    public static void addClient(String name, String firstname, String phone){
        Client newClient = new Client(name,firstname,phone);
        clients.add(newClient);
    }

    public static void showClients(){
        for(Client client : clients){
            System.out.println(client.toString());
        }
    }

    public static void reservationClient(String phone){
        List<Reservation>  reservationsByClient = new ArrayList<>();
        for(Reservation reservation : reservations){
                if(reservation.client.getPhone().equals(phone)){
                    reservationsByClient.add(reservation);
                }
        }
        for (Reservation reservation : reservationsByClient){
            System.out.println(reservation.toString());
        }
    }

    public static void addReservation(int id, int occupant){
        Client searchClient= null;
        for( Client client : clients ){
            if(client.id == id) {
                searchClient = client;
            }
            }

            if(searchClient == null){
                System.out.println("Vous n'etes pas client de cet hotel");
            } else{
                List<Chambre> chambreDispo =  new ArrayList<>();
                for (Chambre chambre : chambres){
                    if(chambre.isStatut() && chambre.getCapacite() >= occupant  ){
                        chambreDispo.add(chambre);
                    }
                }
                if(chambreDispo.size() == 0){
                    System.out.println("Nous n'avons pas de chambres disponible pour le moment");
                } else {

                    for (Chambre chambre : chambreDispo){
                        System.out.println(chambre.toString());
                    }
                    System.out.println("Quelle chambre voulez vous réserver?");
                    Scanner sc = new Scanner(System.in);
                    int numeroChambre =  sc.nextInt();

                    Chambre reservedChamber = null;
                    for(Chambre chambre : chambres){
                        if(chambre.getNumero() == numeroChambre){
                            chambre.statut = false;
                            reservedChamber = chambre;
                        }

                    }
                    Reservation newReservation = new Reservation(true,searchClient,reservedChamber);
                    reservations.add(newReservation);

                }


            }

    }

    public static void deleteReservation(int id){
        int numeroChambre = 0;
        for( Reservation reservation : reservations ){
            if(reservation.getNumero() == id){
                reservation.statut =  false;
                numeroChambre = reservation.chambre.getNumero();
            }
         for(Chambre chambre  : chambres){
             if(chambre.getNumero() == numeroChambre){
                 chambre.statut = true;
             }
         }
        }
    }

    public static void showReservation(){
        for(Reservation reservation :  reservations){
            System.out.println(reservation.toString());
        }
    }


}
