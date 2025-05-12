// Abstract Products
interface Animal { void sound(); }
interface Plant { void grow(); }

// Concrete Products
class Dog implements Animal { public void sound() { System.out.println("Bark"); } }
class Cat implements Animal { public void sound() { System.out.println("Meow"); } }

class Grass implements Plant { public void grow() { System.out.println("Grass growing"); } }
class Tree implements Plant { public void grow() { System.out.println("Tree growing"); } }

// Abstract Factory
interface EcosystemFactory {
    Animal createAnimal();
    Plant createPlant();
}

// Concrete Factories
class ForestFactory implements EcosystemFactory {
    public Animal createAnimal() { return new Dog(); }
    public Plant createPlant() { return new Tree(); }
}

class UrbanFactory implements EcosystemFactory {
    public Animal createAnimal() { return new Cat(); }
    public Plant createPlant() { return new Grass(); }
}

// Client
public class AbstractFactory {
    public static void main(String[] args) {
        EcosystemFactory factory = new ForestFactory();
        factory.createAnimal().sound();
        factory.createPlant().grow();

        factory = new UrbanFactory();
        factory.createAnimal().sound();
        factory.createPlant().grow();
    }
}