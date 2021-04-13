package commands;

import managers.HashTableManager;

public class MinByCreationDate extends AbstractCommand{
    public MinByCreationDate(String name, HashTableManager products) {
        super(name, products);
    }

    @Override
    public void execute() {
        System.out.println(products.minByCreationDate());
    }
}
