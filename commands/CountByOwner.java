package commands;

import managers.HashTableManager;
import managers.IOManager;
import product.Person;

public class CountByOwner extends AbstractCommand{
    private IOManager manager;

    public CountByOwner(String name, HashTableManager products, IOManager manager) {
        super(name, products);
        this.manager = manager;
    }

    @Override
    public void execute() {
        Person owner = manager.getOwner();
        if (owner != null) {
            System.out.println(products.countByOwner(owner));
        }
    }
}
