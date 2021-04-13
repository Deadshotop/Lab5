package managers;


import exceptions.InvalidArgument;
import product.*;
//import product.eyes.Color;
//import product.hair.Color;

import java.io.File;
import java.security.acl.Owner;
import java.util.NavigableSet;
import java.util.TreeSet;

import static product.Condition.*;
/**
 * Класс оболочка для считывания и обработки данных
 */
public abstract class IOManager {
    protected NavigableSet<File> callHistory;
    protected boolean exit = false;

    public boolean isExit() {
        return exit;
    }

    public void setExit(boolean exit) {
        this.exit = exit;
    }

    protected Integer id;
    protected String productName;
    protected Coordinates coordinates;
    protected Integer xCoord;
    protected int yCoord;
    protected java.time.LocalDateTime creationDate;
    protected Long price;
    protected Long manufactureCost;
    protected UnitOfMeasure unitOfMeasure;

    protected Person owner;
    protected String personName;
    protected java.time.ZonedDateTime birthday;
    protected product.eyes.Color eyeColor;
    protected product.hair.Color hairColor;
    protected Country nationality;

    protected Location location;
    protected float x;
    protected long y;
    protected Double z;
    protected String locationName;

    protected HashTableManager products;

    public IOManager(HashTableManager products) {
        this.products = products;
        callHistory = new TreeSet<>();
    }

    public abstract Integer getId();

    public abstract String getName();

    public abstract void readData();

    public abstract Integer getKey();

    public abstract Product getProduct();

    public abstract Person getOwner();

    public NavigableSet<File> getHistory() {
        return callHistory;
    }

    int checkId(String data) throws NumberFormatException, InvalidArgument {
        int id = Integer.parseInt(data);
        if (id <= MIN)
            throw new InvalidArgument("Id must be more than 0");
        return id;
    }

    Integer checkKey(String data) throws NumberFormatException {
        return Integer.parseInt(data);
    }

    String checkName(String data) throws InvalidArgument {
        if (data.equals("")) {
            throw new InvalidArgument("Incorrect name");
        }
        return data;
    }

    int checkY(String data) throws InvalidArgument, NumberFormatException {
        int y = Integer.parseInt(data);
        if (y > MAX) {
            throw new InvalidArgument("Y-coordinate must be less than " + MAX);
        }
        return y;
    }

    Long checkPrice(String data) throws InvalidArgument {
        if (data.equals("")) {
            return null;
        }
        Long price = Long.parseLong(data);
        if (price < 0) {
            throw new InvalidArgument("Price must be more than " + MIN);
        }
        return price;
    }

    UnitOfMeasure checkUnitOfMeasure(String data) throws InvalidArgument {
        switch (data) {
            case "KILOGRAMS":
                return UnitOfMeasure.KILOGRAMS;
            case "METERS":
                return UnitOfMeasure.METERS;
            case "PCS":
                return UnitOfMeasure.PCS;
            case "MILLILITERS":
                return UnitOfMeasure.MILLILITERS;
            case "GRAMS":
                return UnitOfMeasure.GRAMS;
            default:
                throw new InvalidArgument("Could not find this unit of measure");
        }
    }

    Country checkCountry(String data) throws InvalidArgument {
        switch (data) {
            case "USA":
                return Country.USA;
            case "UNITED_KINGDOM":
                return Country.UNITED_KINGDOM;
            case "FRANCE":
                return Country.FRANCE;
            case "THAILAND":
                return Country.THAILAND;
            case "VATICAN":
                return Country.VATICAN;
            default:
                throw new InvalidArgument("Could not find this country");
        }
    }

    product.eyes.Color checkEyesColor(String data) throws InvalidArgument {
        switch (data) {
            case "BLUE":
                return product.eyes.Color.BLUE;
            case "ORANGE":
                return product.eyes.Color.ORANGE;
            case "GREEN":
                return product.eyes.Color.GREEN;
            case "RED":
                return product.eyes.Color.RED;
            default:
                throw new InvalidArgument("Could not find this eye color");
        }
    }

    product.hair.Color checkHairColor(String data) throws InvalidArgument {
        switch (data) {
            case "BLACK":
                return product.hair.Color.BLACK;
            case "WHITE":
                return product.hair.Color.WHITE;
            case "YELLOW":
                return product.hair.Color.YELLOW;
            case "ORANGE":
                return product.hair.Color.ORANGE;
            case "":
                return null;
            default:
                throw new InvalidArgument("Could not fin this hair color");
        }
    }
}
