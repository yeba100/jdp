import java.util.*;

// Component
interface Graphic {
    void draw();
}

// Leaf
class Circle implements Graphic {
    public void draw() {
        System.out.println("Drawing a Circle");
    }
}

// Composite
class Drawing implements Graphic {
    private List<Graphic> children = new ArrayList<>();

    public void add(Graphic g) {
        children.add(g);
    }

    public void draw() {
        for (Graphic g : children) {
            g.draw();
        }
    }
}

// Usage
public class CompositeDemo {
    public static void main(String[] args) {
        Circle c1 = new Circle();
        Circle c2 = new Circle();

        Drawing drawing = new Drawing();
        drawing.add(c1);
        drawing.add(c2);

        drawing.draw();
    }
}
