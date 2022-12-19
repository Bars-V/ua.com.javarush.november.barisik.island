package ua.com.barysik.island.utility;

import ua.com.barysik.island.animals.Caterpillar;
import ua.com.barysik.island.baseClases.Alive;
import ua.com.barysik.island.baseClases.Plant;
import ua.com.barysik.island.settings.Constants;
import ua.com.barysik.island.settings.Parameters;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

//public class Action extends Thread {
public class Cell extends Thread {

    private final int x;
    private final int y;

    public Cell(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    @Override
    public void run() {
//        while (true) {
        while (!isInterrupted()) {
            starvation(Initialization.land.getCellArrayList(this.x, this.y));
            find(Initialization.land.getCellArrayList(this.x, this.y));
            //решили уйти
            //смогли уйти
            reproduce(new Plant());
            System.out.println(Initialization.land.getCellStatistics(this.x, this.y));
        }
    }

    public void find(ArrayList<Alive> alives) {
        int size = alives.size();
        for (int i = 0; i < size; i = i + 2) {
            int next = i + 1;

//            System.out.println("_________________________\n Цикл " + i + "\t" +" cell " + this.x + " " + this.y + "\n_________________________");

            Alive a = alives.get(i);
            Alive b = null;
            if (next < size) {
                b = alives.get(next);
            }

            if (b == null) {
                continue;
            }

            if (a instanceof Animal) {
                ((Animal) a).hunger();
            }

            if (b instanceof Animal) {
                ((Animal) b).hunger();
            }

            if (a.getClass() == b.getClass() && a instanceof Animal) {
                reproduce(a);
            }

            if (a instanceof Animal && b instanceof Plant) {
                hunt(a, b);
                continue;
            } else if (b instanceof Animal && a instanceof Plant) {
                hunt(b, a);
                continue;
            } else if (a instanceof Plant || b instanceof Plant) {
                continue;
            } else if (Parameters.getEatTable(a.getClass().getSimpleName(), b.getClass().getSimpleName()) > 0) {
                hunt(a, b);
            } else if (Parameters.getEatTable(b.getClass().getSimpleName(), a.getClass().getSimpleName()) > 0) {
                hunt(b, a);
            }
//            System.out.println("satyety " + a.getClass().getSimpleName()+ " = " + ((Animal) a).getCurrentSatiety());
        }
    }

    private void hunt(Alive hunter, Alive prey) {
        double currentSatiety = ((Animal) hunter).getCurrentSatiety();
        ((Animal) hunter).hunt(prey);
        if (currentSatiety != ((Animal) hunter).getCurrentSatiety()) {
//            System.out.println(hunter + " съел " + prey);
            Initialization.land.remove(this.x, this.y, prey);
        } else if(hunter instanceof Caterpillar && prey instanceof Plant){
            Initialization.land.remove(this.x, this.y, prey);
        }
    }

    private void starvation(ArrayList<Alive> alives) {
        for (Alive alive : alives) {
            if (alive instanceof Plant) {
                continue;
            }
            if (((Animal) alive).getCurrentSatiety() < 0.001) {
//                System.out.println("satyety " + alive.getClass().getSimpleName() + " = " + ((Animal) alive).getCurrentSatiety());
                Initialization.land.remove(this.x, this.y, alive);
//                System.out.println(alive.getName() + " умер от голода");
            }
        }
    }

    private void reproduce(Alive alive) {
        int countNewAlives = 0;
        if (Parameters.getParameter(Constants.children, alive.getClass().getSimpleName()) != 0) {
            countNewAlives = Parameters.getParameter(Constants.children, alive.getClass().getSimpleName()) / 2;
        } else {
            int maxAmount = Parameters.getParameter(Constants.amount, alive.getClass().getSimpleName());
            int currentAmount = Initialization.land.getAmountAliveInCell(this.x, this.y, alive);
            countNewAlives = ThreadLocalRandom.current().nextInt(maxAmount - currentAmount) / 2;
        }
        for (int i = 0; i < countNewAlives; i++) {
            try {
                if (Parameters.getParameter(Constants.amount, alive.getClass().getSimpleName()) > Initialization.land.getAmountAliveInCell(this.x, this.y, alive)) {
                    Initialization.land.add(this.x, this.y, alive.getClass().getDeclaredConstructor().newInstance());
                }
            } catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
                e.printStackTrace();
                System.out.println("Object " + alive.getClass().getSimpleName() + " create error in cell: " + this.x + " " + this.y);
            }
        }
    }
}
