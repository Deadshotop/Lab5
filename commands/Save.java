package commands;

import managers.HashTableManager;
import product.Product;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Save extends AbstractCommand{

    private final String path;

    public Save(String name, HashTableManager products, String path) {
        super(name, products);
        this.path = path;
    }

    @Override
    public void execute() {
        try (FileOutputStream writer = new FileOutputStream(path)) {
            products.write(writer);
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        } catch (IOException e) {
            System.out.println("You haven't rights to write in this file");
        }
    }
}
