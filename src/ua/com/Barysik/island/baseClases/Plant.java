package ua.com.Barysik.island.baseClases;

public class Plant implements Amount, Weight{
    @Override
    public double amount() {
        return Amount.super.amount();
    }

    @Override
    public double weight() {
        return Weight.super.weight();
    }

    //рост
    void reproduction() {
    }
}