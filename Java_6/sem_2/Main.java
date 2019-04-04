package ru.sberbank;

import shop.Order;
import shop.Person;

import java.util.Date;

public class Main {
    public static void main(String[] args) {
        Order order = new Order(100, new Date(), 17, 40, 7);
        order.printinfo();

        double summ = order.getSum();
        double summ2 = order.sum;
        //System.out.println(summ + " " + summ2);

        int i = 10;
        Integer i2 = new Integer(10);

        Person person = new Person("Alex");
        rename(person);
        System.out.println(person.getName());
    }

    public static void rename(Person person){
        person = new Person("Ben");
    }
}
