package train2;

/**
 * Classe représentant un train dans un système de simulation ferroviaire. Un train est caractérisé par son nom et sa position actuelle sur la ligne,
 * ainsi que par sa station de départ et sa station d'arrivée. Cette classe implémente {@code Runnable} pour permettre le déplacement du train
 * de manière concurrente.
 * 
 * @author Fabien Dagnat, Mayte Segarra, Philippe Tanguy
 * @version 0.3
 */
public class Train implements Runnable {
    private static final String Station = null; // Variable non utilisée, à remplacer par une logique appropriée.
    private final String name; // Nom du train.
    private final Position pos; // Position actuelle du train sur la ligne.
    private Element start_station; // Station de départ.
    private Element goal_station; // Station d'arrivée.

    /**
     * Constructeur de la classe Train. Initialise un train avec un nom, une position initiale, une station de départ et une station d'arrivée.
     * Valide que la position initiale est une station.
     * 
     * @param name Nom du train.
     * @param p Position initiale du train.
     * @param gs Station de départ du train.
     * @param gg Station d'arrivée du train.
     * @throws BadPositionForTrainException Si la position initiale n'est pas une station.
     * @throws NullPointerException Si le nom ou la position sont null.
     */
    public Train(String name, Position p, Element gs, Element gg) throws BadPositionForTrainException {
        if (name == null || p == null) throw new NullPointerException();
        if (!(p.getPos() instanceof Station)) throw new BadPositionForTrainException(name);
        this.name = name;
        this.pos = p.clone();
        this.start_station = gs;
        this.goal_station = gg;
        this.start_station.addTrain();
    }

    /**
     * Retourne une représentation textuelle du train, incluant son nom et sa position actuelle.
     * 
     * @return Une chaîne de caractères décrivant le train.
     */
    @Override
    public String toString() {
        return String.format("Train[%s] is on %s", this.name, this.pos);
    }

    /**
     * Fait avancer le train vers l'avant en fonction de sa direction actuelle.
     */
    public void continueForward() {
        this.pos.getPos().getRailway().continueForward(this);
    }

    /**
     * Exécute une action de déplacement, faisant progresser le train vers la prochaine position.
     */
    public void continuer() {
        this.pos.getPos().usage();
        this.pos.setPosition(this.pos.nextPosition());
    }

    /**
     * Retourne le nom du train.
     * 
     * @return Le nom du train.
     */
    public String getName() {
        return this.name;
    }

    /**
     * Retourne la position actuelle du train.
     * 
     * @return La position actuelle du train.
     */
    public Position getPos() {
        return this.pos;
    }

    /**
     * Retourne la station de départ du train.
     * 
     * @return La station de départ.
     */
    public Element getStart_station() {
        return this.start_station;
    }

    /**
     * Retourne la station d'arrivée du train.
     * 
     * @return La station d'arrivée.
     */
    public Element getGoal_station() {
        return this.goal_station;
    }

    /**
     * Définit la station de départ du train.
     * 
     * @param start_station La nouvelle station de départ.
     */
    public void setStart_station(Element start_station) {
        this.start_station = start_station;
    }

    /**
     * Définit la station d'arrivée du train.
     * 
     * @param goal_station La nouvelle station d'arrivée.
     */
    public void setGoal_station(Element goal_station) {
        this.goal_station = goal_station;
    }

    /**
     * Inverse la direction de déplacement du train.
     */
    public void stop() {
        this.pos.renverserDirection();
    }

    /**
     * La logique d'exécution du train, permettant de simuler son déplacement sur la ligne ferroviaire.
     * Ce processus inclut le déplacement vers l'avant, la gestion des changements de direction et la gestion des stations de départ et d'arrivée.
     */
    @Override
    public void run() {
        while (true) {
            if (this.pos.getPos().getName().contains("Gare") || this.pos.nextPosition().getName().contains("Gare")) {
                this.continueForward();
            }
            this.continuer();
            if (this.pos.getPos().getName().contains("Gare")) {
                this.setGoal_station(this.getStart_station());
                this.setStart_station(this.getPos().getPos());
                this.getPos().renverserDirection();
                this.getStart_station().addTrain();
            }
        }
    }
}
