package ua.com.Barysik.island.settings;

import ua.com.Barysik.island.animals.Caterpillar;
import ua.com.Barysik.island.animals.Duck;
import ua.com.Barysik.island.animals.Horse;
import ua.com.Barysik.island.animals.Wolf;

import java.util.HashMap;

public class Table {

    // Временный метод для заполнения таблицыы

    public static void tempInnsertSpeed(){
        setSpeed(Horse.class.getSimpleName(), 4);
        setSpeed(Wolf.class.getSimpleName(),3);
        setSpeed(Caterpillar.class.getSimpleName(),0);
        setSpeed(Duck.class.getSimpleName(),4);
    }


    static HashMap<String, Integer> amount = new HashMap<>();
    static HashMap<String, Integer> weight = new HashMap<>();
    static HashMap<String, Integer> speed = new HashMap<>();
    static HashMap<String, Integer> eatweith = new HashMap<>();


    public static int getAmount(String  animal) {
        return amount.get(animal);
    }

    public static void setAmount(String className, int value) {
        amount.put(className, value);
    }


    public static void setWeight(String className, int value) {
        weight.put(className, value);
    }

    public static int getWeight(String animal) {
        return weight.get(animal);
    }


    public static void setSpeed(String className, int value) {
        speed.put(className, value);
    }

    public static int getSpeed(String animal) {
        return speed.get(animal);
    }


    public static void setEatWeith(String className, int value) {
        eatweith.put(className, value);
    }

    public static int getEatWeith(String animal) {
        return eatweith.get(animal);
    }
}
