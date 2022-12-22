package ua.com.barysik.island.utility;

import ua.com.barysik.island.entities.Alive;
import ua.com.barysik.island.entities.animals.Animal;
import ua.com.barysik.island.entities.plants.Plant;
import ua.com.barysik.island.settings.Constants;
import ua.com.barysik.island.settings.Parameters;

import java.lang.reflect.InvocationTargetException;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ThreadLocalRandom;

public class CellAction extends Thread {

    private final int width;
    private final int length;
//    private hashMap<>();

    public CellAction(int width, int length) {
        this.width = width;
        this.length = length;
    }

//    public int getWidth() {
//        return width;
//    }
//
//    public int getLength() {
//        return length;
//    }

    @Override
    public void run() {
        while (!isInterrupted()) {
            deathByHunger(Initialization.island.getCellList(this.width, this.length, 0));
            Initialization.island.shuffleCell(this.width, this.length);
            search(Initialization.island.getCellList(this.width, this.length, 0));
            reproduce(new Plant());
            //решили уйти
            //смогли уйти
            //если нельзя пройти генерация в другом направлении
            //если координаты за размерами поля
            accept();
        }
    }

    private boolean isLeave() {

        boolean isLeave = true;
        // если что? то хочет уйти
        return isLeave;
    }

    private void leave(Alive alive) {

//        if(хотят уйти?)
//        if(умещаются в новой локации?)

            Initialization.island.add(this.width, this.length, 1, alive);
            Initialization.island.remove(this.width, this.length, 0, alive);

//            если не умещаются, то заново генерировать путь
//            генерация пути по методу для животного
//            предусмотреть вход и выход метода
    }

    private void accept() {
        while (true) {
            CopyOnWriteArrayList<Alive> runList = Initialization.island.getCellList(this.width, this.length, 1);
            if (runList.size() == 0) {
                return;
            }
            Alive alive = runList.get(0);
            Initialization.island.add(this.width, this.length, 0, alive);
            Initialization.island.remove(this.width, this.length, 1, alive);
        }
    }


    private void search(CopyOnWriteArrayList<Alive> alivesList) {

        for (int i = 0; i < alivesList.size(); i = i + 2) {
            int next = i + 1;
            Alive aliveOne = alivesList.get(i);
            Alive aliveTwo = null;

            if (next < alivesList.size()) {
                aliveTwo = alivesList.get(next);
            }

            if (aliveTwo == null) {
                continue;
            }

            if (aliveOne instanceof Animal) {
                ((Animal) aliveOne).hunger();
            }

            if (aliveTwo instanceof Animal) {
                ((Animal) aliveTwo).hunger();
            }

            if (aliveOne.getClass() == aliveTwo.getClass() && aliveOne instanceof Animal) {
                reproduce(aliveOne);
            } else if (aliveOne instanceof Animal && aliveTwo instanceof Plant) {
                hunt(aliveOne, aliveTwo);
            } else if (aliveTwo instanceof Animal && aliveOne instanceof Plant) {
                hunt(aliveTwo, aliveOne);
            } else if (aliveOne instanceof Plant || aliveTwo instanceof Plant) {
            } else if (Parameters.getEatTable(aliveOne.getClass().getSimpleName(), aliveTwo.getClass().getSimpleName()) > 0) {
                hunt(aliveOne, aliveTwo);
            } else if (Parameters.getEatTable(aliveTwo.getClass().getSimpleName(), aliveOne.getClass().getSimpleName()) > 0) {
                hunt(aliveTwo, aliveOne);
            }
        }
    }

    private void hunt(Alive hunter, Alive prey) {
        boolean hunt = ((Animal) hunter).hunt(prey);
        if (hunt) {
            Initialization.island.remove(this.width, this.length, 0, prey);
        }
    }

    private void deathByHunger(CopyOnWriteArrayList<Alive> alives) {
        for (Alive alive : alives) {
            if (alive instanceof Plant) {
                continue;
            }
            if (((Animal) alive).getCurrentSatiety() < 0.001) {
                alives.remove(alive);
            }
        }
    }

    private void reproduce(Alive alive) {

        int countNewAlives = 0;
        int maxAmount = Parameters.getParameter(Constants.amount, alive.getClass().getSimpleName());
        int currentAmount = Initialization.island.getAmountAliveInCell(this.width, this.length, alive);
        int children = Parameters.getParameter(Constants.children, alive.getClass().getSimpleName());

        if (children != 0) {
            countNewAlives = ThreadLocalRandom.current().nextInt(children) + 1;
        } else if (maxAmount - currentAmount > 0) {
            countNewAlives = ThreadLocalRandom.current().nextInt(maxAmount - currentAmount);
        }

        for (int i = 0; i < countNewAlives; i++) {
            try {
                boolean add = Initialization.island.add(this.width, this.length, 0, alive.getClass().getDeclaredConstructor().newInstance());
                if (!add) {
                    break;
                }
//                    System.out.println("Родился новый " + alive.getClass().getSimpleName());
            } catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
                e.printStackTrace();
                System.out.println("Object " + alive.getClass().getSimpleName() + " create error in cell: " + this.width + " " + this.length);
            }
        }
    }
}
