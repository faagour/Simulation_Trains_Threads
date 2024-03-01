package train1;

/**
 * La classe Main sert de point d'entrée pour l'application de gestion de trains sur une ligne de chemin de fer.
 * Elle initialise une ligne de chemin de fer avec des stations et des sections, crée des trains, et les fait démarrer.
 * Elle illustre l'utilisation des classes du package pour modéliser le déplacement des trains de manière sûre.
 * 
 * @author Fabien Dagnat
 */
public class Main {
    
    /**
     * Le point d'entrée principal de l'application.
     * Initialise les stations, les sections de ligne, la ligne de chemin de fer, et des trains.
     * Démarre les trains sur la ligne de chemin de fer en respectant les contraintes de positionnement.
     * 
     * @param args Les arguments de la ligne de commande (non utilisés dans cette application).
     */
    public static void main(String[] args) {
        // Initialisation des stations et des sections de la ligne de chemin de fer
        Station A = new Station("GareA", 3);
        Station D = new Station("GareD", 3);
        Section AB = new Section("AB");
        Section BC = new Section("BC");
        Section CD = new Section("CD");
        Railway r = new Railway(new Element[] { A, AB, BC, CD, D });

        // Affichage de la configuration de la ligne de chemin de fer
        System.out.println("The railway is:");
        System.out.println("\t" + r);

        // Initialisation de la position des trains et création des trains
        Position p = new Position(A, Direction.LR);
        try {
            Train t1 = new Train("1", p);
            Train t2 = new Train("2", p);
            Train t3 = new Train("3", p);

            // Affichage des informations des trains
            System.out.println(t1);
            System.out.println(t2);
            System.out.println(t3);

            // Démarrage des threads des trains
            Thread t1_tr = new Thread(t1);
            Thread t2_tr = new Thread(t2);
            Thread t3_tr = new Thread(t3);
            t1_tr.start();
            t2_tr.start();
            t3_tr.start();
            
        } catch (BadPositionForTrainException e) {
            // Gestion des erreurs de positionnement des trains
            System.out.println("Le train " + e.getMessage());
        }
    }
}
