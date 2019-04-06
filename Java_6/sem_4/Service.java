import java.util.Arrays;
import java.util.List;

public class Service {
    public int process(List<Integer> list){
        /*Object o = list.get(0);
        Object o2 = list.get(1);*/
        /*Integer o = (Integer) list.get(0);
        Integer o2 = (Integer) list.get(1);*/

        Integer o = list.get(0);
        Integer o2 = list.get(1);

        return o + o2;
    }

    public static void main(String[] args) {
        new Service().process(Arrays.asList(1, 2));
    }
}
