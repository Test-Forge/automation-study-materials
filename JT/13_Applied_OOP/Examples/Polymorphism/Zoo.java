package Examples.Polymorphism;

public class Zoo {
    public static void main(String[] args) {

        Dog rocky = new Dog();
        rocky.fetch();
        // inherited method makeSound()
        rocky.makeSound();
        feed(rocky);

        Animal sasha = new Dog();
        // as an instance of Dog class will be executed the overridden makeSound() method of Dog class
        sasha.makeSound();
        feed(sasha);

        sasha = new Cat();
        // as an instance of Cat class will be executed the overridden makeSound() method of Cat class
        sasha.makeSound();
        ((Cat) sasha).scratch();
        feed(sasha);

    }

    public static void feed(Animal animal) {

        if (animal instanceof Dog) {
            System.out.println("here's your dog food");
        } else if (animal instanceof Cat) {
            System.out.println("here's your cat food");
        }
    }
}
