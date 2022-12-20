package ua.com.barysik.island.entity.animals;

import ua.com.barysik.island.settings.Constants;
import ua.com.barysik.island.settings.Directions;
import ua.com.barysik.island.settings.Parameters;

import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

public abstract class Herbivore extends Animal {

    @Override
    public ArrayList<Directions> run() {
        ArrayList<Directions> directions = new ArrayList<>();
        int speed = Parameters.getParameter(Constants.speed, getClass().getSimpleName());
        int rnd = ThreadLocalRandom.current().nextInt(5);

        if (getCurrentSatiety() > (Parameters.getParameterDouble(Constants.satiety, getClass().getSimpleName()) * 3 / 4)){
            directions.add(Directions.STOP);
            return directions;
        }

            for (int i = 0; i < speed; i++) {
                switch (rnd) {
                    case 0:
                        directions.add(Directions.STOP);
                        return directions;
                    case 1:
                        directions.add(Directions.LEFT);
                        continue;
                    case 2:
                        directions.add(Directions.RIGHT);
                        continue;
                    case 3:
                        directions.add(Directions.UP);
                        continue;
                    case 4:
                        directions.add(Directions.DOWN);
                }
            }
        return directions;
    }
}