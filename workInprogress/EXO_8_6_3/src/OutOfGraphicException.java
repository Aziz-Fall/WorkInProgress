import java.io.IOException;

public class OutOfGraphicException extends IOException {
    public OutOfGraphicException(){
        System.out.println("Coordinates is out of the window :|");
    }
    public static void checkData(int x, int y, int width, int heigh) throws OutOfGraphicException {
        if( x >= width || y >= heigh ){
            throw new OutOfGraphicException();
        }else if( x <= 0 || y <= 0){
            throw new OutOfGraphicException();
        }
    }
}
