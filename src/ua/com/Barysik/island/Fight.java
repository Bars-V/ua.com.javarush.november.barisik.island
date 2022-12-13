package ua.com.Barysik.island;

import ua.com.Barysik.island.animals.Duck;
import ua.com.Barysik.island.animals.Horse;
import ua.com.Barysik.island.animals.Wolf;
import ua.com.Barysik.island.baseClases.Plant;
import ua.com.Barysik.island.settings.FillTable;

public class Fight {
    public static void main(String[] args) {

        FillTable.startTable();

        new Horse().hunt(new Plant());
        new Wolf().hunt(new Duck());

    }
}
