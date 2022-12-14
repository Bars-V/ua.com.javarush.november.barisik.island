package ua.com.Barysik.island.baseClases;

import ua.com.Barysik.island.settings.Parameters;

public interface Weight {
    //вес
   default double weight(){
       return Parameters.getParameterDouble("weight", getClass().getSimpleName());
   }
}
