package ua.com.Barysik.island.baseClases;

import ua.com.Barysik.island.settings.BaseParameters;

public interface Eat<T> {
    //Кушать
    default void eat(Animal eat) {

//        eat.dead(); // убиваем еду
//        вынести в отдельный метод тогда можно переопределить растения и животных

        //кто ест
        double eatWeith = BaseParameters.getEatWeith(getClass().getSimpleName());
        //кого едят
        double weight = BaseParameters.getWeight(eat.getClass().getSimpleName());

        double satietyChange;

        if (weight >= eatWeith) {
            satietyChange = eatWeith;
        } else {
            satietyChange = weight;
        }

        satiety(satietyChange);
//        System.out.println(satietyChange);
    }

    double satiety = 50;

    //сытость
    default double satiety(double change) {

        double satiety = this.satiety;
//        this.satiety = 9;

        satiety = satiety + change;

        if (satiety > 100.0) {
            satiety = 100.0;
        }

        if (satiety <= 0) {
            // объект умирает
        }

//        //кто ест
//        double eatWeith = BaseParameters.getEatWeith(getClass().getSimpleName());
//        //кого едят
//        double weight = BaseParameters.getWeight(getClass().getSimpleName());

        return satiety;
    }
}
