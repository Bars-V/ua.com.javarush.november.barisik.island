package ua.com.barysik.island.utility;

import ua.com.barysik.island.entities.animals.*;
import ua.com.barysik.island.entities.plants.Plant;
import ua.com.barysik.island.settings.Constants;
import ua.com.barysik.island.settings.Parameters;

public class FillParameters {

    private static String wolf = Wolf.class.getSimpleName();
    private static String duck = Duck.class.getSimpleName();
    private static String horse = Horse.class.getSimpleName();
    private static String caterpillar = Caterpillar.class.getSimpleName();
    private static String plant = Plant.class.getSimpleName();
    private static String carnivorousBush = Bush.CarnivorousBush.class.getSimpleName();

    public static void startTable() {

        fillBaseTable();
        fillEatTable();
    }

    private static void fillBaseTable() {

        Parameters.setParameterDouble(Constants.weight, horse, 60.0);
        Parameters.setParameterDouble(Constants.weight, wolf, 50.0);
        Parameters.setParameterDouble(Constants.weight, caterpillar, 0.01);
        Parameters.setParameterDouble(Constants.weight, duck, 1.0);
        Parameters.setParameterDouble(Constants.weight, plant, 1.0);
        Parameters.setParameterDouble(Constants.weight, carnivorousBush, 10.0);

        Parameters.setParameter(Constants.amount, horse, 20);
        Parameters.setParameter(Constants.amount, wolf, 30);
        Parameters.setParameter(Constants.amount, caterpillar, 1000);
        Parameters.setParameter(Constants.amount, duck, 200);
        Parameters.setParameter(Constants.amount, plant, 200);
        Parameters.setParameter(Constants.amount, carnivorousBush, 5);

        Parameters.setParameter(Constants.speed, horse, 4);
        Parameters.setParameter(Constants.speed, wolf, 3);
        Parameters.setParameter(Constants.speed, caterpillar, 0);
        Parameters.setParameter(Constants.speed, duck, 4);

        Parameters.setParameterDouble(Constants.eatWeith, horse, 60.0);
        Parameters.setParameterDouble(Constants.eatWeith, wolf, 8.0);
        Parameters.setParameterDouble(Constants.eatWeith, caterpillar, 0.0);
        Parameters.setParameterDouble(Constants.eatWeith, duck, 0.15);
        Parameters.setParameterDouble(Constants.eatWeith, carnivorousBush, 3.5);

        Parameters.setParameter(Constants.children, horse, 5);
        Parameters.setParameter(Constants.children, wolf, 4);
        Parameters.setParameter(Constants.children, caterpillar, 0);
        Parameters.setParameter(Constants.children, duck, 1);

        Parameters.setParameterDouble(Constants.satiety, horse, 120.0);
        Parameters.setParameterDouble(Constants.satiety, wolf, 16.0);
        Parameters.setParameterDouble(Constants.satiety, caterpillar, 0.01);
        Parameters.setParameterDouble(Constants.satiety, duck, 0.15);
        Parameters.setParameterDouble(Constants.satiety, carnivorousBush, 5.0);

        Parameters.setWords(Constants.name, horse, "Лошадь");
        Parameters.setWords(Constants.name, wolf, "Волк");
        Parameters.setWords(Constants.name, caterpillar, "Гусеница");
        Parameters.setWords(Constants.name, duck, "Утка");
        Parameters.setWords(Constants.name, plant, "Трава");
        Parameters.setWords(Constants.name, carnivorousBush, "Плотоядный куст");

        Parameters.setParameterDouble(Constants.hunger, horse, 10.0);
        Parameters.setParameterDouble(Constants.hunger, wolf, 5.0);
        Parameters.setParameterDouble(Constants.hunger, caterpillar, 0.1);
        Parameters.setParameterDouble(Constants.hunger, duck, 30.0);
        Parameters.setParameterDouble(Constants.hunger, carnivorousBush, 0.0);

    }

    private static void fillEatTable() {

        Parameters.setEatTable(wolf, duck, 40);
        Parameters.setEatTable(wolf, horse, 10);

        Parameters.setEatTable(horse, plant, 100);

        Parameters.setEatTable(duck, plant, 100);
        Parameters.setEatTable(duck, caterpillar, 100);

        Parameters.setEatTable(caterpillar, plant, 100);

        Parameters.setEatTable(carnivorousBush, wolf, 20);
        Parameters.setEatTable(carnivorousBush, horse, 70);
        Parameters.setEatTable(carnivorousBush, caterpillar, 100);
        Parameters.setEatTable(carnivorousBush, duck, 10);
    }
}