package com.acquisio.basic.java.question04;


import java.util.ArrayList;
import java.util.List;

class Inventory<Object extends Item> {

    private List<Object> items = new ArrayList<>();

    public void add(Object item) {
        items.add(item);
    }

    public Object getFirst() {
        if (items.size() > 0) {
            return items.get(0);
        }
        return null;
    }

    public Object getLast() {
        int size = items.size();
        if (size > 0) {
            return items.get(size - 1);
        }
        return null;
    }


    public boolean remove(Item item) {
        return items.remove(item);
    }

    public Object findFirst(String name) {
        for (Object item : items) {
            if (item.getName().equals(name)) {
                return item;
            }
        }
        return null;
    }
}
