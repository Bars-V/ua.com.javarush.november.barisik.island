package ua.com.barysik.island.utility;

import ua.com.barysik.island.animals.*;
import ua.com.barysik.island.baseClases.*;
import ua.com.barysik.island.settings.*;

import java.util.HashSet;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class Initialization {

    public void start() {

        FillTable.startTable();

        System.out.println("Введите размер острова по горизонтали");
        int coordinateX = new Scanner(System.in).nextInt();

        System.out.println("Введите размер острова по вертикали");
        int coordinateY = new Scanner(System.in).nextInt();

        Land.newLand(coordinateX, coordinateY);

        for (int i = 0; i < coordinateX; i++) {
            for (int j = 0; j < coordinateY; j++) {
                fillingCell(i, j);
                System.out.printf("Cell №\t%d\tcreated\n", ++cellcalc);
            }
        }
    }

    private static int cellcalc = 0;

    private void fillingCell(int x, int y) {

        HashSet<Class<? extends Alive>> aliveClass = new HashSet<>();

        aliveClass.add(Wolf.class);
        aliveClass.add(Horse.class);
        aliveClass.add(Duck.class);
        aliveClass.add(Caterpillar.class);
        aliveClass.add(Plant.class);
        aliveClass.add(Bush.CarnivorousBush.class);

        for (Class<? extends Alive> aClass : aliveClass) {

            int amount = Parameters.getParameter(Constants.amount, aClass.getSimpleName());
            int probability = ThreadLocalRandom.current().nextInt(amount);

            for (int i = 0; i < probability; i++) {
                try {
                    Land.add(x, y, aClass.newInstance());
                } catch (InstantiationException e) {
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
