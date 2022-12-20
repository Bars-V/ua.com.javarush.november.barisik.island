package ua.com.barysik.island.entities.animals;

import ua.com.barysik.island.entities.Alive;
import ua.com.barysik.island.settings.Constants;
import ua.com.barysik.island.settings.Directions;
import ua.com.barysik.island.settings.Parameters;

import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

public abstract class Animal extends Alive {

    private final double maxSatiety = Parameters.getParameterDouble(Constants.satiety, getClass().getSimpleName());
    private double currentSatiety = maxSatiety;
    private final double hunger = maxSatiety * Parameters.getParameterDouble(Constants.hunger, getClass().getSimpleName()) / 100;
    private final double eatWeith = Parameters.getParameterDouble(Constants.eatWeith, getClass().getSimpleName());
    private final int speed = Parameters.getParameter(Constants.speed, getClass().getSimpleName());

    public double getCurrentSatiety() {
        return currentSatiety;
    }

    private int rnd(int i) {
        return ThreadLocalRandom.current().nextInt(i);
    }

    public ArrayList<Directions> run() {

        ArrayList<Directions> directions = new ArrayList<>();
        int speed = Parameters.getParameter(Constants.speed, getClass().getSimpleName());

        for (int i = 0; i < speed; i++) {

            switch (rnd(5)) {
                case 0:
                    directions.add(Directions.STOP);
                    continue;
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


    public <T> boolean hunt(T prey) {
        int chanse = Parameters.getEatTable(getClass().getSimpleName(), prey.getClass().getSimpleName());
        if (chanse == 100) {
            eat(prey);
            return true;
        }
        if (chanse == 0) {
            return false;
        }
        int rnd = rnd(100) + 1;
        if (chanse >= rnd) {
            eat(prey);
        } else {
            return false;
        }
        return false;
    }

    private <T> void eat(T eat) {

        double weight = Parameters.getParameterDouble(Constants.weight, eat.getClass().getSimpleName());

        double satietyChange = Math.min(weight, this.eatWeith);

        satiety(satietyChange);
    }

    public void hunger() {
        satiety(-hunger);
    }

    private void satiety(double change) {

        this.currentSatiety = this.currentSatiety + change;

        if (this.currentSatiety > maxSatiety) {
            this.currentSatiety = maxSatiety;
        }

        if (this.currentSatiety < 0) {
            this.currentSatiety = -1;
        }
    }
}