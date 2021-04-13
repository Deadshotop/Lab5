package commands;

import managers.HashTableManager;
import managers.IOManager;
import product.Product;

public class ReplaceIfLowe extends AbstractCommand{

    private IOManager manager;

    public ReplaceIfLowe(String name, HashTableManager products, IOManager manager) {
        super(name, products);
        this.manager = manager;
    }

    @Override
    public void execute() {
        Integer key = manager.getKey();
        if (key != null) {
            if (products.findKey(key)) {
                Product product = manager.getProduct();
                if (product != null) {
                    products.replaceIfLowe(key, product);
                } else {
                    System.out.println("Incorrect data in script");
                }
            } else {
                System.out.println("Not found this key in collection");
            }
        }

    }
}
