import java.util.*;

// Aggregate (Collection)
interface Container {
    Iterator<String> getIterator();
}

// Concrete Aggregate
class NameRepository implements Container {
    private String[] names = {"Alice", "Bob", "Charlie"};

    @Override
    public Iterator<String> getIterator() {
        return new NameIterator();
    }

    // Concrete Iterator
    private class NameIterator implements Iterator<String> {
        int index = 0;

        @Override
        public boolean hasNext() {
            return index < names.length;
        }

        @Override
        public String next() {
            if (hasNext()) {
                return names[index++];
            }
            return null;
        }
    }
}

// Client
public class IteratorDemo {
    public static void main(String[] args) {
        NameRepository repo = new NameRepository();
        Iterator<String> iter = repo.getIterator();

        while (iter.hasNext()) {
            System.out.println("Name: " + iter.next());
        }
    }
}