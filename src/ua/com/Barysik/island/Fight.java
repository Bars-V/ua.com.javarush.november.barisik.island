package ua.com.Barysik.island;

import ua.com.Barysik.island.animals.*;
import ua.com.Barysik.island.baseClases.Plant;
import ua.com.Barysik.island.utility.Initialization;

public class Fight {
    public static void main(String[] args) {

        new Initialization().start();

        new Horse().hunt(new Plant());
        System.out.println();
        new Duck().hunt(new Caterpillar());
        System.out.println();
        new Duck().hunt(new Plant());
        System.out.println();
        new Wolf().hunt(new Duck());
        System.out.println();
        new Wolf().hunt(new Caterpillar());

    }
}
