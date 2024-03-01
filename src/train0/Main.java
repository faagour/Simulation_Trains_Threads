package train0;

/**
 * Classe principale pour la simulation de déplacement de trains sur un chemin de fer.
 * Cette classe initialise les composants du chemin de fer, crée un train, et lance le déplacement du train.
 */
public class Main {
    public static void main(String[] args) {
        // Création des stations aux extrémités de la ligne.
        Station A = new Station("GareA");
        Station D = new Station("GareD");

        // Création des sections de voie entre les gares.
        Section AB = new Section("AB");
        Section BC = new Section("BC");
        Section CD = new Section("CD");

        // Création du chemin de fer avec les éléments précédemment créés.
        Railway r = new Railway(new Element[] { A, AB, BC, CD, D });

        // Affichage de la structure du chemin de fer.
        System.out.println("The railway is:");
        System.out.println("\t" + r);

        // Initialisation de la position du train à la gare A, direction vers la droite (LR).
        Position p = new Position(A, Direction.LR);

        try {
            // Création d'un train à la position initiale définie.
            Train t1 = new Train(p);
            // Affichage de la position initiale du train.
            System.out.println(t1);

            // Création d'un thread pour le train et démarrage du thread.
            // Cela permet au train de se déplacer de manière asynchrone.
            Thread t1_tr = new Thread(t1);
            t1_tr.start();
        } catch (BadPositionForTrainException e) {
            // Gestion des exceptions liées à une mauvaise position initiale du train.
            System.out.println("Le train " + e.getMessage());
        }
    }
}
