import java.io.Serializable;

public interface Deplacement extends Serializable {
    public void moveUp(int offset);
    public void moveDown(int offset);
    public void moveLeft(int offset);
    public void moveRight(int offset);
}
