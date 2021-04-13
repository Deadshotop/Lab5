package commands;

import managers.HashTableManager;
import managers.IOManager;
import product.Product;

public class Insert extends AbstractCommand{

    private IOManager manager;

    public Insert(String name, HashTableManager products, IOManager manager) {
        super(name, products);
        this.manager = manager;
    }

    @Override
    public void execute() {
        Integer key = manager.getKey();
        Product product = manager.getProduct();
        //System.out.println(product.toCsv());
        if (product != null || key != null) {
            products.insert(key, product);
        } else {
            System.out.println("Incorrect data in script");
        }
    }
}
