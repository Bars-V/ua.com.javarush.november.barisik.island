package ua.com.barysik.island.settings;

import ua.com.barysik.island.baseClases.Alive;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;

public class Land {

    private final int x;
    private final int y;
    private final HashMap<Long, HashSet<Alive>> islandCell = new HashMap<>();

    public Land(int x, int y) {
        this.x = x;
        this.y = y;
        System.out.printf("Остров размером %d на %d создан.%n", this.x, this.y);
    }

    public Integer getX() {
        return this.x;
    }

    public Integer getY() {
        return this.y;
    }

    private boolean correctCell(int x, int y) {
        if (x > 10_000_000 || y > 10_000_000) {
            System.out.println("Остров не может быть больше 10_000_000 в ширину или в длину");
            return true;
        }
        if (x < 0 || y < 0) {
            System.out.println("Принимаются только положительные числа");
            return true;
        }

        if (x > this.x || y > this.y) {
            System.out.println("Ячейка не существует");
            return true;
        }
        return false;
    }

    private void setCellHashSet(int x, int y, HashSet<Alive> hashSet) {
        if (correctCell(x, y)) {
            System.out.println("Не удалось записать информацию в ячейку");
            return;
        }
        long index = x * 1_00_000_000L + y;
        islandCell.put(index, hashSet);
    }

    public boolean add(int x, int y, Alive alive) {
        if (correctCell(x, y)) {
            return false;
        }
        HashSet<Alive> cell = getCellHashSet(x, y);
        boolean status = cell.add(alive);
        setCellHashSet(x, y, cell);
        return status;
    }


    public boolean remove(int x, int y, Alive alive) {
        if (correctCell(x, y)) {
            return false;
        }
        HashSet<Alive> cell = getCellHashSet(x, y);
        boolean status = cell.remove(alive);
        setCellHashSet(x, y, cell);
        return status;
    }

    public HashSet<Alive> getCellHashSet(int x, int y) {
        long index = x * 1_00_000_000L + y;
        if (islandCell.get(index) == null) {
            return new HashSet<>();
        }
        return islandCell.get(index);
    }

    public Integer getAmountAliveInCell(int x, int y, Alive alive) {
        int i = 0;
        correctCell(x, y);
        HashSet<Alive> cell = getCellHashSet(x, y);
        for (Alive allAlive : cell) {
            if (allAlive.getClass() == alive.getClass()) {
                i++;
            }
        }
        return i;
    }

    private HashMap<String, Long> setToMap(HashSet<Alive> hashSet, HashMap<String, Long> statistics) {
        for (Alive alive : hashSet) {
            String name = alive.getName();
            if (statistics.containsKey(name)) {
                Long i = statistics.get(name) + 1;
                statistics.put(name, i);
            } else {
                statistics.put(name, 1L);
            }
        }
        return statistics;
    }

    public HashMap<String, Long> gelCellStatistics(int x, int y) {
        if (correctCell(x, y)) {
            System.out.println("Coordinate error");
            return new HashMap<>();
        }
        return setToMap(getCellHashSet(x, y), new HashMap<>());
    }


    public HashMap<String, Long> gelIslandStatistics() {
        HashMap<String, Long> statistics = new HashMap<>();
        Collection<HashSet<Alive>> values = islandCell.values();
        for (HashSet<Alive> hashSet : values) {
            setToMap(hashSet, statistics);
        }
        return statistics;
    }
}