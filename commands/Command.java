package commands;
/**
 * Интерфейс команды
 */
public interface Command {
    void execute();
    boolean isExit();
}
