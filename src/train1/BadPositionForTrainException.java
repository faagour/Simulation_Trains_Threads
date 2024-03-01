package train1;

/**
 * Exception personnalisée indiquant une position invalide pour un train sur la ligne de chemin de fer.
 * Cette exception est lancée lorsqu'une tentative est faite pour placer un train dans une position
 * qui n'est pas autorisée selon les règles définies pour le mouvement des trains sur la ligne.
 */
public class BadPositionForTrainException extends Exception {
	private static final long serialVersionUID = 1L;
	
	/**
	 * Construit une nouvelle exception avec un message détaillant la raison pour laquelle la position du train est considérée comme mauvaise.
	 * 
	 * @param name Le message détaillant la raison de l'exception.
	 */
	public BadPositionForTrainException(String name){
		super(name);
	}
	
	/**
	 * Récupère le message d'erreur de cette exception. Surcharge la méthode {@code getMessage()} de la classe parent {@code Exception}.
	 * 
	 * @return Le message d'erreur associé à cette exception.
	 */
	@Override
	public String getMessage(){
		return super.getMessage();
	}
}
