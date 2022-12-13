package ua.com.Barysik.island.baseClases;

import ua.com.Barysik.island.settings.BaseParameters;

public interface Weight {
    //вес
   default double weight(){
       return BaseParameters.getWeight(getClass().getSimpleName());
   }
}
