package domain.interfaces;

public interface Command {
    void execute();
    void undo();
}
