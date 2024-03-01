package train2;

import train2.Position;

/**
 * La classe {@code Position} modélise la position d'un train sur une ligne de chemin de fer,
 * en tenant compte de l'élément sur lequel le train se trouve (gare ou section de ligne)
 * et de la direction dans laquelle il se déplace. Cette classe est essentielle pour la gestion
 * des déplacements des trains sur le circuit, en assurant qu'un train puisse être localisé
 * et dirigé de manière précise.
 * <p>
 * Les instances de cette classe sont clonables pour permettre la duplication de positions
 * sans affecter l'original, ce qui est utile dans les calculs de simulation ou de prédiction
 * de mouvements des trains.
 * </p>
 * 
 * @author Fabien Dagnat <fabien.dagnat@imt-atlantique.fr>
 * @author Philippe Tanguy <philippe.tanguy@imt-atlantique.fr>
 * @version 0.3
 */
public class Position implements Cloneable {
    private Direction direction;
    private Element pos;

    /**
     * Construit une nouvelle position avec un élément spécifié et une direction.
     * 
     * @param elt L'élément ({@link Station} ou {@link Section}) sur lequel le train se positionne.
     * @param d La direction de déplacement du train.
     * @throws NullPointerException si l'élément ou la direction sont {@code null}.
     */
    public Position(Element elt, Direction d) {
        if (elt == null || d == null)
            throw new NullPointerException();
        this.pos = elt;
        this.direction = d;
    }

    /**
     * Crée une copie de cette position.
     * 
     * @return Une nouvelle instance de {@code Position} qui est une copie de l'instance actuelle.
     */
    @Override
    public Position clone() {
        try {
            return (Position) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * Renvoie l'élément sur lequel le train est actuellement positionné.
     * 
     * @return L'élément actuel de la position.
     */
    public Element getPos() {
        return pos;
    }

    /**
     * Fournit une représentation textuelle de la position, incluant l'élément et la direction.
     * 
     * @return Une chaîne de caractères décrivant la position.
     */
    @Override
    public String toString() {
        return pos.toString() + " going " + direction;
    }

    /**
     * Inverse la direction de déplacement du train.
     * Si la direction était de gauche à droite, elle devient de droite à gauche, et vice-versa.
     */
    public void renverserDirection() {
        this.direction = (this.direction == Direction.LR) ? Direction.RL : Direction.LR;
    }

    /**
     * Trouve l'indice d'un élément dans un tableau d'éléments.
     * 
     * @param list Le tableau d'éléments à parcourir.
     * @param element L'élément à trouver.
     * @return L'indice de l'élément dans le tableau, ou -1 si l'élément n'est pas trouvé.
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
     * 
     * @return L'élément suivant sur lequel le train se déplacera.
     */
    public Element nextPosition() {
        Railway railway = pos.getRailway();
        Element[] elements = railway.getElements();
        int index = indexOf(elements, pos);
        
        if (this.direction == Direction.LR) {
            return (pos.getName().equals("GareD")) ? elements[index] : elements[index + 1];
        } else {
            return (pos.getName().equals("GareA")) ? elements[index] : elements[index - 1];
        }
    }

    /**
     * Met à jour la position actuelle du train avec un nouvel élément.
     * 
     * @param element Le nouvel élément sur lequel positionner le train.
     */
    public void setPosition(Element element) {
        this.pos = element;
    }
}
