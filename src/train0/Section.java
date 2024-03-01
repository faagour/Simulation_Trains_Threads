package train0;

/**
 * Classe représentant une section de ligne de chemin de fer dans le système de gestion des trains.
 * Cette classe étend {@link Element} pour implémenter le comportement spécifique d'une section de voie ferrée.
 * Une section peut être occupée par un seul train à la fois.
 */
public class Section extends Element {
    // Indicateur de présence d'un train dans cette section.
    private boolean trainExist;

    /**
     * Constructeur pour créer une nouvelle section de voie ferrée avec un nom spécifique.
     * Par défaut, la section est initialisée sans train.
     * @param name Le nom de la section de la voie ferrée.
     */
    public Section(String name) {
        super(name); // Appel au constructeur de la superclasse pour initialiser le nom de la section.
        trainExist = false; // Initialement, aucun train n'est présent dans la section.
    }

    /**
     * Retourne si un train est présent dans cette section ou non.
     * @return Vrai si un train occupe la section, faux autrement.
     */
    public boolean getTrain() {
        return trainExist; // État de présence d'un train dans la section.
    }

    /**
     * Méthode synchronisée simulant l'utilisation d'une section par un train.
     * Lorsqu'un train entre dans cette section, cette méthode est appelée pour simuler l'occupation.
     * Le thread est mis en sommeil pour simuler le temps de passage.
     */
    @Override
    public synchronized void usage() {
        try {
            Thread.sleep(6000); // Simule le temps de passage du train dans la section.
            trainExist = true; // Marque la section comme occupée par un train.
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt(); // Restaure l'état d'interruption.
        }
    }

    /**
     * Méthode synchronisée pour simuler le départ d'un train de cette section.
     * Après l'appel de cette méthode, le train a quitté la section et elle est libérée pour d'autres trains.
     */
    @Override
    public synchronized void left() {
        trainExist = false; // Marque la section comme libre, aucun train n'est présent.
        notifyAll(); // Notifie tous les threads en attente que la section est désormais libre.
    }
}
