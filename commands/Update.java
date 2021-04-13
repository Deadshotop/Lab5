package commands;

import managers.HashTableManager;
import managers.IOManager;
import product.Product;

public class Update extends AbstractCommand{
    private IOManager manager;

    public Update(String name, HashTableManager products, IOManager manager) {
        super(name, products);
        this.manager = manager;
    }

    @Override
    public void execute() {
        Integer id = manager.getId();
        if (id != null) {
            if (products.findId(id)) {
                Product product = manager.getProduct();
                if (product != null) {
                    product.setId(id);
                    products.insert(products.removeById(id), product);
                }
            } else {
                System.out.println("Id not found");
            }
        }

    }
}
