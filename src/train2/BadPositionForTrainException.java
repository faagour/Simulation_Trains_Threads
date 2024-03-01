package train2;

/**
 * Exception personnalisée indiquant qu'un train a été initialisé ou déplacé à une position invalide dans le système.
 * Cette exception est lancée pour signaler que la position spécifiée pour un train n'est pas conforme aux règles
 * définies pour les positions valides, par exemple, un train qui n'est pas initialisé dans une gare.
 * <p>
 * L'utilisation de cette exception permet de gérer spécifiquement les cas où les trains sont mal positionnés, 
 * facilitant ainsi le débogage et l'assurance de la cohérence du système de gestion des trains.
 * </p>
 *
 * @author L'auteur
 */
public class BadPositionForTrainException extends Exception {
    private static final long serialVersionUID = 1L;
    
    /**
     * Construit une instance de {@code BadPositionForTrainException} avec le nom du train comme message.
     * Le nom du train est utilisé pour identifier de manière unique le train impliqué dans l'erreur de positionnement.
     * 
     * @param name Le nom du train qui a été mal positionné.
     */
    public BadPositionForTrainException(String name){
        super(name);
    }
    
    /**
     * Retourne le message d'erreur associé à cette exception. Le message d'erreur est le nom du train 
     * qui a été mal positionné, fournissant un contexte utile pour identifier la cause de l'erreur.
     * 
     * @return Le message d'erreur indiquant le nom du train impliqué.
     */
    @Override
    public String getMessage(){
        return super.getMessage();
    }
}
