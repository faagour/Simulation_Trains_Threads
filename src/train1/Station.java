package train1;

/**
 * Classe représentant une gare dans le système de gestion des trains.
 * Hérite de la classe {@link Element} et ajoute des spécificités propres aux gares,
 * telles que le nombre de quais disponibles. Cette classe permet de gérer l'arrivée
 * et le départ des trains au sein d'une gare, en s'assurant qu'il y a suffisamment de place.
 * 
 * @author Fabien Dagnat <fabien.dagnat@imt-atlantique.fr>
 * @author Philippe Tanguy <philippe.tanguy@imt-atlantique.fr>
 */
public class Station extends Element {
    private final int size; // Nombre de quais disponibles dans la gare
    private int train; // Nombre de trains actuellement dans la gare

    /**
     * Construit une nouvelle instance de gare avec un nom et une taille spécifiés.
     * 
     * @param name Le nom de la gare.
     * @param size Le nombre de quais de la gare, c'est-à-dire le nombre de trains
     *             qu'elle peut accueillir simultanément.
     * @throws NullPointerException si le nom est null ou la taille est inférieure ou égale à zéro.
     */
    public Station(String name, int size) {
        super(name);
        if(name == null || size <= 0)
            throw new NullPointerException("Le nom ne peut pas être null et la taille doit être supérieure à 0.");
        this.size = size;
    }

    /**
     * Vérifie si un train supplémentaire peut être accueilli dans la gare.
     * 
     * @return true si la gare a au moins un quai disponible, false sinon.
     */
    public boolean allowed() {
        return train < size;
    }

    /**
     * Gère l'arrivée d'un train à la gare. Incrémente le nombre de trains dans la gare
     * et simule l'utilisation d'un quai pendant un certain temps.
     */
    @Override
    public void usage() {
        train++;
        try {
            Thread.sleep(6000); // Simule l'arrêt du train pendant un certain temps
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * Gère le départ d'un train de la gare. Décrémente le nombre de trains présents dans la gare.
     */
    @Override    
    public void left() {
        train--;
    }
}
