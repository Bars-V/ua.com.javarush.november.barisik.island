package ua.com.Barysik.island.baseClases;

import ua.com.Barysik.island.settings.Constants;
import ua.com.Barysik.island.settings.Parameters;

public abstract class Alive {

    private final String name = Parameters.getWords(Constants.name, getClass().getSimpleName());

    public String getName() {
        return name;
    }
}
