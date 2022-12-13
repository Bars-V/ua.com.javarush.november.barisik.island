package ua.com.Barysik.island.settings;

import java.util.HashMap;

public class BaseParameters {

    // amount - Максимальное количество животных этого вида на одной клетке
    // weight - Вес одного животного, кг
    // speed - Скорость перемещения, не более чем, клеток за ход
    // eatWeith - Сколько килограммов пищи нужно животному для полного насыщения

   private static HashMap<String, Integer> amount = new HashMap<>();
   private static HashMap<String, Double> weight = new HashMap<>();
   private static HashMap<String, Integer> speed = new HashMap<>();
   private static HashMap<String, Double> eatWeith = new HashMap<>();


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
        eatWeith.put(className, value);
    }

    public static double getEatWeith(String animal) {
        return eatWeith.get(animal);
    }
}
