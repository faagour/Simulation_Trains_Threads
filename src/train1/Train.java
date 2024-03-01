package train1;

/**
 * Classe représentant un train dans un système de gestion de trains. Un train est caractérisé par son nom
 * et sa position actuelle sur la ligne, qui comprend une direction. Ce modèle simplifié permet de gérer le
 * déplacement des trains sur un circuit, en s'assurant qu'ils débutent leur trajet depuis une gare et respectent
 * les contraintes de positionnement et de direction.
 * <p>
 * Les instances de cette classe sont capables de changer leur position sur la ligne, de s'arrêter, et de
 * continuer leur déplacement dans le sens inverse. Cette classe implémente {@code Runnable} pour permettre
 * la simulation du déplacement des trains dans un environnement multithreadé.
 * </p>
 * 
 * @author Fabien Dagnat, Mayte Segarra, Philippe Tanguy
 * @version 0.3
 */
public class Train implements Runnable{
    private final String name; // Le nom du train.
    private final Position pos; // La position actuelle du train sur la ligne.

    /**
     * Construit une nouvelle instance de Train avec un nom et une position initiale.
     * Vérifie que le train est initialisé dans une gare.
     * 
     * @param name Le nom du train pour l'identification.
     * @param p La position initiale du train, qui doit être une gare.
     * @throws BadPositionForTrainException Si la position initiale n'est pas une gare.
     * @throws NullPointerException Si le nom ou la position fournie est {@code null}.
     */
    public Train(String name, Position p) throws BadPositionForTrainException {
        if (name == null || p == null)
            throw new NullPointerException();

        if (!(p.getPos() instanceof Station))
            throw new BadPositionForTrainException(name);

        this.name = name;
        this.pos = p.clone();
    }

    /**
     * Retourne une représentation sous forme de chaîne de caractères du train, incluant son nom et sa position actuelle.
     * 
     * @return Une chaîne décrivant le train et sa position.
     */
    @Override
    public String toString() {
        StringBuilder result = new StringBuilder("Train[");
        result.append(this.name);
        result.append("]");
        result.append(" is on ");
        result.append(this.pos);
        return result.toString();
    }

    /**
     * Avance le train à la prochaine position sur la ligne selon sa direction actuelle.
     * Cette méthode modifie la position actuelle du train pour la prochaine position calculée.
     */
    public void continuer() {
        pos.setPosition(pos.nextPosition());
    }

    /**
     * Inverse la direction du train. Cette méthode est utilisée pour simuler l'arrêt du train et son
     * départ dans la direction opposée.
     */
    public void stop() {
        pos.renverserDirection();
    }

    /**
     * Exécute le comportement du train dans un environnement multithreadé. Cette méthode simule le
     * déplacement continu du train, son arrêt dans les gares et son inversion de direction selon certaines conditions.
     * <p>
     * Le train vérifie la prochaine position pour décider de son action, comme attendre si la prochaine position
     * est une gare non disponible ou continuer son déplacement.
     * </p>
     */
    @Override
	public void run() {
		while(true) {
		// TODO Auto-generated method stub
		
		if ( pos.nextPosition().getName().contains("Gare")) {
			while(! pos.nextPosition().allowed()) {
				try{
					wait();
				}catch (InterruptedException ex) {}
			}
			this.continuer();
			this.stop();
			pos.getPos().usage();
			pos.getPos().left();

			
		}
		else {
			
			this.continuer();
			pos.getPos().usage();
			pos.getPos().left();
			
		}

	}

	}
}