// Handler interface
abstract class SupportLevel {
    protected SupportLevel next;
    public void setNext(SupportLevel nextHandler) {
        this.next = nextHandler;
    }
    public abstract void handleRequest(int level);
}
// Level 1 handler
class FrontDesk extends SupportLevel {
    public void handleRequest(int level) {
        if (level == 1) {
            System.out.println("Front Desk handled the request.");
        } else if (next != null) {
            next.handleRequest(level);
        }
    }
}
// Level 2 handler
class TeamLead extends SupportLevel {
    public void handleRequest(int level) {
        if (level == 2) {
            System.out.println("Team Lead handled the request.");
        } else if (next != null) {
            next.handleRequest(level);
        }
    }
}
// Level 3 handler
class Manager extends SupportLevel {
    public void handleRequest(int level) {
        if (level == 3) {
            System.out.println("Manager handled the request.");
        } else {
            System.out.println("Request could not be handled.");
        }
    }
}
// Main class
public class ChainOfResponsibilityDemo {
    public static void main(String[] args) {
        // Create handlers
        SupportLevel frontDesk = new FrontDesk();
        SupportLevel teamLead = new TeamLead();
        SupportLevel manager = new Manager();

        // Set up the chain
        frontDesk.setNext(teamLead);
        teamLead.setNext(manager);

        // Test with different levels
        frontDesk.handleRequest(1); // Handled by FrontDesk
        frontDesk.handleRequest(2); // Handled by TeamLead
        frontDesk.handleRequest(3); // Handled by Manager
        frontDesk.handleRequest(4); // No one can handle
    }
}