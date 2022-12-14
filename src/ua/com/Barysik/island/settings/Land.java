package ua.com.Barysik.island.settings;

import ua.com.Barysik.island.baseClases.Animal;

import java.util.HashSet;

public class Land {

    private static HashSet<Object>[][] land;

    public static void setAnimal(Animal animal) {
        // принять в ячейку
    }

    public static HashSet<Object>[][] getLand() {
        return land;
    }

    public static HashSet<Object> getCell(int x, int y) {
        return land[x][y];
    }

    public static void setCell(int x, int y, HashSet hashSet) {
         land[x][y] = (HashSet<Object>) hashSet.clone();
    }

    public static void newLand(int x, int y) {
        if (land != null) {
            System.out.println("Остров уже создан");
            return;
        }
        land = new HashSet[x][y];

        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                land[i][j] = new HashSet<Object>();
            }
        }
    }
}