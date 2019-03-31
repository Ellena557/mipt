import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import static java.util.Arrays.asList;
import static org.junit.jupiter.api.Assertions.*;

class ReflectionUtilsTest extends ReflectionUtils {

    @Test
    public void testGetSuperclass() throws Exception{
        Person myPerson = new Magician();
        Class<?> currentClass = Magician.class;
        List<Class<?>> hierarchyClasses = new ArrayList<>();
        while (currentClass != null){
            hierarchyClasses.add(currentClass);
            currentClass = currentClass.getSuperclass();
        }

        System.out.println(hierarchyClasses);
    }

    @Test
    public void testCollectFielsNames(){
        assertEquals(
                asList("name, age"),
                printAllFields("Alex")

        );
    }
}