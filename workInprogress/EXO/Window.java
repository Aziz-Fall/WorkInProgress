import javax.swing.*;
import java.awt.*;

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
}
