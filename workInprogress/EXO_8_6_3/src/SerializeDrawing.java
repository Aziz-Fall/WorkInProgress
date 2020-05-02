import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class SerializeDrawing{

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
