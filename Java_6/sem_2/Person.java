package shop;

public class Person {
    private String name;
    private String secondName;

    public Person(String name) {
        this.name = name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString(){
        return name + " " + secondName;
    }
}
