package ua.com.Barysik.island.baseClases;

import ua.com.Barysik.island.settings.Table;

public interface HerbivoreEat {
    default void eat(){
        //ест только траву в количестве Table.getEatWeith(getClass().getSimpleName())
        System.out.println(Table.getEatWeith(getClass().getSimpleName()));
    }
}
