package ua.com.Barysik.island.baseClases;

import ua.com.Barysik.island.settings.Table;

import java.util.concurrent.ThreadLocalRandom;

public abstract class Animal implements Amount, Weight {

    //есть
//    public abstract void eat();

    // выбрать направление движения
    private int chooseDirection(int i) {
        return ThreadLocalRandom.current().nextInt(i);
    }

    //    двигаться
    public void run() {
        int index = 4; //количество направлений

        for (int i = 0; i < Table.getSpeed(getClass().getSimpleName()) ; i++) {

            int selection = chooseDirection(index);

//          Временная затычка
            if (selection == 0) {
                System.out.println("Идем налево");
            } else if (selection == 1) {
                System.out.println("Идем направо");
            } else if (selection == 2) {
                System.out.println("Идем вверх");
            } else if (selection == 3) {
                System.out.println("Идем вниз");
            }
        }
    }


    //размножение
    public abstract void reproduction();

    //умереть?
    public abstract void dead();

    //насыщение - через обращение к таблице

}
