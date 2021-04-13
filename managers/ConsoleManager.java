package managers;

import exceptions.InvalidArgument;
import product.*;
import start.Execute;


import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.util.Scanner;

import static product.Condition.FIRST_ID;
/**
 * Класс оболочка для считывания и обработки данных с консоли
 */
public class ConsoleManager extends IOManager{
    private Scanner scanner = new Scanner(System.in);

    public ConsoleManager(HashTableManager products) {
        super(products);
    }

    @Override
    public Integer getId() {
        int id;
        while (true){
            try{
                System.out.println("Enter id");
                id = checkId(scanner.nextLine());
                break;
            } catch (NumberFormatException e) {
                System.out.println("Please enter int argument");
            } catch (InvalidArgument e) {
                System.out.println(e.getMessage());
            }
        }
        return id;
    }

    @Override
    public String getName() {
        System.out.println("Enter file name");
        return scanner.nextLine();
    }

    @Override
    public void readData() {
        String command;
        do {
            System.out.println("Enter a command");
            command = scanner.nextLine().trim();
        } while (!Execute.doCommand(command, products,this));
    }

    @Override
    public Integer getKey() {
        int key;
        while (true){
            try{
                System.out.println("Enter key");
                key = checkKey(scanner.nextLine());
                break;
            } catch (NumberFormatException e) {
                System.out.println("Please enter int argument");
            }
        }
        return key;
    }

    @Override
    public Product getProduct() {
        return new Product(FIRST_ID++, getProductName(), new Coordinates(getX(), getY()), LocalDateTime.now(), getPrice(), getManufactureCost(), getUnitOfMeasure(), getOwner());
    }

    private String getProductName() {
        String arg;
        while (true) {
            System.out.println("Enter product name");
            try {
                arg = checkName(scanner.nextLine());
                return arg;
            } catch (InvalidArgument e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private Integer getX() {
        Integer arg;
        while (true) {
            System.out.println("Enter X-coordinate");
            try {
                arg = Integer.parseInt(scanner.nextLine());
                return arg;
            } catch (NumberFormatException e) {
                System.out.println("Please enter Integer argument");
            }
        }
    }
    private int getY() {
        int arg;
        while (true) {
            System.out.println("Enter Y-coordinate");
            try {
                arg = checkY(scanner.nextLine());
                return arg;
            } catch (NumberFormatException e) {
                System.out.println("Please enter int argument");
            } catch (InvalidArgument e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private Long getPrice() {
        Long arg;
        while (true) {
            System.out.println("Enter price");
            try {
                arg = checkPrice(scanner.nextLine());
                return arg;
            } catch (NumberFormatException e) {
                System.out.println("Please enter Long argument");
            } catch (InvalidArgument e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private Long getManufactureCost() {
        Long arg;
        while (true) {
            System.out.println("Enter manufacture cost");
            try {
                arg = Long.parseLong(scanner.nextLine());
                return arg;
            } catch (NumberFormatException e) {
                System.out.println("Please enter Long argument");
            }
        }
    }

    private UnitOfMeasure getUnitOfMeasure() {
        UnitOfMeasure arg;
        while (true) {
            System.out.println("Enter unit of measure: KILOGRAMS, METERS, PCS, MILLILITERS, GRAMS");
            try {
                arg = checkUnitOfMeasure(scanner.nextLine());
                return arg;
            }  catch (InvalidArgument e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public Person getOwner() {
        while (true) {
            System.out.println("Enter person name");
            try {
                personName = checkName(scanner.nextLine());
                break;
            } catch (InvalidArgument e) {
                System.out.println(e.getMessage());
            }
        }

        while (true) {
            System.out.println("Enter eye color: GREEN, RED, BLUE, ORANGE");
            try {
                eyeColor = checkEyesColor(scanner.nextLine());
                break;
            } catch (InvalidArgument e) {
                System.out.println(e.getMessage());
            }
        }

        while (true) {
            System.out.println("Enter hair color: BLACK, YELLOW, WHITE, ORANGE");
            try {
                hairColor = checkHairColor(scanner.nextLine());
                break;
            } catch (InvalidArgument e) {
                System.out.println(e.getMessage());
            }
        }

        while (true) {
            System.out.println("Enter nationality: UNITED_KINGDOM, USA, FRANCE, VATICAN, THAILAND");
            try {
                nationality = checkCountry(scanner.nextLine());
                break;
            } catch (InvalidArgument e) {
                System.out.println(e.getMessage());
            }
        }

        location = getLocation();

        return new Person(personName, ZonedDateTime.now(), eyeColor, hairColor, nationality, location);

    }

    private Location getLocation() {
        String check;
        System.out.println("Do yo want to enter location? Yes or no?");
        while (true) {
            check = scanner.nextLine();
            if (check.equals("yes") || check.equals("no"))
                break;
        }

        if (check.equals("yes")) {
            while (true) {
                System.out.println("Enter x");
                try {
                    x = Float.parseFloat(scanner.nextLine());
                    break;
                } catch (NumberFormatException e) {
                    System.out.println("Please enter float argument");
                }
            }

            while (true) {
                System.out.println("Enter y");
                try {
                    y = Long.parseLong(scanner.nextLine());
                    break;
                } catch (NumberFormatException e) {
                    System.out.println("Please enter long argument");
                }
            }

            while (true) {
                System.out.println("Enter z");
                try {
                    z = Double.parseDouble(scanner.nextLine());
                    break;
                } catch (NumberFormatException e) {
                    System.out.println("Please enter Double argument");
                }
            }

            System.out.println("Enter location name");
            locationName = scanner.nextLine();
            if (locationName.isEmpty()) {
                locationName = null;
            }

            return new Location(x, y, z, locationName);
        } else {
            return null;
        }
    }
}
