package ua.com.barysik.island.baseClases;

import ua.com.barysik.island.utility.Animal;

public abstract class Herbivore extends Animal {
    @Override
    public void run() {
        //Ходят только если насыщение меньше 70%
        super.run();
    }
}