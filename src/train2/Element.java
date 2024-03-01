package train2;

/**
 * Classe abstraite représentant un élément de base d'un circuit ferroviaire. Cette classe
 * sert de superclasse pour factoriser les fonctionnalités communes à ses sous-classes,
 * notamment la gestion de l'entrée et de la sortie d'un train, ainsi que l'appartenance à un circuit.
 * Les éléments dérivés de cette classe comprennent les gares et les sections de voie ferrée.
 * 
 * <p>Les sous-classes concrètes doivent implémenter les méthodes abstraites définies ici pour gérer
 * spécifiquement l'usage, l'arrivée, le départ, et la présence de trains.</p>
 * 
 * <p>Les sous-classes directes incluent :</p>
 * <ol>
 *   <li>La représentation d'une gare : {@link Station}</li>
 *   <li>La représentation d'une section de voie ferrée : {@link Section}</li>
 * </ol>
 * 
 * @author Fabien Dagnat <fabien.dagnat@imt-atlantique.fr>
 * @author Philippe Tanguy <philippe.tanguy@imt-atlantique.fr>
 */
public abstract class Element {
    protected final String name; // Nom de l'élément
    private Railway railway; // Circuit auquel appartient l'élément

    /**
     * Constructeur pour initialiser un nouvel élément avec un nom.
     * 
     * @param name Le nom de l'élément. Ne doit pas être null.
     * @throws NullPointerException si le nom est null.
     */
    protected Element(String name) {
        if (name == null)
            throw new NullPointerException("Le nom de l'élément ne peut pas être null.");
        this.name = name;
    }

    /**
     * Associe cet élément à un circuit ferroviaire.
     * 
     * @param r Le circuit à associer. Ne doit pas être null.
     * @throws NullPointerException si le circuit est null.
     */
    public void setRailway(Railway r) {
        if (r == null)
            throw new NullPointerException("Le circuit ne peut pas être null.");
        this.railway = r;
    }

    /**
     * Retourne le circuit auquel cet élément appartient.
     * 
     * @return Le circuit associé.
     */
    public Railway getRailway() {
        return this.railway;
    }

    /**
     * Retourne le nom de cet élément.
     * 
     * @return Le nom de l'élément.
     */
    public String getName() {
        return this.name;
    }

    /**
     * Fournit une représentation sous forme de chaîne de cet élément.
     * 
     * @return Le nom de l'élément.
     */
    @Override
    public String toString() {
        return this.name;
    }

    // Méthodes abstraites que les sous-classes doivent implémenter.

    public abstract void usage();
    public abstract boolean allowed();
    public abstract void left();
    public abstract boolean isTraincoming();
    public abstract void removeTrainGone();
    public abstract void addTrainGone();
    public abstract int getTrainGone();
    public abstract void setIsTrainComing(boolean b);
    public abstract void arrivedTrain();
    public abstract void addTrain();
    public abstract void addTrainComing();
    public abstract void removeTrainComing();
}
