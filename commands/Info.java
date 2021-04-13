package commands;

import managers.HashTableManager;

public class Info extends AbstractCommand {

    public Info(String name, HashTableManager products) {
        super(name, products);
    }

    @Override
    public void execute() {
        System.out.println("Type: Product\n" + "Initialization date: " + products.getDate() + "\nSize: " + products.size());
    }
}
