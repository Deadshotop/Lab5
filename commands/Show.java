package commands;

import managers.HashTableManager;

public class Show extends AbstractCommand{
    public Show(String name, HashTableManager products) {
        super(name, products);
    }

    @Override
    public void execute() {
        System.out.println(products.print());
    }
}
