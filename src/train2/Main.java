package train2;

/**
 * La classe Main initialise et lance une simulation de mouvement de trains sur un circuit ferroviaire.
 * Elle crée un circuit avec des gares et des sections de voie, puis initialise et lance des trains sur ce circuit.
 * Les trains sont exécutés dans des threads séparés pour simuler leur déplacement simultané.
 * <p>
 * Cette simulation illustre la création d'un circuit ferroviaire, l'initialisation des positions et des directions des trains,
 * et le démarrage de leur déplacement en utilisant le multithreading.
 * </p>
 * 
 * @author Fabien Dagnat <fabien.dagnat@imt-atlantique.fr>
 */
public class Main {
    public static void main(String[] args) {
        // Initialisation des gares et des sections de la voie
        Station A = new Station("GareA", 3);
        Station D = new Station("GareD", 3);
        Section AB = new Section("AB");
        Section BC = new Section("BC");
        Section CD = new Section("CD");
        Railway r = new Railway(new Element[]  { A, AB, BC, CD, D });

        // Affichage du circuit ferroviaire créé
        System.out.println("The railway is:");
        System.out.println("\t" + r);

        // Initialisation des positions et des directions des trains
        Position p = new Position(A, Direction.LR);
        Position p2 = new Position(D, Direction.RL);

        try {
            // Création et démarrage des trains
            Train t1 = new Train("1", p, A, D);
            Train t2 = new Train("2", p, A, D);
            Train t3 = new Train("3", p2, D, A);

            // Affichage des informations des trains
            System.out.println(t1);
            System.out.println(t2);
            System.out.println(t3);

            // Démarrage des threads des trains pour simuler leur mouvement
            Thread t1_tr = new Thread(t1);
            Thread t2_tr = new Thread(t2);
            Thread t3_tr = new Thread(t3);
            t1_tr.start();
            t2_tr.start();
            t3_tr.start();
        } catch (BadPositionForTrainException e) {
            // Gestion des exceptions pour positions invalides des trains
            System.out.println("Le train " + e.getMessage());
        }
    }
}
