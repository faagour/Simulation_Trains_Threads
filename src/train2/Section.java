package train2;

/**
 * Représentation d'une section de voie ferrée. C'est une sous-classe de la
 * classe {@link Element}. Cette classe modélise une section de voie sur laquelle
 * les trains peuvent se déplacer. Chaque section peut être occupée par un seul train à la fois.
 * La classe gère l'état d'occupation de la section et assure la synchronisation pour l'accès
 * sécurisé en environnement multithread.
 */
public class Section extends Element {
    private boolean train; // Indicateur d'occupation de la section par un train

    /**
     * Constructeur pour créer une nouvelle section de voie ferrée.
     * @param name Le nom de la section de voie ferrée.
     */
    public Section(String name) {
        super(name);
        this.train = false; // Initialisation à false, indiquant qu'aucun train n'occupe la section
    }

    /**
     * Retourne si un train occupe actuellement la section.
     * @return Vrai (true) si un train occupe la section, faux (false) sinon.
     */
    public boolean getTrain() {
        return this.train;
    }

    /**
     * Simule l'utilisation de la section par un train. Affiche un message et met en pause le thread
     * pour simuler le temps de passage du train.
     */
    @Override
    public synchronized void usage() {
        try {
            Thread.sleep(6000); // Simule le délai de traversée de la section par un train
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt(); // Gestion de l'interruption du thread
        }
    }

    /**
     * Marque le départ d'un train de la section, libérant celle-ci pour un autre train.
     */
    @Override
    public synchronized void left() {
        this.train = false; // Réinitialise l'indicateur d'occupation de la section
        notifyAll(); // Notifie les autres threads en attente de libération de la section
    }

    /**
     * Vérifie si l'entrée d'un train dans la section est autorisée. Dans cette implémentation,
     * la méthode retourne toujours false, indiquant qu'une logique supplémentaire est nécessaire
     * pour gérer l'autorisation.
     * @return Toujours false dans cette implémentation.
     */
    @Override
    public boolean allowed() {
        return false;
    }

    // Les méthodes suivantes sont prévues pour être implémentées avec une logique spécifique
    // pour gérer l'arrivée, le départ, et le suivi des trains dans la section. Elles nécessitent
    // une implémentation pour fournir une fonctionnalité complète.

    @Override
    public boolean isTraincoming() {
        return false; // À implémenter
    }

    @Override
    public void removeTrainGone() {
        // À implémenter
    }

    @Override
    public void addTrainGone() {
        // À implémenter
    }

    @Override
    public int getTrainGone() {
        return 0; // À implémenter
    }

    @Override
    public void setIsTrainComing(boolean b) {
        // À implémenter
    }

    @Override
    public void arrivedTrain() {
        // À implémenter
    }

    @Override
    public void addTrain() {
        // À implémenter
    }

    @Override
    public void addTrainComing() {
        // À implémenter
    }

    @Override
    public void removeTrainComing() {
        // À implémenter
    }
}
