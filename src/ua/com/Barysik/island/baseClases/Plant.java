package ua.com.Barysik.island.baseClases;

public class Plant implements Amount, Weight{
    @Override
    public int amount() {
        return 200;
    }

    @Override
    public int weight() {
        return 1;
    }

    //рост
    void reproduction() {
    }

}
