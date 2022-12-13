package ua.com.Barysik.island.baseClases;

import ua.com.Barysik.island.settings.BaseParameters;

public interface Amount {
    //максимальное количество объектов в клетке
    default int amount() {
        return BaseParameters.getAmount(getClass().getSimpleName());
    }
}
