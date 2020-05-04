import java.awt.*;
import java.io.*;

/**
 * This class Deserialize a data contained in a file.
 */
public class DeserializationDrawing {
    /**
     * This static method deserialize a figure passed that
     * contained in the file passed in argument
     * @param nameFile name file
     */
    public static Figure getData(String nameFile){
        ObjectInputStream ois = null;
        Figure f              = null;
        try {
            System.out.println("Deserialization");
            FileInputStream fileIn = new FileInputStream(nameFile);
            ois = new ObjectInputStream(fileIn);
            f = (Figure)ois.readObject();
        }catch (IOException e){
            System.out.println(e.getMessage());
        }catch (ClassNotFoundException cE){
            System.out.println(cE.getMessage());
        }finally {
            try{
                if( ois != null){
                    ois.close();
                }
            }catch (IOException e){
                System.out.println(e.getMessage());
            }
        }
        return f;
    }
}
