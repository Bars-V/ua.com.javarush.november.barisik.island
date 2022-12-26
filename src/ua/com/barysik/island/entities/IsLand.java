package ua.com.barysik.island.entities;

import ua.com.barysik.island.settings.Constants;
import ua.com.barysik.island.settings.Parameters;

import java.util.Collection;
import java.util.HashMap;
import java.util.concurrent.CopyOnWriteArrayList;

public class IsLand {

    private final int width;
    private final int height;
    private final HashMap<Long, CopyOnWriteArrayList<Alive>> islandCell = new HashMap<>();


    public IsLand(int width, int height) {
        this.width = width;
        this.height = height;
//        System.out.printf("An island the size %d to %d created.%n", this.width, this.height);
    }

    public Integer getWidth() {
        return this.width;
    }

    public Integer getHeight() {
        return this.height;
    }

    private boolean correctCell(int width, int height) {
        if (width > 10_000_000 || height > 10_000_000) {
            System.out.println("The island cannot be larger than 10_000_000 in width or height.");
            return true;
        }
        if (width < 0 || height < 0) {
            System.out.println("Only positive numbers are accepted");
            return true;
        }

        if (width > this.width || height > this.height) {
            System.out.println("Cell does not exist");
            return true;
        }
        return false;
    }

    private void setCell(int width, int height, CopyOnWriteArrayList<Alive> set) {
        long index = width * 1_00_000_000L + height;
//        index = numberTargetMap * (long) Math.pow(10.0, 15.0) + index;
        islandCell.put(index, set);
    }

    public boolean add(int width, int height, Alive alive) {
        if (correctCell(width, height)) {
            return false;
        }
        int maxAmount = Parameters.getParameter(Constants.amount, alive.getClass().getSimpleName());
        int currentAmount = getAmountAliveInCell(width, height, alive);
        if (maxAmount - currentAmount < 1) {
            return false;
        }
        CopyOnWriteArrayList<Alive> cell = getCell(width, height);
        boolean statusWrite = cell.add(alive);
        setCell(width, height, cell);
        return statusWrite;
    }

    public void remove(int width, int height,  Alive alive) {
        if (correctCell(width, height)) {
            return;
        }
        CopyOnWriteArrayList<Alive> cell = getCell(width, height);
        cell.remove(alive);
        setCell(width, height, cell);
    }

    private CopyOnWriteArrayList<Alive> getCell(int width, int height) {
        long index = width * 1_00_000_000L + height;
//        index = numberTargetMap * (long) Math.pow(10.0, 15.0) + index;
        if (islandCell.get(index) == null) {
            return new CopyOnWriteArrayList<>();
        }
        return islandCell.get(index);
    }

    public void shuffleCell(int width, int height) {
        setCell(width, height, getCellList(width, height));
    }

    public CopyOnWriteArrayList<Alive> getCellList(int width, int height) {
        return getCell(width, height);
    }

    public Integer getAmountAliveInCell(int width, int height, Alive alive) {
        int i = 0;
        if (correctCell(width, height)) {
            return 0;
        }
        CopyOnWriteArrayList<Alive> cell = getCell(width, height);
        if (cell.size() == 0){
            return 0;
        }
        for (Alive allAlive : cell) {
            if (allAlive.getClass() == alive.getClass()) {
                i++;
            }
        }
        return i;
    }

    public Collection<CopyOnWriteArrayList<Alive>> getAll() {
        return islandCell.values();
    }
}