// MediatorPatternExample.java

interface ChatMediator {
    void showMessage(User user, String message);
}

//Concrete Mediator
class ChatRoom implements ChatMediator {
    public void showMessage(User user, String message) {
        System.out.println(user.getName() + ": " + message);
    }
}

//Colleague (User)
class User {
    private String name;
    private ChatMediator mediator;

    public User(String name, ChatMediator mediator) {
        this.name = name;
        this.mediator = mediator;
    }

    public String getName() {
        return name;
    }

    public void sendMessage(String message) {
        mediator.showMessage(this, message);
    }
}

//Main class to test
public class MediatorPatternExample{
    public static void main(String[] args) {
        ChatMediator chatRoom = new ChatRoom();

        User user1 = new User("Alice", chatRoom);
        User user2 = new User("Bob", chatRoom);

        user1.sendMessage("Hi Bob!");
        user2.sendMessage("Hey Alice, how are you?");
    }
}