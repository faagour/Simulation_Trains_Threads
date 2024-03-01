package train1;

/**
 * Représente un élément abstrait d'un circuit ferroviaire, servant de superclasse pour différents types d'éléments
 * du circuit tels que les gares et les sections de voie. Cette classe abstraite définit les attributs et méthodes
 * de base communs à tous les éléments, tels que la gestion de l'appartenance à un circuit (Railway) et le nom de l'élément.
 * Elle impose également la définition de comportements spécifiques à chaque type d'élément via des méthodes abstraites.
 */
public abstract class Element {
    protected final String name; // Le nom de l'élément
    private Railway railway; // Le circuit auquel l'élément appartient

    /**
     * Constructeur pour un élément de circuit.
     * 
     * @param name Le nom de l'élément. Ne doit pas être null.
     * @throws NullPointerException si le nom est null.
     */
    protected Element(String name) {
        if(name == null)
            throw new NullPointerException("Le nom ne peut pas être null.");
        
        this.name = name;
    }

    /**
     * Associe cet élément à un circuit ferroviaire.
     * 
     * @param r Le circuit à associer. Ne doit pas être null.
     * @throws NullPointerException si le circuit est null.
     */
    public void setRailway(Railway r) {
        if(r == null)
            throw new NullPointerException("Le circuit ne peut pas être null.");
        
        this.railway = r;
    }

    /**
     * Retourne le circuit ferroviaire auquel cet élément est associé.
     * 
     * @return Le circuit associé à cet élément.
     */
    public Railway getRailway() {    
        return this.railway ;
    }

    /**
     * Retourne le nom de cet élément.
     * 
     * @return Le nom de cet élément.
     */
    public String getName() {    
        return this.name ;
    }

    /**
     * Retourne une représentation sous forme de chaîne de caractères de cet élément.
     * 
     * @return Le nom de cet élément sous forme de chaîne de caractères.
     */
    @Override
    public String toString() {
        return this.name;
    }

    /**
     * Méthode abstraite définissant l'utilisation de cet élément par un train.
     */
    public abstract void usage();

    /**
     * Méthode abstraite permettant de vérifier si l'utilisation de cet élément est autorisée.
     * 
     * @return true si l'utilisation est autorisée, false sinon.
     */
    protected abstract boolean allowed();

    /**
     * Méthode abstraite définissant l'action à effectuer lorsqu'un train quitte cet élément.
     */
    public abstract void left();
}
