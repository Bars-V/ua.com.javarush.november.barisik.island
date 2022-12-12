package ua.com.Barysik.island.baseClases;

import ua.com.Barysik.island.settings.Table;

public interface HerbivoreEat {
    default void eat(){
        System.out.println(Table.getEatWeith(getClass().getSimpleName()));

        //если есть трава, то съедать Table.getEatWeith(getClass().getSimpleName())

    }
}
