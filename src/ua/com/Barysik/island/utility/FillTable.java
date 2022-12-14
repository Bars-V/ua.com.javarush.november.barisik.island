package ua.com.Barysik.island.utility;

import ua.com.Barysik.island.animals.*;
import ua.com.Barysik.island.baseClases.Plant;
import ua.com.Barysik.island.settings.Parameters;

public class FillTable {

    private static String wolf = Wolf.class.getSimpleName();
    private static String duck = Duck.class.getSimpleName();
    private static String horse = Horse.class.getSimpleName();
    private static String caterpillar = Caterpillar.class.getSimpleName();
    private static String plant = Plant.class.getSimpleName();

    public static void startTable() {
        fillBaseTable();
        fillEatTable();
    }

    private static void fillBaseTable() {

        String weight = "weight"; // weight - Вес одного животного, кг
        String amount = "amount"; // amount - Максимальное количество животных этого вида на одной клетке
        String speed = "speed"; // speed - Скорость перемещения, не более чем, клеток за ход
        String eatWeith = "eatWeith"; // eatWeith - Сколько килограммов пищи нужно животному для полного насыщения
        String children = "children"; // children - количество детей за раз

        Parameters.setParameterDouble(weight, horse, 60.0);
        Parameters.setParameterDouble(weight, wolf, 50.0);
        Parameters.setParameterDouble(weight, caterpillar, 0.01);
        Parameters.setParameterDouble(weight, duck, 1.0);
        Parameters.setParameterDouble(weight, plant, 1.0);

        Parameters.setParameter(amount, horse, 20);
        Parameters.setParameter(amount, wolf, 30);
        Parameters.setParameter(amount, caterpillar, 1000);
        Parameters.setParameter(amount, duck, 200);
        Parameters.setParameter(amount, plant, 200);

        Parameters.setParameter(speed, horse, 4);
        Parameters.setParameter(speed, wolf, 3);
        Parameters.setParameter(speed, caterpillar, 0);
        Parameters.setParameter(speed, duck, 4);

        Parameters.setParameterDouble(eatWeith, horse, 60.0);
        Parameters.setParameterDouble(eatWeith, wolf, 8.0);
        Parameters.setParameterDouble(eatWeith, caterpillar, 0.0);
        Parameters.setParameterDouble(eatWeith, duck, 0.15);

        Parameters.setParameter(children, horse, 2);
        Parameters.setParameter(children, wolf, 3);
        Parameters.setParameter(children, caterpillar, 100);
        Parameters.setParameter(children, horse, 20);
    }

    private static void fillEatTable() {

        Parameters.setEatTable(wolf, duck, 40);
        Parameters.setEatTable(wolf, horse, 10);

        Parameters.setEatTable(horse, plant, 100);

        Parameters.setEatTable(duck, plant, 100);
        Parameters.setEatTable(duck, caterpillar, 100);

        Parameters.setEatTable(caterpillar, plant, 100);
    }
}