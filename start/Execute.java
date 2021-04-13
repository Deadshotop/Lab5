package start;

import commands.*;
import exceptions.CommandNotFoundException;
import exceptions.RecursiveScript;
import managers.ConsoleManager;
import managers.FileManager;
import managers.HashTableManager;
import managers.IOManager;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.TreeSet;


public class Execute {

    //private static boolean exitProcess = false;
    private static String path;

    public static void main(String[] args) {
        path = System.getenv().get("FILE5");
        HashTableManager products = new HashTableManager();
        try{
            FileManager fileManager = new FileManager(products, path, false, new TreeSet<File>());
            fileManager.readData();
        } catch (FileNotFoundException | NullPointerException e) {
            System.out.println("Something wrong with the file");
        } catch (RecursiveScript e) {}
        ConsoleManager consoleManager = new ConsoleManager(products);
        consoleManager.readData();
    }

    private static AbstractCommand findCommand(String command, HashTableManager products, IOManager manager) throws CommandNotFoundException {
        switch (command) {
            case "help":
                return new Help(command, products);
            case "info":
                return new Info(command, products);
            case "show":
                return new Show(command, products);
            case "insert":
                return new Insert(command, products, manager);
            case "update":
                return new Update(command, products, manager);
            case "remove_key":
                return new RemoveKey(command, products, manager);
            case "clear":
                return new Clear(command, products);
            case "exit":
                return new Exit(command, products);
            case "save":
                return new Save(command, products, path);
            case "execute_script":
                return new ExecuteScript(command, products, manager.getName(), manager);
            case "replace_if_lowe":
                return new ReplaceIfLowe(command, products, manager);
            case "remove_greater_key":
                return new RemoveGreaterKey(command, products, manager);
            case "remove_lower_key":
                return new RemoveLowerKey(command, products, manager);
            case "sum_of_price":
                return new SumOfPrice(command, products);
            case "min_by_creation_date":
                return new MinByCreationDate(command, products);
            case "count_by_owner":
                return new CountByOwner(command, products, manager);
            default:
                throw new CommandNotFoundException("Command \"" + command + "\" doesn't exist");
        }
    }

    public static boolean doCommand(String command, HashTableManager products, IOManager manager) {

        boolean exit = false;
        try{
            AbstractCommand com = findCommand(command, products, manager);
            com.execute();
            if (com.isExit() || manager.isExit()) {
                exit = true;
                System.out.println("Command executed");
            }
        } catch (CommandNotFoundException e) {
            System.out.println(e.getMessage());
        }

        return exit;
    }
}
