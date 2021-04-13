package commands;

import managers.HashTableManager;
import managers.IOManager;

public class RemoveLowerKey extends AbstractCommand{
    private IOManager manager;

    public RemoveLowerKey(String name, HashTableManager products, IOManager manager) {
        super(name, products);
        this.manager = manager;
    }

    @Override
    public void execute() {
        Integer key = manager.getKey();
        if (key != null) {
            products.removeLowerKey(key);
        }
    }
}
