package train1;

/**
 * La classe {@code Railway} représente un circuit ferroviaire, composé d'éléments de voie ferrée tels que des gares ou des sections de voie. 
 * Cette classe permet de modéliser le circuit sur lequel les trains peuvent se déplacer, en assurant que chaque élément du circuit est 
 * correctement initialisé et relié au circuit lui-même.
 * <p>
 * Un circuit est défini par une séquence d'éléments, commençant et se terminant par une gare, avec des sections de voie uniquement sur la 
 * partie intermédiaire. Chaque élément est conscient du circuit auquel il appartient grâce à l'initialisation réalisée dans le constructeur.
 * </p>
 * 
 * @author Fabien Dagnat <fabien.dagnat@imt-atlantique.fr>
 * @author Philippe Tanguy <philippe.tanguy@imt-atlantique.fr>
 */
public class Railway {
    private final Element[] elements;

    /**
     * Construit un nouveau circuit ferroviaire avec les éléments spécifiés.
     * Chaque élément du circuit est lié à ce circuit dès sa création.
     * 
     * @param elements le tableau d'éléments ({@code Element[]}) qui composent le circuit. 
     *                 Ne doit pas être {@code null}.
     * @throws NullPointerException si le tableau d'éléments est {@code null}.
     */
    public Railway(Element[] elements) {
        if (elements == null)
            throw new NullPointerException("Le tableau d'éléments ne peut pas être null.");

        this.elements = elements;
        for (Element e : elements)
            e.setRailway(this);
    }

    /**
     * Retourne une représentation sous forme de chaîne de caractères du circuit ferroviaire.
     * Cette représentation inclut tous les éléments du circuit, séparés par des tirets pour 
     * indiquer les connections entre eux.
     * 
     * @return la représentation textuelle du circuit.
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
     * Retourne le tableau d'éléments qui composent ce circuit.
     * 
     * @return un tableau d'{@code Element} qui représente les éléments du circuit.
     */
    public Element[] getElements() {
        return this.elements;
    }
}
