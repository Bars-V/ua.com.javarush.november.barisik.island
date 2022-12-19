package ua.com.barysik.island.settings;

import ua.com.barysik.island.baseClases.Alive;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;

public class Land {

    private final int x;
    private final int y;
    private final HashMap<Long, ArrayList<Alive>> islandCell = new HashMap<>();

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

    private void setCell(int x, int y, ArrayList<Alive> list) {
        if (correctCell(x, y)) {
            System.out.println("Не удалось записать информацию в ячейку");
            return;
        }
        long index = x * 1_00_000_000L + y;
        islandCell.put(index, list);
    }

    public boolean add(int x, int y, Alive alive) {
        if (correctCell(x, y)) {
            return false;
        }
        ArrayList<Alive> cell = getCell(x, y);
        boolean status = cell.add(alive);
        setCell(x, y, cell);
        return status;
    }


    public boolean remove(int x, int y, Alive alive) {
        if (correctCell(x, y)) {
            return false;
        }
        ArrayList<Alive> cell = getCell(x, y);
        boolean status = cell.remove(alive);
        setCell(x, y, cell);
        return status;
    }

    private ArrayList<Alive> getCell(int x, int y) {
        long index = x * 1_00_000_000L + y;
        if (islandCell.get(index) == null) {
            return new ArrayList<Alive>();
        }
        return islandCell.get(index);
    }

    public ArrayList getCellArrayList(int x, int y) {
        ArrayList<Alive> list = getCell(x, y);
        ArrayList<Alive> alives = new ArrayList<>();
        for (Alive alive : list) {
            alives.add(alive);
        }
        return alives;
    }

    public Integer getAmountAliveInCell(int x, int y, Alive alive) {
        int i = 0;
        correctCell(x, y);
        ArrayList<Alive> cell = getCell(x, y);
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

//    public HashMap<String, Long> getCellStatistics(int x, int y) {
//        if (correctCell(x, y)) {
//            System.out.println("Coordinate error");
//            return new HashMap<>();
//        }
//        return setToMap(getCell(x, y), new HashMap<>());
//    }

    public Collection<ArrayList<Alive>> getAll(){
        return islandCell.values();
    }

//    public HashMap<String, Long> getIslandStatistics() {
//        HashMap<String, Long> statistics = new HashMap<>();
//        Collection<HashSet<Alive>> values = islandCell.values();
//        for (HashSet<Alive> hashSet : values) {
//            setToMap(hashSet, statistics);
//        }
//        return statistics;
//    }
}