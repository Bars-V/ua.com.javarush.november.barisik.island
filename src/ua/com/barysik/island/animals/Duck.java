package ua.com.barysik.island.animals;

import ua.com.barysik.island.baseClases.Herbivore;
import ua.com.barysik.island.settings.Constants;
import ua.com.barysik.island.settings.Directions;
import ua.com.barysik.island.settings.Parameters;

import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

public class Duck extends Herbivore {
    @Override
    public ArrayList<Directions> run() {
        ArrayList<Directions> directions = new ArrayList<>();
        int speed = Parameters.getParameter(Constants.speed, getClass().getSimpleName());
        int rnd = ThreadLocalRandom.current().nextInt(5);

        switch (rnd) {
            case 0:
                directions.add(Directions.STOP);
                return directions;
            case 1:
                for (int i = 0; i < speed; i++) {
                    directions.add(Directions.LEFT);
                }
                return directions;
            case 2:
                for (int i = 0; i < speed; i++) {
                    directions.add(Directions.RIGHT);
                }
                return directions;
            case 3:
                for (int i = 0; i < speed; i++) {
                    directions.add(Directions.UP);
                }
                return directions;
            case 4:
                for (int i = 0; i < speed; i++) {
                    directions.add(Directions.DOWN);
                }
                return directions;
        }
        return directions;
    }
}