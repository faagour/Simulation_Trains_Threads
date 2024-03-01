package train2;

/**
 * Représentation d'un circuit constitué d'éléments de voie ferrée : gare ou
 * section de voie. Cette classe permet la création d'un circuit ferroviaire
 * et le placement des éléments qui le composent. Chaque élément peut être une
 * gare contenant plusieurs quais ou une section de ligne qui connecte ces gares.
 * Les éléments sont disposés de manière linéaire pour former un chemin complet.
 * 
 * @author Fabien Dagnat
 * @author Philippe Tanguy
 */
public class Railway {
    private final Element[] elements; // Tableau contenant les éléments du circuit

    /**
     * Constructeur pour créer un nouveau circuit ferroviaire.
     * Initialise le circuit avec un ensemble d'éléments fournis.
     * Chaque élément du circuit est lié à ce circuit par appel de la méthode setRailway.
     * 
     * @param elements Un tableau d'éléments qui constitueront le circuit ferroviaire.
     * @throws NullPointerException si le tableau d'éléments est null.
     */
    public Railway(Element[] elements) {
        if(elements == null)
            throw new NullPointerException("Le tableau d'éléments ne peut pas être null.");
        
        this.elements = elements;
        for (Element e : elements)
            e.setRailway(this);
    }

    /**
     * Retourne une représentation sous forme de chaîne de caractères du circuit ferroviaire.
     * Les éléments du circuit sont représentés les uns à la suite des autres, séparés par "--".
     * 
     * @return Une chaîne de caractères représentant les éléments du circuit.
     */
    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        boolean first = true;
        for (Element e : this.elements) {
            if (first)
                first = false;
            else
                result.append("--");
            result.append(e);
        }
        return result.toString();
    }

    /**
     * Retourne le tableau d'éléments qui composent le circuit ferroviaire.
     * 
     * @return Le tableau d'éléments du circuit.
     */
    public Element[] getElements() {
        return this.elements;
    }

    /**
     * Gère le déplacement en avant des trains sur le circuit de manière synchronisée.
     * Cette méthode permet de faire avancer les trains sur le circuit, en respectant
     * les règles de sécurité et d'occupation des éléments (gares et sections de ligne).
     * Elle assure que chaque train avance de manière sûre vers l'élément suivant du circuit,
     * en gérant les conditions d'attente nécessaires pour éviter les collisions.
     * 
     * @param T Le train à faire avancer sur le circuit.
     */
    public synchronized void continueForward(Train T) {
        // TODO Auto-generated method stub
        if((T.getPos().nextPosition().getName()).contains("Gare")) {
            T.getStart_station().removeTrainGone();
            if(T.getStart_station().getTrainGone()<=0) {
                T.getStart_station().arrivedTrain();
                notifyAll();
            }
            T.getGoal_station().removeTrainComing();

        } else if((T.getPos().getPos().getName()).contains("Gare")) {
            while ((T.getGoal_station().isTraincoming())||!(T.getGoal_station().allowed())) {
                try {                   
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            
            T.getStart_station().addTrainGone();
            T.getStart_station().setIsTrainComing(true);
            T.getStart_station().left();
            T.getGoal_station().addTrainComing();
        }
    }
}
