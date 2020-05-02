import javax.swing.*;
import java.awt.*;

public class Main
{
       public static void main(String[] args) {
        Window w  = new Window("Dessin");
        Figure f1 = new Circle(new Point(45, 50), Color.BLUE, 20);
        Figure f2 = new Rectangle(new Point(300, 400), Color.DARK_GRAY, 80, 30);
        w.getContainerFigure().addFigure(f1, "f1");
        w.getContainerFigure().addFigure(f2, "f2");

        w.waitSomeSeconds(500);

        f1.moveDown(50);
        f2.moveUp(50);
        w.getContainerFigure().updateFigure(f1, "f1");
        w.getContainerFigure().updateFigure(f2, "f2");

    }
}
