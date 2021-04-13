package commands;

import managers.HashTableManager;

public class Exit extends AbstractCommand{

    public Exit(String name, HashTableManager products) {
        super(name, products);
    }

    @Override
    public void execute() {
        setExit(true);
    }
}
