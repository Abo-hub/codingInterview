package com.sun.stackandqueue.dogcat;

public class Main {

    public static void main(String[] args) {

        DogCatQueue dc = new DogCatQueue();
        Dog dog1 = new Dog();
        Dog dog2 = new Dog();
        Dog dog3 = new Dog();
        Cat cat1 = new Cat();
        Cat cat2 = new Cat();
        dc.add(cat1);
        dc.add(dog1);
        dc.add(cat2);
        dc.add(dog2);
        dc.add(dog3);
        System.out.println(dc.isCatQueueEmpty());
        System.out.println(dc.isDogQueueEmpty());
        System.out.println(dc.pollAll().getPetType());
        System.out.println(dc.pollAll().getPetType());
        System.out.println(dc.pollCat().getPetType());


    }
}