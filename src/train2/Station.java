package train2;

/**
 * Représentation d'une gare. C'est une sous-classe de la classe {@link Element}.
 * Une gare est caractérisée par un nom et un nombre de quais (donc de trains
 * qu'elle est susceptible d'accueillir à un instant donné). La classe gère également
 * le suivi des trains en cours d'arrivée et de départ, en assurant la synchronisation nécessaire.
 * 
 * @author Fabien Dagnat <fabien.dagnat@imt-atlantique.fr>
 * @author Philippe Tanguy <philippe.tanguy@imt-atlantique.fr>
 */
public class Station extends Element {
	private final int size; // Nombre de quais disponibles dans la gare.
	private int train; // Nombre de trains actuellement présents dans la gare.
	private boolean is_train_coming; // Indicateur si un train est en cours d'arrivée.
	private int trains_gone; // Nombre total de trains qui ont quitté la gare.
	private int train_coming; // Nombre de trains annoncés à venir.

	/**
	 * Constructeur de la gare.
	 * Initialise une gare avec un nom et une capacité spécifiée par le nombre de quais.
	 * 
	 * @param name Le nom de la gare.
	 * @param size Le nombre de quais de la gare.
	 * @throws NullPointerException si le nom est null ou si la taille est inférieure ou égale à 0.
	 */
	public Station(String name, int size) {
		super(name);
		if (name == null || size <= 0)
			throw new NullPointerException("Name cannot be null and size must be greater than 0.");
		this.size = size;
		this.is_train_coming = false;
		this.train_coming = 0;
	}

	/**
	 * Vérifie si l'ajout d'un train est autorisé en fonction de la capacité actuelle.
	 * 
	 * @return true si l'ajout d'un train est possible, false sinon.
	 */
	public boolean allowed() {
		return train + train_coming < size;
	}

	/**
	 * Retourne le nombre de trains actuellement dans la gare.
	 * 
	 * @return Le nombre actuel de trains dans la gare.
	 */
	public int getTrain() {
		return train;
	}

	/**
	 * Indique si un train est en cours d'arrivée à la gare.
	 * 
	 * @return true si un train est en cours d'arrivée, false sinon.
	 */
	public boolean isTraincoming() {
		return is_train_coming;
	}

	/**
	 * Définit si un train est en cours d'arrivée à la gare.
	 * 
	 * @param is_train_coming État d'arrivée du train.
	 */
	public void setIsTrainComing(boolean is_train_coming) {
		this.is_train_coming = is_train_coming;
	}

	/**
	 * Retourne le nombre de trains qui ont quitté la gare.
	 * 
	 * @return Le nombre de trains partis.
	 */
	public int getTrainGone() {
		return trains_gone;
	}

	/**
	 * Incrémente le compteur de trains qui ont quitté la gare.
	 */
	public void addTrainGone() {
		this.trains_gone++;
	}

	/**
	 * Décrémente le compteur de trains qui ont quitté la gare, si supérieur à 0.
	 */
	public void removeTrainGone() {
		if (this.trains_gone > 0) {
			this.trains_gone--;
		}
	}

	/**
	 * Incrémente le compteur de trains en cours d'arrivée à la gare.
	 */
	public void addTrainComing() {
		this.train_coming++;
	}

	/**
	 * Décrémente le compteur de trains en cours d'arrivée à la gare, si supérieur à 0.
	 */
	public void removeTrainComing() {
		if (this.train_coming > 0) {
			this.train_coming--;
		}
	}

	/**
	 * Méthode appelée lors de l'utilisation de la gare. Simule une action en affichant un message
	 * et en effectuant une pause.
	 */
	@Override
	public void usage() {
		try {
			Thread.sleep(6000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Ajoute un train à la gare, en incrémentant le nombre de trains présents.
	 */
	public void addTrain() {
		train++;
	}

	/**
	 * Retire un train de la gare, en décrémentant le nombre de trains présents.
	 */
	@Override
	public void left() {
		train--;
	}

	/**
	 * Gère l'arrivée d'un train à la gare, en réinitialisant l'indicateur d'arrivée de train et en
	 * notifiant tous les threads en attente qu'un train est arrivé.
	 */
	public  void arrivedTrain() {
		this.setIsTrainComing(false);
	}
}
