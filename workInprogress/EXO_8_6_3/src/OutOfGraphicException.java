import java.io.IOException;

/**
 * This class manage out of graphic exception when a the coordinate of figure
 * is out window.
 */
public class OutOfGraphicException extends IOException {
    public OutOfGraphicException(Figure f) {
        System.out.println("Coordinates of " + f.getClass().getName() + " is out of the window :|");
    }
}
