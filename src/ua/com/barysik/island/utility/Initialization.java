package ua.com.barysik.island.utility;

import ua.com.barysik.island.entities.animals.*;
import ua.com.barysik.island.entities.Alive;
import ua.com.barysik.island.entities.plants.Plant;
import ua.com.barysik.island.settings.Constants;
import ua.com.barysik.island.entities.IsLand;
import ua.com.barysik.island.settings.Parameters;

import java.lang.reflect.InvocationTargetException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class Initialization {

    public static IsLand island;

    private int cellcalc = 0;

    public void start() {

        FillParameters.startTable();

        System.out.println("Введите размер острова по горизонтали");
        int width = new Scanner(System.in).nextInt();

        System.out.println("Введите размер острова по вертикали");
        int length = new Scanner(System.in).nextInt();

        if (width > 10_000_000 || length > 10_000_000) {
            System.out.println("Остров не может быть больше 10_000_000 в ширину или в длину");
            return;
        }
        if (width < 0 || length < 0) {
            System.out.println("Принимаются только положительные числа");
            return;
        }

//        for test
//        int width = 2;
//        int length = 2;

        island = new IsLand(width, length);

        for (int i = 0; i < width; i++) {
            for (int j = 0; j < length; j++) {
                fillingCell(i, j);
//                new CellAction(i, j);
                new Thread(new CellAction(i, j)).start();
                System.out.printf("Cell №\t%d\tcreated\n", ++cellcalc);
            }
        }
        new Thread(new Statistics()).start();
    }

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
                    island.add(x, y, 0, aClass.getDeclaredConstructor().newInstance());
                } catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
