public class ContainerImpl<T> implements Container {
    private Object o;

    @Override
    public void set(Object o) {
        this.o = o;
    }

    @Override
    public Object get() {
        return o;
    }

}
