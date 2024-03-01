package train0;

/**
 * Classe représentant un circuit de chemin de fer, composé d'une série d'éléments tels que des gares et des sections de voie.
 * Cette classe stocke et gère un ensemble d'éléments constituant le circuit.
 */
public class Railway {
    // Tableau stockant les éléments du circuit (gares et sections de voie).
    private final Element[] elements;

    /**
     * Constructeur qui initialise le circuit avec un ensemble d'éléments.
     * Chaque élément du circuit est lié à ce circuit via la méthode setRailway.
     * @param elements Tableau des éléments (gares et sections de voie) qui composent le circuit.
     * @throws NullPointerException si le tableau d'éléments est null.
     */
    public Railway(Element[] elements) {
        if (elements == null)
            throw new NullPointerException("Le tableau d'éléments ne peut pas être null.");

        this.elements = elements;
        // Associe ce circuit à chaque élément du tableau.
        for (Element e : elements)
            e.setRailway(this);
    }

    /**
     * Génère une représentation sous forme de chaîne de caractères du circuit,
     * montrant la séquence des éléments qui le composent.
     * @return Une chaîne représentant la séquence des éléments du circuit.
     */
    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        boolean first = true; // Indicateur pour le premier élément (pas de préfixe "--").
        for (Element e : this.elements) {
            if (first)
                first = false;
            else
                result.append("--"); // Séparateur entre les éléments.
            result.append(e.toString()); // Ajoute la représentation de l'élément à la chaîne.
        }
        return result.toString();
    }

    /**
     * Retourne le tableau des éléments constituant le circuit.
     * @return Le tableau d'éléments du circuit.
     */
    public Element[] getElements() {
        return this.elements;
    }
}
