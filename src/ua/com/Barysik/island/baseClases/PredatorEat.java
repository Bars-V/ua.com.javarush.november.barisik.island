package ua.com.Barysik.island.baseClases;

import ua.com.Barysik.island.settings.Table;

public interface PredatorEat {
    default void eat(){

        System.out.println(Table.getEatWeith(getClass().getSimpleName()));

    }
}
