package ua.com.barysik.island.settings;

import ua.com.barysik.island.baseClases.Alive;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;

public class Land {

    private static int x = -1;
    private static int y = -1;
    private static final HashMap<Long, HashSet<Alive>> islandCell = new HashMap<>();

    public static void newLand(int x, int y) {
        if (Land.x == -1 || Land.y == -1) {
            Land.x = -100;
        }

        if (Land.x >= 0 && Land.y >= 0) {
            System.out.printf("Остров размером %d на %d создан ранее.%n", Land.x, Land.y);
            return;
        }
        if (correctCell(x, y)) {
            Land.x = -1;
            return;
        }

        Land.x = x;
        Land.y = y;

        System.out.printf("Остров размером %d на %d создан.%n", Land.x, Land.y);
    }

    public static Integer getX() {
        return Land.x;
    }

    public static Integer getY() {
        return Land.y;
    }

    private static boolean correctCell(int x, int y) {
        if (x > 10_000_000 || y > 10_000_000) {
            System.out.println("Остров не может быть больше 10_000_000 в ширину или в длину");
            return true;
        }
        if (x < 0 || y < 0) {
            System.out.println("Принимаются только положительные числа");
            return true;
        }

        if (Land.x == -100 || Land.y == -1) {
            return false;
        }

        if (x > Land.x || y > Land.y) {
            System.out.println("Ячейка не существует");
            return true;
        }
        return false;
    }

    private static void setCellHashSet(int x, int y, HashSet<Alive> hashSet) {
//        if (correctCell(x, y)) {
//            System.out.println("Не удалось записать информацию в ячейку");
//            return;
//        }
        long index = x * 1_00_000_000L + y;
        islandCell.put(index, hashSet);
    }

    private static HashSet<Alive> getCellHashSet(int x, int y) {
        long index = x * 1_00_000_000L + y;
        if (islandCell.get(index) == null) {
            return new HashSet<>();
        }
        return islandCell.get(index);
    }

    //Добавляет элемент в ячейку
    public static boolean add(int x, int y, Alive alive) {
        if (correctCell(x, y)) {
            return false;
        }
        HashSet<Alive> cell = getCellHashSet(x, y);
        boolean status = cell.add(alive);
        setCellHashSet(x, y, cell);
        return status;
    }

//    //Проверяет есть ли элемент в ячейке
//    public static boolean isExist(int x, int y, Alive alive) {
//        if (correctCell(x, y)) {
//            return false;
//        }
//        HashSet<Alive> cell = getCell(x, y);
//        return !cell.add(alive);
//    }

    //Удаляем элемент из ячейки
    public static boolean remove(int x, int y, Alive alive) {
        if (correctCell(x, y)) {
            return false;
        }
        HashSet<Alive> cell = getCellHashSet(x, y);
        boolean status = cell.remove(alive);
        setCellHashSet(x, y, cell);
        return status;
    }

    //Получаем все элементы ячейки в виде hashset
    public static HashSet<Alive> getCell(int x, int y) {
        if (correctCell(x, y)) {
            System.out.println("Запрошена incorrect cell -> translated.... -> дурная, злая и сварливая ячейка");
            return new HashSet<>();
        }
        return getCellHashSet(x, y);
    }

    //Количество объектов в ячейке
    public static Integer getAliveCell(int x, int y, Alive alive) {
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

    //Количество объектов на острове
    public static Integer getAliveIsland(Alive alive) {
        int i = 0;
        Collection<HashSet<Alive>> values = islandCell.values();
        for (HashSet<Alive> hashSet : values) {
            for (Alive allAlive : hashSet) {
                if (allAlive.getClass() == alive.getClass()) {
                    i++;
                }
            }
        }
        return i;
    }

    //Сколько всех на острове
    public static HashMap<String, Long> gelStatistics() {
        HashMap<String, Long> statistics = new HashMap<>();
        Collection<HashSet<Alive>> values = islandCell.values();
        for (HashSet<Alive> hashSet : values) {
            for (Alive alive : hashSet) {
                String name = alive.getName();
                if (statistics.containsKey(name)) {
                    Long i = statistics.get(name) + 1;
                    statistics.put(name, i);
                } else {
                    statistics.put(name, 1L);
                }
            }
        }
        return statistics;
    }
}