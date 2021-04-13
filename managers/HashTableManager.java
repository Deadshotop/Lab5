package managers;

import product.Person;
import product.Product;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Date;
import java.util.Hashtable;
import java.util.Map;
/**
 * Класс оболочка для работы с коллекцией
 */
public class HashTableManager {
    private Map<Integer, Product> products = new Hashtable<>();
    private Date date = null;


    public void insert(int key, Product product) {
        if (date == null) {
            date = new Date();
        }
        products.put(key, product);
    }



    public Long sumOfPrice() {
        Long price = 0L;
        for (Product p : products.values()) {
            if (p.getPrice() != null){
                price += p.getPrice();
            }

        }
        return price;
    }

    public Product minByCreationDate() {
        Product product = null;
        boolean first = true;
        for (Product p : products.values()) {
            if (first) {
                first = false;
                product = p;
            } else {
                if (p.getCreationDate().compareTo(product.getCreationDate()) > 0) {
                    product = p;
                }
            }
        }
        return product;
    }

    public int countByOwner(Person owner) {
        int cnt = 0;
        for (Product p : products.values()) {
            if (p.getOwner().equals(owner)) {
                cnt++;
            }
        }
        return cnt;
    }

    public void clear() {
        products.clear();
    }

    public boolean findKey(Integer key) {
        return products.containsKey(key);
    }

    public void removeGreaterKey(Integer key) {
        for (Integer i : products.keySet()) {
            if (i > key) {
                products.remove(i);
            }
        }
    }

    public void removeLowerKey(Integer key) {
        for (Integer i : products.keySet()) {
            if (i < key) {
                products.remove(i);
            }
        }
    }

    public boolean replaceIfLowe(Integer key, Product product) {
        if (findKey(key)) {
            if (products.get(key).compareTo(product) > 0) {
                products.put(key, product);
                //return true;
            }
            return true;
        } else {
            return false;
        }
    }

    public boolean findId(int id) {
        for (Product p : products.values()) {
            if (p.getId() == id)
                return true;
        }
        return false;
    }

    public boolean removeByKey(Integer key) {
        int size = size();
        products.remove(key);
        if (size() - size == 0) {
            return false;
        }
        return true;
    }


    public Integer removeById(int id) {
        Product product;
        Integer key = 0;
        for (int i : products.keySet()) {
            if (products.get(i).getId() == id) {
                key = i;
                product = products.get(i);
                break;
            }
        }
        removeByKey(key);
        return key;
    }

    public Date getDate() {
        return date;
    }

    public int size() {
        return products.size();
    }

    public String print() {
        StringBuilder el = new StringBuilder();
        for (Product p : products.values()) {
            el.append(p.toString() + "\n");
        }
        return el.toString();
    }

    public void write(FileOutputStream writer) throws IOException {
        for (Product product : products.values()) {
            writer.write(product.toCsv().getBytes(StandardCharsets.UTF_8));
        }
    }
}
