package ua.com.barysik.island.entity;

import ua.com.barysik.island.entity.Alive;
import ua.com.barysik.island.settings.Constants;
import ua.com.barysik.island.settings.Parameters;

import java.util.Collection;
import java.util.HashMap;
import java.util.concurrent.CopyOnWriteArrayList;

public class IsLand {

    private final int width;
    private final int length;
    private final HashMap<Long, CopyOnWriteArrayList<Alive>> islandCell = new HashMap<>();


    public IsLand(int width, int length) {
        this.width = width;
        this.length = length;
        System.out.printf("An island the size %d to %d created.%n", this.width, this.length);
    }

    public Integer getWidth() {
        return this.width;
    }

    public Integer getLength() {
        return this.length;
    }

    private boolean correctCell(int width, int length) {
        if (width > 10_000_000 || length > 10_000_000) {
            System.out.println("The island cannot be larger than 10_000_000 in width or length.");
            return true;
        }
        if (width < 0 || length < 0) {
            System.out.println("Only positive numbers are accepted");
            return true;
        }

        if (width > this.width || length > this.length) {
            System.out.println("Cell does not exist");
            return true;
        }
        return false;
    }

    private void setCell(int width, int length, CopyOnWriteArrayList<Alive> set) {
        long index = width * 1_00_000_000L + length;
        islandCell.put(index, set);
    }

    public boolean add(int width, int length, Alive alive) {
        if (correctCell(width, length)) {
            return false;
        }
        int maxAmount = Parameters.getParameter(Constants.amount, alive.getClass().getSimpleName());
        int currentAmount = getAmountAliveInCell(width, length, alive);
        if (maxAmount - currentAmount < 1) {
            return false;
        }
        CopyOnWriteArrayList<Alive> cell = getCell(width, length);
        boolean statusWrite = cell.add(alive);
        setCell(width, length, cell);
        return statusWrite;
    }


    public boolean remove(int width, int length, Alive alive) {
        if (correctCell(width, length)) {
            return false;
        }
        CopyOnWriteArrayList<Alive> cell = getCell(width, length);
        boolean statusWrite = cell.remove(alive);
        setCell(width, length, cell);
        return statusWrite;
    }

    private CopyOnWriteArrayList<Alive> getCell(int width, int length) {
        long index = width * 1_00_000_000L + length;
        if (islandCell.get(index) == null) {
            return new CopyOnWriteArrayList<>();
        }
        return islandCell.get(index);
    }

    public CopyOnWriteArrayList<Alive> getCellList(int width, int length) {
//        CopyOnWriteArrayList<Alive> list = getCell(width, length);
//        CopyOnWriteArrayList<Alive> alives = new CopyOnWriteArrayList<>();
//        for (Alive alive : list) {
//            alives.add(alive);
//        }
        return getCell(width, length);
    }

    public Integer getAmountAliveInCell(int width, int length, Alive alive) {
        int i = 0;
        if (correctCell(width, length)) {
            return 0;
        }
        CopyOnWriteArrayList<Alive> cell = getCell(width, length);
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