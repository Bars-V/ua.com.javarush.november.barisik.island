package ua.com.Barysik.island.animals;

import ua.com.Barysik.island.baseClases.*;
import ua.com.Barysik.island.settings.Constants;
import ua.com.Barysik.island.settings.Parameters;

import java.util.concurrent.ThreadLocalRandom;

public class PredatoryBush extends Alive {

    private String name = Parameters.getWords(Constants.name,getClass().getSimpleName());

    public <T> boolean hunt(T prey) {
        boolean completed;
        int chanse = Parameters.getEatTable(getClass().getSimpleName(), prey.getClass().getSimpleName());
        if(chanse == 100){
            eat(prey);
            return true;
        }
        if(chanse == 0){
            System.out.println(getClass().getSimpleName() + " не ест " + prey.getClass().getSimpleName());
            return false;
        }
        int rnd = ThreadLocalRandom.current().nextInt((100)+1);
        if (chanse >= rnd){
            eat(prey);
        } else {
            System.out.println(prey.getClass().getSimpleName() + " убежал от " + name);
            return false;
        }
        return false;
    }


    //Кушать
    private  <T> void eat(T eat) {

//        eat.dead(); // убиваем еду
//        вынести в отдельный метод тогда можно переопределить растения и животных

        double eatWeith = Parameters.getParameterDouble(Constants.eatWeith,getClass().getSimpleName());
        double weight = Parameters.getParameterDouble(Constants.weight,eat.getClass().getSimpleName());

        double satietyChange = Math.min(weight, eatWeith);

        satiety(satietyChange);

        //for test
//        System.out.println(satietyChange);
        System.out.println(name + " съел " + eat.getClass().getSimpleName());
    }


    //сытость
    private double satiety = Parameters.getParameterDouble(Constants.satiety,getClass().getSimpleName());

    public double getSatiety(){
        return this.satiety;
    }

    public void setSatiety(double satiety) {
        satiety(satiety);
    }

    private double satiety(double change) {

        this.satiety = this.satiety + change;

//        if (this.satiety > 100.0) {
//            this.satiety = 100.0;
//        }

        if (this.satiety <= 0) {
            // объект умирает
            System.out.println(name + " is dead :(");
        }
//        System.out.println(name + " насытился на  " + change);

        return this.satiety;
    }
}
