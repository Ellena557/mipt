import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class ReflectionUtils {

    public static List <String> printAllFields(Object o){
        List<String> result = new ArrayList<>();
        Class<?> clazz = o.getClass();
        Class<?> superclass = clazz.getSuperclass();
        while (clazz != null) {
            Field[] declaredFields = clazz.getDeclaredFields();
            for (Field f : declaredFields){
                result.add(f.getName());
            }
            clazz = clazz.getSuperclass();
        }
        return result;
    }

    public static void main(String[] args) {
        printAllFields("Hello");
    }
}
