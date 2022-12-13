package ua.com.Barysik.island.settings;

import ua.com.Barysik.island.animals.*;
//import ua.com.Barysik.island.animals.Duck;
//import ua.com.Barysik.island.animals.Horse;
//import ua.com.Barysik.island.animals.Wolf;
import ua.com.Barysik.island.baseClases.Plant;


public class FillTable {

    public static void startTable(){
        fillBaseTable();

    }

    // Метод для заполнения таблицыы
    private static void fillBaseTable(){

        BaseParameters.setSpeed(Horse.class.getSimpleName(), 4);
        BaseParameters.setSpeed(Wolf.class.getSimpleName(),3);
        BaseParameters.setSpeed(Caterpillar.class.getSimpleName(),0);
        BaseParameters.setSpeed(Duck.class.getSimpleName(),4);

        BaseParameters.setAmount(Horse.class.getSimpleName(), 20);
        BaseParameters.setAmount(Wolf.class.getSimpleName(), 30);
        BaseParameters.setAmount(Caterpillar.class.getSimpleName(), 1000);
        BaseParameters.setAmount(Duck.class.getSimpleName(), 200);
        BaseParameters.setAmount(Plant.class.getSimpleName(), 200);

        BaseParameters.setWeight(Horse.class.getSimpleName(),400);
        BaseParameters.setWeight(Wolf.class.getSimpleName(),50);
        BaseParameters.setWeight(Caterpillar.class.getSimpleName(),0.01);
        BaseParameters.setWeight(Duck.class.getSimpleName(),1);
        BaseParameters.setWeight(Plant.class.getSimpleName(),1);

        BaseParameters.setEatWeith(Horse.class.getSimpleName(),60);
        BaseParameters.setEatWeith(Wolf.class.getSimpleName(),8);
        BaseParameters.setEatWeith(Caterpillar.class.getSimpleName(),0);
        BaseParameters.setEatWeith(Duck.class.getSimpleName(),0.15);
    }

    private static void fillEatTable(){

    }

}
