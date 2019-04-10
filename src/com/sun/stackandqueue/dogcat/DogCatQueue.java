package com.sun.stackandqueue.dogcat;

import java.util.LinkedList;
import java.util.Queue;

public class DogCatQueue {

    private Queue<PetEnterQueue> dogQ;
    private Queue<PetEnterQueue> catQ;
    private long count;

    public DogCatQueue() {
        this.dogQ = new LinkedList<PetEnterQueue>();
        this.catQ = new LinkedList<PetEnterQueue>();
    }

    public void add(Pet pet) {
        if (pet.getPetType().equals("dog")) {
            dogQ.add(new PetEnterQueue(pet, count++));
        } else if (pet.getPetType().equals("cat")) {
            catQ.add(new PetEnterQueue(pet, count++));
        } else {
            throw new RuntimeException("error,not dog or cat");
        }
    }

    public Pet pollAll() {
        if (!dogQ.isEmpty() && !catQ.isEmpty()) {
            if (dogQ.peek().getCount() < catQ.peek().getCount()) {
                return dogQ.poll().getPet();
            } else {
                return catQ.poll().getPet();
            }
        } else if (!dogQ.isEmpty()) {
            return dogQ.poll().getPet();
        } else if (!catQ.isEmpty()) {
            return catQ.poll().getPet();
        } else {
            throw new RuntimeException("error,queue is empty");
        }
    }

    public Dog pollDog() {
        if (!dogQ.isEmpty()) {
            return (Dog) dogQ.poll().getPet();
        } else {
            throw new RuntimeException("error,dogqueue is empty");
        }
    }

    public Cat pollCat() {
        if (!catQ.isEmpty()) {
            return (Cat) catQ.poll().getPet();
        }else{
            throw new RuntimeException("error,catqueue is empty");
        }
    }

    public boolean isEmpty() {
        return dogQ.isEmpty() && catQ.isEmpty();
    }

    public boolean isDogQueueEmpty(){
        return dogQ.isEmpty();
    }

    public boolean isCatQueueEmpty(){
        return catQ.isEmpty();
    }

}