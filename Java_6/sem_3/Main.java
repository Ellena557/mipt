import java.util.*;

public class Main {
    public static void main(String[] args) {
        String[] strings = new String[10];
        List l1 = new ArrayList(20);
        List l2 = new LinkedList();

        l1.add(45); //Амортизированная стоимость: O(1)
        l1.add(2, 35);

        Queue queue;
        Deque deque = new LinkedList();
        Deque deque2 = new ArrayDeque(); //works faster than LinkedList

        Map map = new HashMap();
        Map map2 = new LinkedHashMap();
        Map map3 = new TreeMap();
        map.put("1212", 123);
        Object o = map.get("1212");

    }
}
