package train0;

/**
 * Classe représentant une gare dans le système de trains. 
 * Hérite de {@link Element} pour implémenter le comportement spécifique d'une gare.
 */
public class Station extends Element {

    /**
     * Constructeur qui crée une nouvelle gare avec un nom spécifique.
     * @param name Le nom de la gare.
     */
    public Station(String name) {
        super(name); // Appel au constructeur de la classe parent pour initialiser le nom.
    }

    /**
     * Méthode synchronisée simulant l'usage d'une gare par un train.
     * Lorsqu'un train arrive à la gare, cette méthode est appelée pour simuler un arrêt du train.
     * Le thread est mis en sommeil pour simuler le temps d'arrêt dans la gare.
     */
    @Override
    public synchronized void usage() {
        try {
            Thread.sleep(6000); // Simule le temps d'arrêt du train dans la gare.
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt(); // Restaure l'état d'interruption.
        }
    }

    /**
     * Méthode synchronisée pour simuler le départ d'un train de la gare.
     * Après l'appel de cette méthode, le train a quitté la gare et la place est libérée pour d'autres trains.
     */
    @Override
    public synchronized void left() {
        notifyAll(); // Notifie tous les threads en attente que le train a quitté la gare.
    }
}
