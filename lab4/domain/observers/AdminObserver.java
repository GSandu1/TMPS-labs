package domain.observers;

import domain.interfaces.Observer;

public class AdminObserver implements Observer {
    private String adminName;

    public AdminObserver(String adminName) {
        this.adminName = adminName;
    }

    @Override
    public void update(String message) {
        System.out.println(adminName + " received a notification: " + message);
    }
}
