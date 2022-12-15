package ua.com.Barysik.island.baseClases;

public class Plant extends Alive implements Amount, Weight{
    @Override
    public double amount() {
        return Amount.super.amount();
    }

    @Override
    public double weight() {
        return Weight.super.weight();
    }

}