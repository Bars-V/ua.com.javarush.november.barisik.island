package ua.com.Barysik.island.baseClases;

import ua.com.Barysik.island.settings.Table;

public interface Amount {
    //максимальное количество объектов в клетке
    default int amount() {
        return Table.getAmount(getClass().getSimpleName());
    }
}
