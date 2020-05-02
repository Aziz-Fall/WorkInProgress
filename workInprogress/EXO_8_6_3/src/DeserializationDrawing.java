import java.awt.*;
import java.io.*;

public class DeserializationDrawing {

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
