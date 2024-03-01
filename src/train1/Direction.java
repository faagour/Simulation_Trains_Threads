package train1;

/**
 * Enumération représentant la direction que peut prendre un train sur une ligne de chemin de fer.
 * Les trains peuvent se déplacer soit de gauche à droite (LR) soit de droite à gauche (RL).
 * Cette énumération permet de définir de manière explicite le sens du déplacement d'un train
 * et est utilisée pour contrôler la direction du déplacement des trains sur une ligne.
 * <p>
 * Chaque direction possède une méthode {@code toString()} surchargée permettant de retourner une
 * représentation textuelle de la direction, facilitant ainsi la lecture et la compréhension du sens
 * de déplacement du train.
 * </p>
 * 
 * <ul>
 * <li>{@code LR} - Représente la direction de gauche à droite.</li>
 * <li>{@code RL} - Représente la direction de droite à gauche.</li>
 * </ul>
 * 
 * @author Fabien Dagnat
 * @author Philippe Tanguy
 */
public enum Direction {
    /**
     * Direction de gauche à droite sur la ligne de chemin de fer.
     */
    LR {
        @Override
        public String toString() {
            return "from left to right";
        }
    },

    /**
     * Direction de droite à gauche sur la ligne de chemin de fer.
     */
    RL {
        @Override
        public String toString() {
            return "from right to left";
        }
    };
}
