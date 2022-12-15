package ua.com.Barysik.island.utility;

import ua.com.Barysik.island.animals.*;
import ua.com.Barysik.island.baseClases.Plant;
import ua.com.Barysik.island.settings.Constants;
import ua.com.Barysik.island.settings.Parameters;

public class FillTable {

    private static String wolf = Wolf.class.getSimpleName();
    private static String duck = Duck.class.getSimpleName();
    private static String horse = Horse.class.getSimpleName();
    private static String caterpillar = Caterpillar.class.getSimpleName();
    private static String plant = Plant.class.getSimpleName();
    private static String predatoryBush = PredatoryBush.class.getSimpleName();

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
        Parameters.setParameterDouble(Constants.weight, predatoryBush, 10.0);

        Parameters.setParameter(Constants.amount, horse, 20);
        Parameters.setParameter(Constants.amount, wolf, 30);
        Parameters.setParameter(Constants.amount, caterpillar, 1000);
        Parameters.setParameter(Constants.amount, duck, 200);
        Parameters.setParameter(Constants.amount, plant, 200);
        Parameters.setParameter(Constants.amount, predatoryBush, 5);

        Parameters.setParameter(Constants.speed, horse, 4);
        Parameters.setParameter(Constants.speed, wolf, 3);
        Parameters.setParameter(Constants.speed, caterpillar, 0);
        Parameters.setParameter(Constants.speed, duck, 4);

        Parameters.setParameterDouble(Constants.eatWeith, horse, 60.0);
        Parameters.setParameterDouble(Constants.eatWeith, wolf, 8.0);
        Parameters.setParameterDouble(Constants.eatWeith, caterpillar, 0.0);
        Parameters.setParameterDouble(Constants.eatWeith, duck, 0.15);
        Parameters.setParameterDouble(Constants.eatWeith, predatoryBush, 3.5);

        Parameters.setParameter(Constants.children, horse, 2);
        Parameters.setParameter(Constants.children, wolf, 3);
        Parameters.setParameter(Constants.children, caterpillar, 100);
        Parameters.setParameter(Constants.children, duck, 20);

        Parameters.setParameterDouble(Constants.satiety, horse, 120.0);
        Parameters.setParameterDouble(Constants.satiety, wolf, 16.0);
        Parameters.setParameterDouble(Constants.satiety, caterpillar, 1.0);
        Parameters.setParameterDouble(Constants.satiety, duck, 0.5);
        Parameters.setParameterDouble(Constants.satiety, predatoryBush, 5.0);

        Parameters.setWords(Constants.name, horse, "Лошадь");
        Parameters.setWords(Constants.name, wolf, "Волк");
        Parameters.setWords(Constants.name, caterpillar, "Гусеница");
        Parameters.setWords(Constants.name, duck, "Утка");
        Parameters.setWords(Constants.name, predatoryBush, "Плотоядный куст");

    }

    private static void fillEatTable() {

        Parameters.setEatTable(wolf, duck, 40);
        Parameters.setEatTable(wolf, horse, 10);

        Parameters.setEatTable(horse, plant, 100);

        Parameters.setEatTable(duck, plant, 100);
        Parameters.setEatTable(duck, caterpillar, 100);

        Parameters.setEatTable(caterpillar, plant, 100);

        Parameters.setEatTable(predatoryBush, wolf, 20);
        Parameters.setEatTable(predatoryBush, horse, 70);
        Parameters.setEatTable(predatoryBush, caterpillar, 100);
        Parameters.setEatTable(predatoryBush, duck, 10);
    }
}