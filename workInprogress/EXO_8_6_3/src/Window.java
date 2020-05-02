import javax.swing.*;
import java.awt.*;
import java.io.Serializable;

public class Window extends JFrame{
    private static int sWIDTH  = 700;
    private static int sHEIGHT = 700;

    private ContainerFigure mContainerFigure;

    public Window(String name){
        super(name);
        mContainerFigure = new ContainerFigure();
        this.setResizable(false);
        this.setSize(new Dimension(sWIDTH, sHEIGHT));
        this.setDefaultCloseOperation(Window.EXIT_ON_CLOSE);
        this.setContentPane(mContainerFigure);
        this.setVisible(true);
    }

    public ContainerFigure getContainerFigure() {
        return mContainerFigure;
    }

    public void setContainerFigure(ContainerFigure containerFigure) {
        mContainerFigure = containerFigure;
    }

    public void waitSomeSeconds(long second){
        try{
            Thread.sleep(second);
        }catch (InterruptedException e){
            System.out.println(e.getMessage());
        }
    }
    public static void main(String[] args) {
        Window w  = new Window("Dessin");
        Figure f1 = new Circle(new Point(45, 50), Color.BLUE, 20);
        Figure f2 = new Rectangle(new Point(300, 400), Color.DARK_GRAY, 80, 30);
        w.getContainerFigure().addFigure(f1, "f1");
        w.getContainerFigure().addFigure(f2, "f2");

        w.waitSomeSeconds(500);

        f1.moveDown(50);
        f1.moveRight(100);
        f2.moveUp(50);
        f2.moveLeft(1000);

        w.getContainerFigure().updateFigure(f1, "f1");
        w.getContainerFigure().updateFigure(f2, "f2");

        SerializeDrawing.setData(f1, "figure.txt");
        Figure f = DeserializationDrawing.getData("figure.txt");
        System.out.println(f);
    }
}
