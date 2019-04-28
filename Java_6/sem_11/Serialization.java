import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class Serialization {
    public static void main(String[] args) throws IOException {
        Person person = new Person("Alex", 20);

        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("person.bytes"));
        oos.writeObject(person);
    }
}
