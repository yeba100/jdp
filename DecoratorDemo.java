// Component
interface Coffee {
    int cost();
    String getDescription();
}

// Concrete Component
class BasicCoffee implements Coffee {
    public int cost() {
        return 5;
    }

    public String getDescription() {
        return "Basic Coffee";
    }
}

// Decorator
abstract class CoffeeDecorator implements Coffee {
    protected Coffee coffee;

    public CoffeeDecorator(Coffee coffee) {
        this.coffee = coffee;
    }

    public int cost() {
        return coffee.cost();
    }

    public String getDescription() {
        return coffee.getDescription();
    }
}

// Concrete Decorators
class MilkDecorator extends CoffeeDecorator {
    public MilkDecorator(Coffee coffee) {
        super(coffee);
    }

    public int cost() {
        return super.cost() + 2;
    }

    public String getDescription() {
        return super.getDescription() + " + Milk";
    }
}

class SugarDecorator extends CoffeeDecorator {
    public SugarDecorator(Coffee coffee) {
        super(coffee);
    }

    public int cost() {
        return super.cost() + 1;
    }

    public String getDescription() {
        return super.getDescription() + " + Sugar";
    }
}

// Usage
public class DecoratorDemo {
    public static void main(String[] args) {
        Coffee coffee = new BasicCoffee();                   // Basic Coffee
        coffee = new MilkDecorator(coffee);                 // + Milk
        coffee = new SugarDecorator(coffee);                // + Sugar

        System.out.println("Description: " + coffee.getDescription()); // Output: Description: Basic Coffee, Milk, Sugar
        System.out.println("Cost: " + coffee.cost());                  // Output: Cost: 8
    }
}
