package ua.com.Barysik.island.baseClases;

import ua.com.Barysik.island.settings.Table;

public interface PredatorEat {
    default void eat(){

        System.out.println(Table.getEatWeith(getClass().getSimpleName()));

        //Если есть животные помеченные как пища, то взять первого с вероятностью TABLE
        //съесть или если нет вероятность выпала ноль,то в начала цикла


    }
}
