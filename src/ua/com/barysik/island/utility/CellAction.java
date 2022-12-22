package ua.com.barysik.island.utility;

import ua.com.barysik.island.entities.Alive;
import ua.com.barysik.island.entities.animals.Animal;
import ua.com.barysik.island.entities.plants.Plant;
import ua.com.barysik.island.settings.Constants;
import ua.com.barysik.island.settings.Directions;
import ua.com.barysik.island.settings.Parameters;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ThreadLocalRandom;

public class CellAction extends Thread {

    private final int width;
    private final int height;

    public CellAction(int width, int height) {
        this.width = width;
        this.height = height;
    }

    @Override
    public void run() {
        while (!isInterrupted()) {
            deathByHunger(Initialization.island.getCellList(this.width, this.height));
            Initialization.island.shuffleCell(this.width, this.height);
            search(Initialization.island.getCellList(this.width, this.height));
            reproduce(new Plant());
            CopyOnWriteArrayList<Alive> cellList = Initialization.island.getCellList(this.width, this.height);
            for (Alive alive : cellList) {
                if (alive instanceof Animal) {
                    if (((Animal) alive).getGoAway()) {
                        transition((Animal) alive);
                    }
                }
            }
            accept();
        }
    }

    private void transition(Animal animal) {
        int movingWidth = this.width;
        int movingHeight = this.height;
        ArrayList<Directions> direction = animal.run();

        for (int i = 0; i < direction.size(); i++) {

            if (direction.get(0) == Directions.LEFT) {
                movingWidth = movingWidth - 1;
            } else if (direction.get(0) == Directions.RIGHT) {
                movingWidth = movingWidth + 1;
            } else if (direction.get(0) == Directions.UP) {
                movingHeight = movingHeight + 1;
            } else if (direction.get(0) == Directions.DOWN) {
                movingHeight = movingHeight - 1;
            }
            direction.remove(0);

            if (movingWidth < 0) {
                movingWidth = Initialization.island.getWidth() - movingWidth;
                if (movingWidth < 0) {
                    movingWidth = this.width;
                }
            }

            if (movingHeight < 0) {
                movingHeight = Initialization.island.getHeight() - movingHeight;
                if (movingHeight < 0) {
                    movingHeight = this.height;
                }
            }
        }

        boolean triggerA = movingWidth == this.width;
        boolean triggerB = movingHeight == this.height;
        boolean triggerC = Initialization.island.getAmountAliveInCell(movingWidth, movingHeight, animal) < animal.getAmount();

        if (!triggerA && !triggerB && triggerC) {
            Initialization.islandTwo.add(movingWidth, movingHeight, animal);
            Initialization.island.remove(this.width, this.height, animal);
        }
    }

    private void accept() {
        while (true) {
            CopyOnWriteArrayList<Alive> runList = Initialization.islandTwo.getCellList(this.width, this.height);
            if (runList.size() == 0) {
                return;
            }
            Alive alive = runList.get(0);
            Initialization.island.add(this.width, this.height, alive);
            Initialization.islandTwo.remove(this.width, this.height, alive);
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
            Initialization.island.remove(this.width, this.height, prey);
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
        int currentAmount = Initialization.island.getAmountAliveInCell(this.width, this.height, alive);
        int children = Parameters.getParameter(Constants.children, alive.getClass().getSimpleName());

        if (children != 0) {
            countNewAlives = ThreadLocalRandom.current().nextInt(children) + 1;
        } else if (maxAmount - currentAmount > 0) {
            countNewAlives = ThreadLocalRandom.current().nextInt(maxAmount - currentAmount);
        }

        for (int i = 0; i < countNewAlives; i++) {
            try {
                boolean add = Initialization.island.add(this.width, this.height, alive.getClass().getDeclaredConstructor().newInstance());
                if (!add) {
                    break;
                }
//                    System.out.println("Родился новый " + alive.getClass().getSimpleName());
            } catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
                e.printStackTrace();
                System.out.println("Object " + alive.getClass().getSimpleName() + " create error in cell: " + this.width + " " + this.height);
            }
        }
    }
}
