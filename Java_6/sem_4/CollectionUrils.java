import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class CollectionUrils {
    public static <T> T max(List<T> list, Comparator<? super T> comparator){
        T max = list.get(0);
        for(T current : list){
            if (comparator.compare(current, max) > 0){
                max = current;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        List list = Arrays.asList(1212, 4);
        Comparator<Object> comparator = new Comparator<Object>() {
            @Override
            public int compare(Object o1, Object o2) {
                //return Integer.compare(o1, o2);
                return Integer.compare(o1.hashCode(), o2.hashCode());
            }
        };

        System.out.println( max(list, comparator));
    }
}
