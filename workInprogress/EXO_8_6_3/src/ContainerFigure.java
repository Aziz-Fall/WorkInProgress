import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.util.Map;

/**
 * This class represent the component that contain all figures
 * and the component is the main component.
 */
public class ContainerFigure extends JPanel {
    private int mWidth,
                mHeight;

    Map<String, Figure> mFigures = new HashMap<>();

    public ContainerFigure(){
        mWidth  = 500;
        mHeight = 500;
    }

    public ContainerFigure(int width, int height){
        this.mHeight = height;
        this.mWidth  = width;
    }


    /**
     * This method draw all figures on the component that are on the attribute mFigure.
     * @param g the graphic.
     */
    public void paint(Graphics g){
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, this.getWidth(), this.getHeight());

        for (Map.Entry<String, Figure> elt: mFigures.entrySet()) {
            elt.getValue().draw(g);
        }
    }

    /**
     * this method add a figure in the hashMap mFigures.
     * @param f   figure
     * @param key the key of the figure.
     */
    void addFigure(Figure f, String key){
        mFigures.put(key, f);
        repaint();
    }

    /**
     * this method update a figure passed in argument
     * @param f   figure
     * @param key the key of the figure.
     */
    void updateFigure(Figure f, String key){
        try{
            Point p = f.getPoint();
            checkData((int)p.getX(), (int)p.getY(), f);
            mFigures.replace(key, f);
            repaint();
        }catch (OutOfGraphicException e){
            e.printStackTrace();
        }
    }

    /**
     * Check if the coordinate of figure is out of window.
     * @param x abscissa
     * @param y ordinate
     * @param f figure
     * @throws OutOfGraphicException
     */
    public void checkData(int x, int y, Figure f) throws OutOfGraphicException {
        if( x >= mWidth || y >= mHeight ){
            throw new OutOfGraphicException(f);
        }else if( x <= 0 || y <= 0){
            throw new OutOfGraphicException(f);
        }
    }
}
