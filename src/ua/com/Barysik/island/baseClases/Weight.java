package ua.com.Barysik.island.baseClases;

import ua.com.Barysik.island.settings.Table;

public interface Weight {
    //вес
   default double weight(){
       return Table.getWeight(getClass().getSimpleName());
   }
}
