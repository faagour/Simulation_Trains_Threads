package train0;

/**
 * Classe représentant la position d'un train sur un circuit ferroviaire.
 * Cette classe stocke à la fois l'élément (gare ou section de voie) sur lequel le train se trouve et la direction de son déplacement.
 */
public class Position implements Cloneable {
    private Direction direction; // Direction actuelle du déplacement du train.
    private Element pos; // Élément courant (gare ou section de voie) sur lequel le train se trouve.

    /**
     * Constructeur qui initialise la position avec un élément spécifique et une direction.
     * @param elt L'élément (gare ou section de voie) initial.
     * @param d La direction initiale du train.
     * @throws NullPointerException si l'élément ou la direction est null.
     */
    public Position(Element elt, Direction d) {
        if (elt == null || d == null)
            throw new NullPointerException("L'élément et la direction ne peuvent pas être null.");

        this.pos = elt;
        this.direction = d;
    }

    /**
     * Retourne l'élément actuel (gare ou section de voie) sur lequel le train se trouve.
     * @return L'élément courant.
     */
    public Element getPos() {
        return pos;
    }

    /**
     * Génère une représentation sous forme de chaîne de caractères de la position actuelle.
     * @return Une chaîne représentant l'élément et la direction de la position actuelle.
     */
    @Override
    public String toString() {
        StringBuilder result = new StringBuilder(this.pos.toString());
        result.append(" going ");
        result.append(this.direction);
        return result.toString();
    }

    /**
     * Inverse la direction du train.
     * Change la direction de gauche à droite ou de droite à gauche.
     */
    public void renverserDirection() {
        this.direction = (this.direction == Direction.LR) ? Direction.RL : Direction.LR;
    }

    /**
     * Trouve l'indice d'un élément spécifique dans un tableau d'éléments.
     * @param list Le tableau d'éléments.
     * @param element L'élément à chercher dans le tableau.
     * @return L'indice de l'élément dans le tableau, ou -1 si non trouvé.
     */
    public static int indexOf(Element[] list, Element element) {
        for (int i = 0; i < list.length; i++) {
            if (list[i].getName().equals(element.getName())) {
                return i;
            }
        }
        return -1; 
    }
    
    /**
     * Calcule la prochaine position du train en fonction de sa direction actuelle.
     * @return L'élément suivant sur lequel le train devrait se déplacer.
     */
    public Element nextPosition() {
        Railway railway = pos.getRailway();
        Element[] elements = railway.getElements();
        int index = indexOf(elements, pos);
        
        // Logique pour déterminer la prochaine position basée sur la direction et la position actuelle.
        if (this.direction == Direction.LR) {
            return (this.pos.getName().equals("GareD")) ? elements[index] : elements[index + 1];
        } else {
            return (this.pos.getName().equals("GareA")) ? elements[index] : elements[index - 1];
        }
    }
    
    /**
     * Met à jour l'élément sur lequel le train se trouve.
     * @param element Le nouvel élément (gare ou section de voie) pour le train.
     */
    public void setPosition(Element element) {
        this.pos = element;
    }
}
