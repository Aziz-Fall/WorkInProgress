import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

/**
 * This class serialize a data and put them in a file.
 */
public class SerializeDrawing{

    /**
     * This static method serialize a figure passed in argument
     * and put them in the name's file passed in argument
     * @param f        the figure
     * @param nameFile name file
     */
    public static void setData(Figure f, String nameFile){
        ObjectOutputStream oos = null;
        try {
            System.out.println("Serialisation");
            FileOutputStream fileOut = new FileOutputStream(nameFile);
            oos = new ObjectOutputStream(fileOut);
            oos.writeObject(f);
        }catch (IOException e){
            System.out.println(e.getMessage());
        }finally {
            try{
                if( oos != null){
                    oos.close();
                }
            }catch (IOException e){
                System.out.println(e.getMessage());
            }
        }
    }
}
