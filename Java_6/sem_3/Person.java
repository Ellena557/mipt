import java.util.*;

public class Person {
    public final String name;
    private final int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public static void main(String[] args) {
        System.out.println(new Person("Alex", 10).hashCode());
        System.out.println(new Person("Alex", 10).hashCode());
        System.out.println(new Person("Bob", 10).hashCode());
        //Prints 3 different numbers

        Person alex = new Person("Alex", 10);
        System.out.println(alex.hashCode());
        System.out.println(alex.hashCode());

        String s1 = new String("Lol");
        String s2 = new String("Lol");

        System.out.println(s1 == s2);
        System.out.println(s1.equals(s2));

        //Поэтому лучше писать так:

        String ss1 = "Lol";
        String ss2 = "Lol";

        Map<String, Integer> map = new HashMap<>();
        map.put(s1, 10);

        Integer integer = map.get(s2);

        /*Person p = new Person("Alex", 15);
        Person p2 = new Person("Alex", 15);
        map.put(p, 12);
        Integer integer2 = map.get(p2);*/

        Map<String, Integer> map1 = new HashMap<>();
        for (int i = 0; i < 10; i++) {
            map.put(String.valueOf(i), i);
        }

        for (Map.Entry<String, Integer> entry : map.entrySet()){
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
        Map<String, Integer> map2 = new LinkedHashMap<>();
        Map<String, Integer> map3 = new TreeMap<>();


    }

    @Override
    public int hashCode(){
        return Objects.hash(name, age);
    }

    @Override
    public boolean equals(Object o){
        if (this == o) return true;

        if (o == null || o.getClass() != getClass()) return false;
        Person person = (Person) o;
        return age == person.age && Objects.equals(name, person.name);
        //return age == person.age && name.equalsIgnoreCase(person.name);
    }


}
