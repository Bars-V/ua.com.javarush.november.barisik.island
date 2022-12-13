package ua.com.Barysik.island.baseClases;

import ua.com.Barysik.island.settings.BaseParameters;

import java.util.concurrent.ThreadLocalRandom;

public abstract class Animal implements Amount, Weight {

    // выбрать направление движения
    private int chooseDirection(int i) {
        return ThreadLocalRandom.current().nextInt(i);
    }

    //    двигаться
    public void run() {

        int index = 4; //количество направлений

        for (int i = 0; i < BaseParameters.getSpeed(getClass().getSimpleName()); i++) {

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


    //Кушать
    public <T> void eat(T eat) {

//        eat.dead(); // убиваем еду
//        вынести в отдельный метод тогда можно переопределить растения и животных

        //кто ест
        double eatWeith = BaseParameters.getEatWeith(getClass().getSimpleName());
        //кого едят
        double weight = BaseParameters.getWeight(eat.getClass().getSimpleName());

        double satietyChange = Math.min(weight, eatWeith);

        satiety(satietyChange);

        //for test
//        System.out.println(satietyChange);
    }

    //сытость
    private double satiety = 100;

    private double satiety(double change) {

//        double satiety = this.satiety;

        this.satiety = this.satiety + change;

        if (this.satiety > 100.0) {
            this.satiety = 100.0;
        }

        if (this.satiety <= 0) {
            // объект умирает
            System.out.println(getClass().getSimpleName() + " is dead :(");
        }
//        System.out.println(getClass().getSimpleName() + " принял на грудь " + change + " грамм и доволен");

        return this.satiety;
    }


//    //размножение
//    public abstract void reproduction();
//
//    //    умереть?
//    public abstract void dead();
//
//    //насыщение - через обращение к таблице
//    //метод для убывания насыщения

}
