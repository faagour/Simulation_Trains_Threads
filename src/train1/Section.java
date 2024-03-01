package train1;

/**
 * Représente une section de voie ferrée dans le système de gestion de trains.
 * Cette classe étend {@link Element} pour inclure les spécificités d'une section de ligne,
 * telles que la présence ou non d'un train. Une section est conçue pour être une partie intermédiaire
 * de la ligne de chemin de fer, entre les gares.
 * 
 * @author Fabien Dagnat <fabien.dagnat@imt-atlantique.fr>
 * @author Philippe Tanguy <philippe.tanguy@imt-atlantique.fr>
 */
public class Section extends Element {
    private boolean train; // Indique si un train est présent sur la section

    /**
     * Constructeur pour créer une nouvelle section de voie ferrée.
     * 
     * @param name Le nom de la section.
     */
    public Section(String name) {
        super(name);
        this.train = false;
    }

    /**
     * Renvoie l'état de la section, indiquant si un train est présent ou non.
     * 
     * @return vrai si un train est présent sur la section, faux autrement.
     */
    public boolean getTrain() {
        return train;
    }

    /**
     * Gère l'occupation de la section par un train. Affiche un message à l'arrivée
     * d'un train et met le thread en pause pour simuler le temps passé sur la section.
     */
    @Override
    public synchronized void usage() {
        try {
            Thread.sleep(6000); // Simule l'utilisation de la section
        } catch (InterruptedException e) {
            // Gestion de l'interruption du thread
        }
    }

    /**
     * Gère le départ d'un train de la section. Affiche un message lorsqu'un train
     * quitte la section et met à jour l'état pour indiquer qu'aucun train n'est présent.
     */
    @Override
    public synchronized void left() {
        train = false; // Mise à jour de l'état pour indiquer qu'aucun train n'est présent
        notifyAll(); // Notifie les threads en attente de la libération de la section
    }

    /**
     * Détermine si un train peut entrer sur la section. Cette méthode doit être implémentée
     * pour respecter la signature de la classe parente, mais n'est pas utilisée dans cette implémentation.
     * 
     * @return toujours faux dans cette implémentation.
     */
    @Override
    protected boolean allowed() {
        // Implémentation spécifique requise
        return false;
    }
}
