package com.work.testworkspace.generics;

import java.util.ArrayList;
import java.util.List;

public class AnimalList<T> {
    private List<T> al = new ArrayList<>();

//    private List<T> al;
//    public AnimalList() {
//        this.al = new ArrayList<>();
//    }
//    public AnimalList(List<T> list) {
//        this.al = list;
//    }

    public static void cryingAnimalList(AnimalList<? extends LandAnimal> al) {
        LandAnimal landAnimal = al.get(0);
        landAnimal.crying();
    }

    void add(T animal) {
        this.al.add(animal);
    }

    T get(int index) {
        return this.al.get(index);
    }

    boolean remove(T animal) {
        return this.al.remove(animal);
    }

    int size() {
        return al.size();
    }

}
