package commands;

import managers.HashTableManager;

public class SumOfPrice extends AbstractCommand{
    public SumOfPrice(String name, HashTableManager products) {
        super(name, products);
    }

    @Override
    public void execute() {
        System.out.println(products.sumOfPrice());
    }
}
