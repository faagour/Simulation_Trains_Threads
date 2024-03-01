package train0;

/**
 * Exception personnalisée indiquant une mauvaise position pour un train sur la ligne de chemin de fer.
 * Cette exception est levée lorsqu'un train tente de se positionner sur un élément non autorisé ou occupé
 * par un autre train.
 */
public class BadPositionForTrainException extends Exception {
    // Identifiant unique pour la sérialisation.
    private static final long serialVersionUID = 1L;
    
    /**
     * Constructeur de l'exception avec le message spécifiant la cause de l'erreur de positionnement.
     * @param name Le message d'erreur décrivant la mauvaise position du train.
     */
    public BadPositionForTrainException(String name){
        super(name);
    }
    
    /**
     * Retourne le message d'erreur associé à cette exception.
     * Cette méthode surcharge {@link java.lang.Exception#getMessage()} pour fournir le message spécifique
     * à l'exception {@link BadPositionForTrainException}.
     * @return Le message d'erreur détaillant la cause de l'exception.
     */
    public String getMessage(){
        return super.getMessage();
    }
}
