package commands;

import managers.HashTableManager;

public class Clear extends AbstractCommand{
    public Clear(String name, HashTableManager products) {
        super(name, products);
    }

    @Override
    public void execute() {
        products.clear();
        System.out.println("Collection is empty");
    }
}
