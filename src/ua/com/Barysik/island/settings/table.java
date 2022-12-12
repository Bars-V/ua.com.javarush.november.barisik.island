package ua.com.Barysik.island.settings;

import java.util.HashMap;

public class table<T> {
    private int wolf;

    public int getAmount(Class<T> animal){
        int value = amount.get(animal);
        return value;
    }

    public void setAmount(HashMap<Class<T>, Integer> amount) {
        this.amount = amount;
    }

    private HashMap<Class<T>, Integer> amount = new HashMap<>();

}
