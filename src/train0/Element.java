package train0;

/**
 * Classe abstraite représentant un élément de base d'un circuit ferroviaire.
 * Cette classe sert de superclasse pour les éléments spécifiques tels que les gares et les sections de voie ferrée,
 * et fournit des fonctionnalités communes telles que la gestion de l'entrée et de la sortie des trains,
 * ainsi que l'appartenance à un circuit.
 */
public abstract class Element {
    // Nom de l'élément, commun à toutes les sous-classes.
    protected final String name;
    // Référence au circuit auquel l'élément appartient.
    private Railway railway;
    
    /**
     * Constructeur pour initialiser un élément avec un nom.
     * @param name Le nom de l'élément.
     * @throws NullPointerException si le nom fourni est null.
     */
    protected Element(String name) {
        if (name == null)
            throw new NullPointerException("Le nom de l'élément ne peut pas être null.");
        
        this.name = name;
    }

    /**
     * Associe cet élément à un circuit ferroviaire.
     * @param r Le circuit auquel cet élément doit être associé.
     * @throws NullPointerException si le circuit fourni est null.
     */
    public void setRailway(Railway r) {
        if (r == null)
            throw new NullPointerException("Le circuit ne peut pas être null.");
        
        this.railway = r;
    }

    /**
     * Retourne le circuit ferroviaire auquel cet élément appartient.
     * @return Le circuit associé à cet élément.
     */
    public Railway getRailway() {	
        return this.railway;
    }

    /**
     * Retourne le nom de cet élément.
     * @return Le nom de l'élément.
     */
    public String getName() {	
        return this.name;
    }

    /**
     * Fournit une représentation sous forme de chaîne de caractères de cet élément,
     * typiquement son nom.
     * @return Le nom de cet élément.
     */
    @Override
    public String toString() {
        return this.name;
    }

    /**
     * Méthode abstraite pour simuler l'utilisation de cet élément par un train.
     * Doit être implémentée par les sous-classes.
     */
    protected abstract void usage();

    /**
     * Méthode abstraite pour simuler le départ d'un train de cet élément.
     * Doit être implémentée par les sous-classes.
     */
    protected abstract void left();
}
