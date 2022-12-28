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
    private static String anaconda = Anaconda.class.getSimpleName();
    private static String fox = Fox.class.getSimpleName();
    private static String bear = Bear.class.getSimpleName();
    private static String eagle = Eagle.class.getSimpleName();
    private static String deer = Deer.class.getSimpleName();
    private static String rabbit = Rabbit.class.getSimpleName();
    private static String mouse = Mouse.class.getSimpleName();
    private static String goat = Goat.class.getSimpleName();
    private static String sheep = Sheep.class.getSimpleName();
    private static String boar = Boar.class.getSimpleName();
    private static String buffalo = Buffalo.class.getSimpleName();

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
        Parameters.setParameterDouble(Constants.weight, anaconda, 15.0);
        Parameters.setParameterDouble(Constants.weight, fox, 8.0);
        Parameters.setParameterDouble(Constants.weight, bear, 500.0);
        Parameters.setParameterDouble(Constants.weight, eagle, 6.0);
        Parameters.setParameterDouble(Constants.weight, deer, 300.0);
        Parameters.setParameterDouble(Constants.weight, rabbit, 2.0);
        Parameters.setParameterDouble(Constants.weight, mouse, 0.05);
        Parameters.setParameterDouble(Constants.weight, goat, 60.0);
        Parameters.setParameterDouble(Constants.weight, sheep, 70.0);
        Parameters.setParameterDouble(Constants.weight, boar, 400.0);
        Parameters.setParameterDouble(Constants.weight, buffalo, 700.0);

        Parameters.setParameter(Constants.amount, horse, 20);
        Parameters.setParameter(Constants.amount, wolf, 30);
        Parameters.setParameter(Constants.amount, caterpillar, 1000);
        Parameters.setParameter(Constants.amount, duck, 200);
        Parameters.setParameter(Constants.amount, plant, 200);
        Parameters.setParameter(Constants.amount, carnivorousBush, 5);
        Parameters.setParameter(Constants.amount, anaconda, 30);
        Parameters.setParameter(Constants.amount, fox, 30);
        Parameters.setParameter(Constants.amount, bear, 5);
        Parameters.setParameter(Constants.amount, eagle, 20);
        Parameters.setParameter(Constants.amount, deer, 20);
        Parameters.setParameter(Constants.amount, rabbit, 150);
        Parameters.setParameter(Constants.amount, mouse, 500);
        Parameters.setParameter(Constants.amount, goat, 140);
        Parameters.setParameter(Constants.amount, sheep, 140);
        Parameters.setParameter(Constants.amount, boar, 50);
        Parameters.setParameter(Constants.amount, buffalo, 10);

        Parameters.setParameter(Constants.speed, horse, 4);
        Parameters.setParameter(Constants.speed, wolf, 3);
        Parameters.setParameter(Constants.speed, duck, 4);
        Parameters.setParameter(Constants.speed, anaconda, 1);
        Parameters.setParameter(Constants.speed, fox, 2);
        Parameters.setParameter(Constants.speed, bear, 2);
        Parameters.setParameter(Constants.speed, eagle, 3);
        Parameters.setParameter(Constants.speed, deer, 4);
        Parameters.setParameter(Constants.speed, rabbit, 2);
        Parameters.setParameter(Constants.speed, mouse, 1);
        Parameters.setParameter(Constants.speed, goat, 3);
        Parameters.setParameter(Constants.speed, sheep, 3);
        Parameters.setParameter(Constants.speed, boar, 2);
        Parameters.setParameter(Constants.speed, buffalo, 3);

        Parameters.setParameterDouble(Constants.eatWeith, horse, 60.0);
        Parameters.setParameterDouble(Constants.eatWeith, wolf, 8.0);
        Parameters.setParameterDouble(Constants.eatWeith, caterpillar, 0.0);
        Parameters.setParameterDouble(Constants.eatWeith, duck, 0.15);
        Parameters.setParameterDouble(Constants.eatWeith, carnivorousBush, 3.5);
        Parameters.setParameterDouble(Constants.eatWeith, anaconda, 3.0);
        Parameters.setParameterDouble(Constants.eatWeith, fox, 2.0);
        Parameters.setParameterDouble(Constants.eatWeith, bear, 80.0);
        Parameters.setParameterDouble(Constants.eatWeith, eagle, 1.0);
        Parameters.setParameterDouble(Constants.eatWeith, deer, 50.0);
        Parameters.setParameterDouble(Constants.eatWeith, rabbit, 0.45);
        Parameters.setParameterDouble(Constants.eatWeith, mouse, 0.01);
        Parameters.setParameterDouble(Constants.eatWeith, goat, 10.0);
        Parameters.setParameterDouble(Constants.eatWeith, sheep, 15.0);
        Parameters.setParameterDouble(Constants.eatWeith, boar, 50.0);
        Parameters.setParameterDouble(Constants.eatWeith, buffalo, 100.0);

        Parameters.setParameter(Constants.children, horse, 5);
        Parameters.setParameter(Constants.children, wolf, 4);
        Parameters.setParameter(Constants.children, caterpillar, 0);
        Parameters.setParameter(Constants.children, duck, 1);
        Parameters.setParameter(Constants.children, anaconda, 3);
        Parameters.setParameter(Constants.children, fox, 5);
        Parameters.setParameter(Constants.children, bear, 1);
        Parameters.setParameter(Constants.children, eagle, 4);
        Parameters.setParameter(Constants.children, deer, 1);
        Parameters.setParameter(Constants.children, rabbit, 10);
        Parameters.setParameter(Constants.children, mouse, 20);
        Parameters.setParameter(Constants.children, goat, 7);
        Parameters.setParameter(Constants.children, sheep, 7);
        Parameters.setParameter(Constants.children, boar, 8);
        Parameters.setParameter(Constants.children, buffalo, 1);

        Parameters.setParameterDouble(Constants.satiety, wolf, 16.0);
        Parameters.setParameterDouble(Constants.satiety, duck, 0.15);
        Parameters.setParameterDouble(Constants.satiety, horse, 120.0);
        Parameters.setParameterDouble(Constants.satiety, caterpillar, 0.01);
        Parameters.setParameterDouble(Constants.satiety, carnivorousBush, 5.0);
        Parameters.setParameterDouble(Constants.satiety, anaconda, 10.0);
        Parameters.setParameterDouble(Constants.satiety, fox, 15.0);
        Parameters.setParameterDouble(Constants.satiety, bear, 200.0);
        Parameters.setParameterDouble(Constants.satiety, eagle, 3.0);
        Parameters.setParameterDouble(Constants.satiety, deer, 200.0);
        Parameters.setParameterDouble(Constants.satiety, rabbit, 10.0);
        Parameters.setParameterDouble(Constants.satiety, mouse, 1.0);
        Parameters.setParameterDouble(Constants.satiety, goat, 30.0);
        Parameters.setParameterDouble(Constants.satiety, sheep, 20.0);
        Parameters.setParameterDouble(Constants.satiety, boar, 40.0);
        Parameters.setParameterDouble(Constants.satiety, buffalo, 100.0);

        Parameters.setWords(Constants.name, horse, "Лошадь");
        Parameters.setWords(Constants.name, wolf, "Волк");
        Parameters.setWords(Constants.name, caterpillar, "Гусеница");
        Parameters.setWords(Constants.name, duck, "Утка");
        Parameters.setWords(Constants.name, plant, "Трава");
        Parameters.setWords(Constants.name, carnivorousBush, "Плотоядный куст");
        Parameters.setWords(Constants.name, anaconda, "Удав");
        Parameters.setWords(Constants.name, fox, "Лиса");
        Parameters.setWords(Constants.name, bear, "Медведь");
        Parameters.setWords(Constants.name, eagle, "Орел");
        Parameters.setWords(Constants.name, deer, "Олень");
        Parameters.setWords(Constants.name, rabbit, "Кролик");
        Parameters.setWords(Constants.name, mouse, "Мышь");
        Parameters.setWords(Constants.name, goat, "Коза");
        Parameters.setWords(Constants.name, sheep, "Овца");
        Parameters.setWords(Constants.name, boar, "Кабан");
        Parameters.setWords(Constants.name, buffalo, "Буйвол");

        Parameters.setParameterDouble(Constants.hunger, horse, 10.0);
        Parameters.setParameterDouble(Constants.hunger, wolf, 10.0);
        Parameters.setParameterDouble(Constants.hunger, caterpillar, 0.1);
        Parameters.setParameterDouble(Constants.hunger, duck, 30.0);
        Parameters.setParameterDouble(Constants.hunger, carnivorousBush, 1.0);
        Parameters.setParameterDouble(Constants.hunger, anaconda, 20.0);
        Parameters.setParameterDouble(Constants.hunger, fox, 25.0);
        Parameters.setParameterDouble(Constants.hunger, bear, 10.0);
        Parameters.setParameterDouble(Constants.hunger, eagle, 10.0);
        Parameters.setParameterDouble(Constants.hunger, deer, 10.0);
        Parameters.setParameterDouble(Constants.hunger, rabbit, 10.0);
        Parameters.setParameterDouble(Constants.hunger, mouse, 10.0);
        Parameters.setParameterDouble(Constants.hunger, goat, 5.0);
        Parameters.setParameterDouble(Constants.hunger, sheep, 5.0);
        Parameters.setParameterDouble(Constants.hunger, boar, 5.0);
        Parameters.setParameterDouble(Constants.hunger, buffalo, 10.0);

    }

    private static void fillEatTable() {

        Parameters.setEatTable(wolf, duck, 40);
        Parameters.setEatTable(wolf, horse, 10);
        Parameters.setEatTable(wolf, deer, 15);
        Parameters.setEatTable(wolf, rabbit, 60);
        Parameters.setEatTable(wolf, mouse, 80);
        Parameters.setEatTable(wolf, goat, 60);
        Parameters.setEatTable(wolf, sheep, 70);
        Parameters.setEatTable(wolf, boar, 15);
        Parameters.setEatTable(wolf, buffalo, 10);


        Parameters.setEatTable(duck, plant, 100);
        Parameters.setEatTable(duck, caterpillar, 100);

        Parameters.setEatTable(carnivorousBush, wolf, 20);
        Parameters.setEatTable(carnivorousBush, horse, 70);
        Parameters.setEatTable(carnivorousBush, caterpillar, 100);
        Parameters.setEatTable(carnivorousBush, rabbit, 80);
        Parameters.setEatTable(carnivorousBush, buffalo, 10);
        Parameters.setEatTable(carnivorousBush, sheep, 40);
        Parameters.setEatTable(carnivorousBush, goat, 40);
        Parameters.setEatTable(carnivorousBush, mouse, 90);
        Parameters.setEatTable(carnivorousBush, anaconda, 30);
        Parameters.setEatTable(carnivorousBush, fox, 5);

        Parameters.setEatTable(anaconda, fox, 15);
        Parameters.setEatTable(anaconda, rabbit, 20);
        Parameters.setEatTable(anaconda, mouse, 40);
        Parameters.setEatTable(anaconda, duck, 10);

        Parameters.setEatTable(fox, rabbit, 70);
        Parameters.setEatTable(fox, mouse, 90);
        Parameters.setEatTable(fox, duck, 60);
        Parameters.setEatTable(fox, caterpillar, 40);

        Parameters.setEatTable(bear, anaconda, 80);
        Parameters.setEatTable(bear, horse, 40);
        Parameters.setEatTable(bear, deer, 80);
        Parameters.setEatTable(bear, rabbit, 80);
        Parameters.setEatTable(bear, mouse, 90);
        Parameters.setEatTable(bear, goat, 70);
        Parameters.setEatTable(bear, sheep, 70);
        Parameters.setEatTable(bear, boar, 50);
        Parameters.setEatTable(bear, buffalo, 20);
        Parameters.setEatTable(bear, duck, 10);

        Parameters.setEatTable(eagle, fox, 10);
        Parameters.setEatTable(eagle, rabbit, 90);
        Parameters.setEatTable(eagle, mouse, 90);
        Parameters.setEatTable(eagle, duck, 80);

        Parameters.setEatTable(mouse, caterpillar, 90);
        Parameters.setEatTable(mouse, plant, 100);

        Parameters.setEatTable(boar, caterpillar, 90);
        Parameters.setEatTable(boar, plant, 100);
        Parameters.setEatTable(boar, mouse, 50);

        Parameters.setEatTable(deer, plant, 100);
        Parameters.setEatTable(rabbit, plant, 100);
        Parameters.setEatTable(goat, plant, 100);
        Parameters.setEatTable(sheep, plant, 100);
        Parameters.setEatTable(buffalo, plant, 100);
        Parameters.setEatTable(horse, plant, 100);
        Parameters.setEatTable(caterpillar, plant, 100);

    }
}
