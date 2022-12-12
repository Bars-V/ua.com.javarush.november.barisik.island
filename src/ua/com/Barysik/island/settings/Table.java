package ua.com.Barysik.island.settings;

import ua.com.Barysik.island.animals.Caterpillar;
import ua.com.Barysik.island.animals.Duck;
import ua.com.Barysik.island.animals.Horse;
import ua.com.Barysik.island.animals.Wolf;
import ua.com.Barysik.island.baseClases.Plant;

import java.util.HashMap;

public class Table {

    // Временный метод для заполнения таблицыы
    public static void tempInnsertSpeed(){
        setSpeed(Horse.class.getSimpleName(), 4);
        setSpeed(Wolf.class.getSimpleName(),3);
        setSpeed(Caterpillar.class.getSimpleName(),0);
        setSpeed(Duck.class.getSimpleName(),4);

        setAmount(Horse.class.getSimpleName(), 20);
        setAmount(Wolf.class.getSimpleName(), 30);
        setAmount(Caterpillar.class.getSimpleName(), 1000);
        setAmount(Duck.class.getSimpleName(), 200);
        setAmount(Plant.class.getSimpleName(), 200);

        setWeight(Horse.class.getSimpleName(),400);
        setWeight(Wolf.class.getSimpleName(),50);
        setWeight(Caterpillar.class.getSimpleName(),0.01);
        setWeight(Duck.class.getSimpleName(),1);
        setWeight(Plant.class.getSimpleName(),1);

        setEatWeith(Horse.class.getSimpleName(),60);
        setEatWeith(Wolf.class.getSimpleName(),8);
        setEatWeith(Caterpillar.class.getSimpleName(),0);
        setEatWeith(Duck.class.getSimpleName(),0.15);

    }


   private static HashMap<String, Integer> amount = new HashMap<>();
   private static HashMap<String, Double> weight = new HashMap<>();
   private static HashMap<String, Integer> speed = new HashMap<>();
   private static HashMap<String, Double> eatweith = new HashMap<>();


    public static int getAmount(String  animal) {
        return amount.get(animal);
    }

    public static void setAmount(String className, int value) {
        amount.put(className, value);
    }


    public static void setWeight(String className, double value) {
        weight.put(className, value);
    }

    public static double getWeight(String animal) {
        return weight.get(animal);
    }


    public static void setSpeed(String className, int value) {
        speed.put(className, value);
    }

    public static int getSpeed(String animal) {
        return speed.get(animal);
    }


    public static void setEatWeith(String className, double value) {
        eatweith.put(className, value);
    }

    public static double getEatWeith(String animal) {
        return eatweith.get(animal);
    }
}
