package org.example.hotel;

import java.util.Scanner;

public class IHM {

    public static void AffichageMenu() {
        System.out.println("1-  Ajouter un client");
        System.out.println("2- Afficher la liste des clients ");
        System.out.println("3- Afficher les reservations d'un client");
        System.out.println("4- Ajouter une réservation");
        System.out.println("5- Annuler une réservation");
        System.out.println("6- Afficher la liste des reservations");
    }

    public static void main(){
        Hotel.createChamber();
        AffichageMenu();
        Client roger = new Client("Delcourt","Roger","0321251474");
        Client monique = new Client("Martin","Monique","0147853695");
        Hotel.clients.add(roger);
        Hotel.clients.add(monique);

        Scanner sc = new Scanner(System.in);
        int choix =  sc.nextInt();
        while (choix != 0){
            switch (choix){
                case 1:
                    System.out.println("Quelle est votre nom");
                    String nom =  sc.next();
                    System.out.println("Quelle est votre prenom");
                    String prenom = sc.next();
                    System.out.println("Quelle est votre numero de télephone?");
                    String phone =  sc.next();
                    Hotel.addClient(nom,prenom,phone);
                    break;
                case 2:
                    Hotel.showClients();
                    break;
                case 3:
                    System.out.println("Quelle est votre numero de télephone?");
                    String telephone =  sc.next();
                    Hotel.reservationClient(telephone);
                    break;
                case 4:
                    System.out.println("Quelle est votre numero client?");
                    int numeroClient = sc.nextInt();
                    System.out.println("Pour combien de personnes?");
                    int nbOccupants =  sc.nextInt();
                    Hotel.addReservation(numeroClient,nbOccupants);
                    break;
                case 5:
                    System.out.println("Quelle est votre numero de reservation ?");
                    int numeroReservation = sc.nextInt();
                    Hotel.deleteReservation(numeroReservation);
                    break;
                case 6:
                    Hotel.showReservation();
                    break;
                default:
                    System.out.println("Choix incorrect, veuillez reasseyer");
            }
            AffichageMenu();
            choix =  sc.nextInt();
        }
    }
}

