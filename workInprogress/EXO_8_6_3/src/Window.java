import javax.swing.*;
import java.awt.*;
import java.io.Serializable;

/**
 * This class represent the Window of our application.
 */
public class Window extends JFrame{
    private static int sWIDTH  = 700;
    private static int sHEIGHT = 700;

    private ContainerFigure mContainerFigure;

    /**
     * The constructor of the window
     * @param name name of the window.
     */
    public Window(String name){
        super(name);

        mContainerFigure = new ContainerFigure(sWIDTH, sHEIGHT);

        this.setResizable(false);
        this.setSize(new Dimension(sWIDTH, sHEIGHT));
        this.setDefaultCloseOperation(Window.EXIT_ON_CLOSE);
        this.setContentPane(mContainerFigure);
        this.setVisible(true);
    }

    /**
     * Return component container of the figure
     * @return a component.
     */
    public ContainerFigure getContainerFigure() {
        return mContainerFigure;
    }

    /**
     * the method modified the component ContainerFigure.
     * @param containerFigure a component
     */
    public void setContainerFigure(ContainerFigure containerFigure) {
        mContainerFigure = containerFigure;
    }

    /**
     * Wait some seconds before to repaint the component ContainerFigure.
     * @param second the number of second to wait.
     */
    public void waitSomeSeconds(long second){
        try{
            Thread.sleep(second);
        }catch (InterruptedException e){
            System.out.println(e.getMessage());
        }
    }

    public static void main(String[] args) {
        //Instantiation and initialization of the window
        Window w  = new Window("Dessin");

        //Instantiation and initialization of figures.
        Figure f1 = new Circle(new Point(45, 50), Color.BLUE, 20);
        Figure f2 = new Rectangle(new Point(300, 400), Color.DARK_GRAY, 80, 30);
        Figure f3 = new Square(new Point(500, 400), Color.GREEN, 100);

        //Add figure in the component ContainerFigure.
        w.getContainerFigure().addFigure(f1, "f1");
        w.getContainerFigure().addFigure(f2, "f2");
        w.getContainerFigure().addFigure(f3, "f3");

        w.waitSomeSeconds(500);

        //Move Down and Right figure f1
        f1.moveDown(50);
        f1.moveRight(100);

        //Move Down and Right figure f2
        f2.moveUp(50);
        f2.moveLeft(100); 

        //Move Down and Right figure f3
        f3.moveLeft(50);
        f3.moveUp(20);

        //Updating all figure that are modified.
        w.getContainerFigure().updateFigure(f1, "f1");
        w.getContainerFigure().updateFigure(f2, "f2");
        w.getContainerFigure().updateFigure(f3, "f3");

        //Serialization of figure f1 (Circle ).
        SerializeDrawing.setData(f1, "figure.txt");

        //Deserialization of figure f1 (Circle).
        Figure f = DeserializationDrawing.getData("figure.txt");

        //the description of the figure f (toString()).
        System.out.println(f);
    }
}
