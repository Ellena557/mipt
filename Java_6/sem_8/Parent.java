public class Parent {
    public Child getChild() {
        return child;
    }

    public Child child;

    public Parent(Child child) {
        this.child = child;
    }
}
