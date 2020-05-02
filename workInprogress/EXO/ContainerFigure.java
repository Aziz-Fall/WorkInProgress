import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ContainerFigure extends JPanel {
    Map<String, Figure> mFigures = new HashMap<>();

    public void paint(Graphics g){
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, this.getWidth(), this.getHeight());

        for (Map.Entry<String, Figure> elt: mFigures.entrySet()) {
            elt.getValue().draw(g);
        }
    }

    void addFigure(Figure f, String key){
        mFigures.put(key, f);
        repaint();
    }
    void updateFigure(Figure f, String key){
        mFigures.replace(key, f);
        repaint();
    }
}
