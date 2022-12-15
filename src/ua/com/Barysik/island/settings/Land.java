package ua.com.Barysik.island.settings;

import ua.com.Barysik.island.baseClases.Alive;

import java.util.HashMap;
import java.util.HashSet;

public class Land {

    private static int x;
    private static int y;
    private static final HashMap<Long, HashSet<Alive>> islandCell = new HashMap<>();

    public static void newLand(int x, int y) {
        if (Land.x != 0 && Land.y != 0) {
            System.out.printf("Остров размером %d на %d создан ранее%n", Land.x, Land.y);
            return;
        }
        if (correctCell(x, y)) {
            return;
        }
        Land.x = x;
        Land.y = y;
        System.out.println("Остров создан");
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
        if (x < 1 || y < 1) {
            System.out.println("Принимаются числа больше нуля");
            return true;
        }
        if (x > Land.x || y > Land.y) {
            if (Land.x == 0 || Land.y == 0) {
                return false;
            }
            System.out.println("Ячейка не существует");
            return true;
        }
        return false;
    }

    public static void setCell(int x, int y, HashSet<Alive> hashSet) {
        if (correctCell(x, y)) {
            System.out.println("Не удалось записать информацию в ячейку");
            return;
        }
        long index = x * 1_00_000_000L + y;
        islandCell.put(index, hashSet);
    }

    public static HashSet<Alive> getCell(int x, int y) {
        if (correctCell(x, y)) {
            System.out.println("Запрошена incorrect cell -> translated.... -> дурная, злая и сварливая ячейка");
            return new HashSet<>();
        }
        long index = x * 1_00_000_000L + y;
        if (islandCell.get(index) == null){
            return new HashSet<>();
        }
            return islandCell.get(index);
    }
}