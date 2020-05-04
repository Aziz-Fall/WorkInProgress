import java.io.Serializable;

/**
 * This interface represent all methods that can move a figure.
 */
public interface Deplacement extends Serializable {
    public void moveUp(int offset);
    public void moveDown(int offset);
    public void moveLeft(int offset);
    public void moveRight(int offset);
}
