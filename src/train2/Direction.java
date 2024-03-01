package train2;

/**
 * Énumération représentant les directions possibles pour le déplacement d'un train.
 * Cette énumération est utilisée pour spécifier la direction dans laquelle un train se déplace
 * sur la ligne, soit de gauche à droite, soit de droite à gauche. Chaque direction est définie
 * avec une méthode {@code toString} surchargée pour fournir une représentation textuelle
 * explicite de la direction.
 * 
 * Les directions disponibles sont :
 * - LR : De gauche à droite
 * - RL : De droite à gauche
 * 
 * Ces valeurs peuvent être utilisées pour définir le sens de déplacement d'un train sur une ligne
 * et pour prendre des décisions en fonction de la direction du train dans le système de gestion des trains.
 * 
 * @author Fabien Dagnat <fabien.dagnat@imt-atlantique.fr>
 * @author Philippe Tanguy <philippe.tanguy@imt-atlantique.fr>
 */
public enum Direction {
    /**
     * Représente la direction de gauche à droite pour le déplacement d'un train.
     * Cette direction indique que le train se déplace le long de la ligne
     * du point de vue de l'observateur, de la gauche vers la droite.
     */
    LR {
        @Override
        public String toString() {
            return "from left to right";
        }
    },

    /**
     * Représente la direction de droite à gauche pour le déplacement d'un train.
     * Cette direction indique que le train se déplace le long de la ligne
     * du point de vue de l'observateur, de la droite vers la gauche.
     */
    RL {
        @Override
        public String toString() {
            return "from right to left";
        }
    };
}
