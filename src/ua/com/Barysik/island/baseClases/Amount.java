package ua.com.Barysik.island.baseClases;

import ua.com.Barysik.island.settings.Constants;
import ua.com.Barysik.island.settings.Parameters;

public interface Amount {
    //максимальное количество объектов в клетке
    default double amount() {
        return Parameters.getParameterDouble(Constants.amount,getClass().getSimpleName());
    }
}
