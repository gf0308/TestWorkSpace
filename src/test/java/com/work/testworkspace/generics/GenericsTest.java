package com.work.testworkspace.generics;

public class GenericsTest {
    public static void main(String[] args) {
        AnimalList<Cat> catAnimalList = new AnimalList<Cat>();
        catAnimalList.add(new Cat());

        AnimalList<Dog> dogAnimalList = new AnimalList<Dog>();
        dogAnimalList.add(new Dog());

        AnimalList.cryingAnimalList(catAnimalList);
        AnimalList.cryingAnimalList(dogAnimalList);

    }


}

class LandAnimal { public void crying() { System.out.println("육지동물"); } }

class Cat extends LandAnimal { public void crying() { System.out.println("냐옹냐옹"); } }

class Dog extends LandAnimal { public void crying() { System.out.println("멍멍"); } }

class Sparrow { public void crying() { System.out.println("짹짹"); } }
