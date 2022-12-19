package ua.com.barysik.island.utility;

import ua.com.barysik.island.baseClases.Alive;
import ua.com.barysik.island.settings.*;

import java.util.concurrent.ThreadLocalRandom;

public abstract class Animal extends Alive {

    //Поля класса
    private final double maxSatiety = Parameters.getParameterDouble(Constants.satiety, getClass().getSimpleName());
    private double currentSatiety = maxSatiety;
    private final double hunger = maxSatiety * Parameters.getParameterDouble(Constants.hunger, getClass().getSimpleName()) / 100;
    private final double eatWeith = Parameters.getParameterDouble(Constants.eatWeith, getClass().getSimpleName());

    public double getCurrentSatiety() {
        return currentSatiety;
    }

    //Выбрать направление движения
    private int chooseDirection(int i) {
        return ThreadLocalRandom.current().nextInt(i);
    }

    //Двигаться
    public void run() {

        int index = 5; //количество направлений

        for (int i = 0; i < Parameters.getParameter(Constants.speed, getClass().getSimpleName()); i++) {

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
            } else if (selection == 4) {
                System.out.println("Остаемся на месте");
            }
        }
    }

    //Охота
    public <T> boolean hunt(T prey) {
        boolean completed;
        int chanse = Parameters.getEatTable(getClass().getSimpleName(), prey.getClass().getSimpleName());
        if (chanse == 100) {
            eat(prey);
            return true;
        }
        if (chanse == 0) {
//            System.out.println(getClass().getSimpleName() + " не ест " + prey.getClass().getSimpleName());
            return false;
        }
        int rnd = chooseDirection(100) + 1;
        if (chanse >= rnd) {
            eat(prey);
        } else {
//            System.out.println(prey.getClass().getSimpleName() + " убежал от " + getClass().getSimpleName());
            return false;
        }
        return false;
    }


    //Кушать
    private <T> void eat(T eat) {

        double weight = Parameters.getParameterDouble(Constants.weight, eat.getClass().getSimpleName());

        double satietyChange = Math.min(weight, this.eatWeith);

        //for test
//        System.out.println(getClass().getSimpleName() + " съел " + eat.getClass().getSimpleName());

        satiety(satietyChange);
    }

    //Голод
    public void hunger() {
        satiety(-hunger);
    }

    //Сытость
    private void satiety(double change) {

        this.currentSatiety = this.currentSatiety + change;

        if (this.currentSatiety > maxSatiety) {
            this.currentSatiety = maxSatiety;
        }

        if (this.currentSatiety <= 0) {
            this.currentSatiety = 0;
        }

//        System.out.println(getClass().getSimpleName() + " насытился/проголодался на  " + change);
    }
}