/**
 * We can assure that Mammal is actually an Animal with the use of the instance operator.
 */


class Animal {
}

class Mammal extends Animal {
}

class Reptile extends Animal {
}

public class Dog extends Mammal {

    public static void main(String args[]) {
        Animal a = new Animal();
        Mammal m = new Mammal();
        Dog d = new Dog();

        System.out.println(m instanceof Animal);
        System.out.println(d instanceof Mammal);
        System.out.println(d instanceof Animal);
    }
}

/**
 * On executing the program, you will get the following result:
 * true
 * true
 * true
 */