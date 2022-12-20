package ua.com.barysik.island.entity;

import ua.com.barysik.island.settings.Constants;
import ua.com.barysik.island.settings.Parameters;

public abstract class Alive {

    private final String name = Parameters.getWords(Constants.name, getClass().getSimpleName());

    public String getName() {
        return name;
    }
}
