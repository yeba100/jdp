// Prototype interface
interface Enemy extends Cloneable {
    Enemy clone();
    void show();
}

// Concrete Prototype
class GameEnemy implements Enemy {
    String type;
    int health;
    int attack;
    String behavior;

    public GameEnemy(String type, int health, int attack, String behavior) {
        this.type = type;
        this.health = health;
        this.attack = attack;
        this.behavior = behavior;
    }

    @Override
    public GameEnemy clone() {
        try {
            return (GameEnemy) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }

    public void show() {
        System.out.println(type + " | HP: " + health + " | ATK: " + attack + " | AI: " + behavior);
    }
}

// Spawner using prototype
public class PrototypePattern{
    public static void main(String[] args) {
        GameEnemy zombiePrototype = new GameEnemy("Zombie", 100, 20, "Aggressive");
        GameEnemy alienPrototype = new GameEnemy("Alien", 150, 30, "Defensive");

        // Clone and tweak
        GameEnemy weakZombie = zombiePrototype.clone();
        weakZombie.health = 50;

        GameEnemy fastAlien = alienPrototype.clone();
        fastAlien.attack = 40;

        // Show enemies
        zombiePrototype.show();
        weakZombie.show();
        alienPrototype.show();
        fastAlien.show();
    }
}