
// Product interface
interface Product {
    void operation();
}

// Concrete Products
class ConcreteProductA implements Product {
    @Override
    public void operation() {
        System.out.println("ConcreteProductA operation");
    }
}

class ConcreteProductB implements Product {
    @Override
    public void operation() {
        System.out.println("ConcreteProductB operation");
    }
}

// Creator (Factory) abstract class
abstract class Creator {
    // Factory Method
    abstract Product createProduct();

    void someOperation() {
        Product product = createProduct();
        product.operation();
    }
}

// Concrete Creators
class ConcreteCreatorA extends Creator {
    @Override
    Product createProduct() {
        return new ConcreteProductA();
    }
}

class ConcreteCreatorB extends Creator {
    @Override
    Product createProduct() {
        return new ConcreteProductB();
    }
}

// Client code
public class FactoryMethodDemo {
    public static void main(String[] args) {
        Creator creator = new ConcreteCreatorA();
        creator.someOperation();

        creator = new ConcreteCreatorB();
        creator.someOperation();
    }
}