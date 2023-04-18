package kz.lkwwr.test.db;

import java.util.ArrayList;

public class DBManager {
    private static final ArrayList<Item> items = new ArrayList<>();

    static {
        items.add(new Item(1L, "IPhone 14 Pro", 600000));
        items.add(new Item(2L, "IPhone 13 Pro", 500000));
        items.add(new Item(3L, "IPhone 12 Pro", 450000));
        items.add(new Item(4L, "IPhone 11 Pro", 400000));
    }

    private static Long id = 5L;

    public static void addItem(Item item) {
        item.setId(id++);
        items.add(item);
    }

    public static ArrayList<Item> getItems() {
        return items;
    }

    public static Item getItem(Long id) {
        for (Item item : items) {
            if (id.equals(item.getId())) return item;
        }
        return null;
    }
}
