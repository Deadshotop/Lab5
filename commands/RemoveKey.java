package commands;

import managers.HashTableManager;
import managers.IOManager;

public class RemoveKey extends AbstractCommand{
    private IOManager manager;

    public RemoveKey(String name, HashTableManager products, IOManager manager) {
        super(name, products);
        this.manager = manager;
    }

    @Override
    public void execute() {
        Integer key = manager.getKey();
        if (key != null){
            if (!products.removeByKey(key)) {
                System.out.println("Not found this key in collection");
            }
        }
    }
}
