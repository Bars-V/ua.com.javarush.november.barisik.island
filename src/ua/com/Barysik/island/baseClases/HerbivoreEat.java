package ua.com.Barysik.island.baseClases;

import ua.com.Barysik.island.settings.BaseParameters;

public interface HerbivoreEat {
    default void eat(){
        System.out.println(BaseParameters.getEatWeith(getClass().getSimpleName()));

        //если есть трава, то съедать Table.getEatWeith(getClass().getSimpleName())

    }
}
