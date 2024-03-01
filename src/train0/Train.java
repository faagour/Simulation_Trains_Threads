package train0;

/**
 * Classe représentant un train devant se déplacer sur une ligne de chemin de fer.
 * Implemente {@link Runnable} pour permettre à chaque train de s'exécuter dans son propre fil d'exécution.
 */
public class Train implements Runnable {

    // Position actuelle du train sur la ligne.
    private final Position pos;
    
    /**
     * Constructeur qui initialise le train avec une position initiale.
     * @param p La position initiale du train sur la ligne.
     * @throws BadPositionForTrainException Si la position initiale spécifiée est invalide.
     * @throws NullPointerException Si la position fournie est null.
     */
    public Train(Position p) throws BadPositionForTrainException {
        
        if (p == null)
            throw new NullPointerException("La position fournie est null.");

        this.pos = p;
    }
    
    /**
     * Fait avancer le train vers la prochaine position sur la ligne.
     * Met à jour la position actuelle du train à sa position suivante.
     */
    public void continuer() {
        pos.setPosition(pos.nextPosition());
    }
    
    /**
     * Inverse la direction du train.
     * Utilisé pour changer la direction du train lorsqu'il atteint une gare.
     */
    public void stop() {
        pos.renverserDirection();
    }

    /**
     * Méthode exécutée lors du démarrage du thread du train.
     * Contient la logique de déplacement et de gestion des positions du train sur la ligne.
     */
    @Override
    public void run() {
        while (true) { // Boucle infinie pour simuler le déplacement continu du train.
            if (pos.nextPosition().getName().contains("Gare")) {
                // Logique spécifique lorsqu'un train arrive à une gare.
                this.continuer();
                pos.getPos().usage(); // Simule l'utilisation de la position actuelle.
                System.out.println("Ça c'est notre position " + pos.getPos());
                pos.getPos().left(); // Libère la position actuelle.
                System.out.println("La prochaine position " + pos.nextPosition());
                this.stop(); // Inverse la direction du train.
            } else {
                // Logique de déplacement standard hors des gares.
                
                this.continuer();
                pos.getPos().usage(); // Simule l'utilisation de la position actuelle.
                pos.getPos().left(); // Libère la position actuelle.
            }
        }
    }
}
