package ua.com.Barysik.island.animals;

import ua.com.Barysik.island.baseClases.Herbivore;
import ua.com.Barysik.island.baseClases.HerbivoreEat;
import ua.com.Barysik.island.baseClases.PredatorEat;

public class Duck extends Herbivore implements PredatorEat, HerbivoreEat {
    @Override
    public void dead() {

    }

    @Override
    public int amount() {
        return super.amount();
    }

    @Override
    public void run() {
        super.run();
    }

    @Override
    public void reproduction() {

    }


    @Override
    public double weight() {
        return super.weight();
    }
}
