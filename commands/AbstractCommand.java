package commands;

import managers.HashTableManager;
/**
 * Абстрактная команда
 */
public abstract class AbstractCommand implements Command{
    protected final String name;
    protected HashTableManager products;
    protected boolean exit;

    public AbstractCommand(String name, HashTableManager products) {
        this.name = name;
        this.products = products;
        exit = false;
    }

    @Override
    public boolean isExit() {
        return exit;
    }

    public void setExit(boolean exit) {
        this.exit = exit;
    }
}
