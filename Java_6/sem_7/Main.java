import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws NullPointerException{

        try {
            new FileInputStream("file.txt");
            System.out.println("1");
        }
        catch (FileNotFoundException e){
            System.out.println("2");
            throw new RuntimeException("Can't calculate risk metrics", e);
        }
        finally {
            System.out.println("3");
            doSomeAction();
        }
    }

    private static void run4(){
        FileOutputStream stream = null;
        try {
            stream = new FileOutputStream("f1.txt");
            stream.write(12);
            // stream.close();
            // Опасно вызывать close внутри try! -> перемещаем в finally
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        finally {
            if (stream != null) {
                try {
                    stream.close();
                } catch (IOException ignore) {
                    //throw new RuntimeException(e);
                }
            }
        }
    }

    private static void run5(){
        try (Resource stream = new Resource()){
            System.out.println("try");
            throw new IllegalArgumentException();
        }
        catch (NullPointerException e){
            System.out.println("catch");
        }
        finally {
            System.out.println("finally");
        }

        System.out.println("end");
    }

    private static void doSomeAction(){

    }

    public static void run(){
        int x = 10;
        int y = 0;

        int z = x / y;

        System.out.println(z);
    }

    public static void run2() {
        String s = null;

        s.hashCode();
    }

    public static int sqrt(int n) {
        if(n<0) throw new IllegalArgumentException("Argument must be positive, current one is negative");
        return sqrt(n);
    }
}
