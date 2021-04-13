package commands;

import exceptions.RecursiveScript;
import managers.FileManager;
import managers.HashTableManager;
import managers.IOManager;
import start.Execute;

import java.io.FileNotFoundException;

public class ExecuteScript extends AbstractCommand{
    private String path;
    private IOManager manager;
    public ExecuteScript(String name, HashTableManager products, String path, IOManager manager) {
        super(name, products);
        this.path = path;
        this.manager = manager;
    }

    @Override
    public void execute() {
        try {
            FileManager fileManager = new FileManager(products, path, true, manager.getHistory());
            fileManager.readData();
            if (fileManager.isExit()) {
                exit = true;
            }
        } catch (FileNotFoundException | NullPointerException e) {
            System.out.println("File not found");
        } catch (RecursiveScript recursiveScript) {
            System.out.println(recursiveScript.getMessage());
        }
    }
}
