import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;

public class Main {
    public static void main(String[] args) {
    }

    public static void run() {
        List<Integer> integers = Arrays.asList(5, 7, 18, 19);
        integers.sort((o1, o2) -> o2.compareTo(o1));

        System.out.println(integers);
    }

    public List<Child> collectChildren(List<Parent> parents){
        Set<Child > kids = new LinkedHashSet<Child>();
        for(Parent parent : parents){
            Child child = parent.child;
            if (child.age >= 18) {
                kids.add(child);
            }
        }
        return new ArrayList<>(kids);
    }

    public List<Child> collectChildren2(List<Parent> parents, Predicate<Child> childPredicate){
        return parents.stream()
                .map(parent -> parent.child)
                .filter(childPredicate)
                .distinct()
                .collect(Collectors.toList());
    }

    public List<Child> collectChildren3(List<Parent> parents){
        return parents.stream()
                .map(parent -> parent.child)
                .filter(child -> child.name.equals("Alex"))
                .distinct()
                .collect(Collectors.toList());
    }

    public void run2(){
        List<Parent> parents = new ArrayList<>();

        List<Child> children = collectChildren2(parents, olderthan(18));
        List<Child> children1 = collectChildren2(parents, withName("Alex"));
        List<Child> children2 = collectChildren2(parents, withName("Alex").and(olderthan(20)));
    }

    private Predicate<Child> olderthan(int age){
        return c -> c.age >= age;
    }

    private Predicate<Child> withName(String name){
        return c-> c.name.equals(name);
    }

    public double avgChildAge(List<Parent> parents){
        return parents.stream()
                .map(Parent::getChild)
                .distinct()
                .map(Child::getAge)
                .mapToInt(Integer::intValue)
                .average()
                //.getAsDouble();
                .orElse(0);
    }

    /**
     * Подсчет детей с одинаковым именем
     * @return число детей с одинаковым именем
     */
    public Map<String, Long> childNameToCount(List<Parent> parents){
        return parents.stream()
                .map(Parent::getChild)
                .distinct()
                .collect(groupingBy(Child::getName, counting()));
    }

    public void points() {
        List<Point> points = new ArrayList<>();

        points.stream()
                .reduce(Point::plus)
                .get();
    }

    /**
     * Task: next 3 methods need to be implemented.
     */

    public Child oldest(List<Parent> parents){
        return parents.stream()
                .map(parent -> parent.getChild())
                .distinct()
                .max(Comparator.comparing(Child::getAge))
                .get();
    }

    public List<Parent> parentsOf(String childName, List<Parent> parents){
        return parents.stream()
                .filter(parent -> parent.getChild().getName().equals(childName))
                .distinct()
                .collect(Collectors.toList());
    }

    public List<Parent> parentsOfOldest(String child, List<Parent> parents){
        Child oldestChild = oldest(parents);
        return parentsOf(oldestChild.getName(), parents);
    }
}
