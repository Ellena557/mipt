import java.util.List;

public class ContainerMain {
    public static void main(String[] args) {
        Container container = new ContainerImpl();
        container.set(12);
        Object o = container.get();
    }
    private void add (List<Object> list){
        list.add(12);
        list.add("khuhrq");
    }
}
