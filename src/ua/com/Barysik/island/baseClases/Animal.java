package ua.com.Barysik.island.baseClases;

public abstract class Animal implements Amount, Weight {
    //есть
    public abstract void eat();

    // выбрать направление движения
    public int chooseDirection() {
        //rnd потокобезопасный
        return 0;
    }

    //    двигаться
    public abstract void run();

    //размножение
    public abstract void reproduction();

    //умереть?
    public abstract void dead();

    //насыщение - через обращение к таблице
    //скорость  - через обращение к таблице
}
