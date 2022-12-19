package ua.com.barysik.island.utility;

import ua.com.barysik.island.animals.*;
import ua.com.barysik.island.baseClases.*;
import ua.com.barysik.island.settings.*;

import java.lang.reflect.InvocationTargetException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class Initialization {

    public static Land land;

    public void start() {

        FillTable.startTable();

//        System.out.println("Введите размер острова по горизонтали");
//        int coordinateX = new Scanner(System.in).nextInt();
//
//        System.out.println("Введите размер острова по вертикали");
//        int coordinateY = new Scanner(System.in).nextInt();
//
//        if (coordinateX > 10_000_000 || coordinateY > 10_000_000) {
//            System.out.println("Остров не может быть больше 10_000_000 в ширину или в длину");
//            return;
//        }
//        if (coordinateX < 0 || coordinateY < 0) {
//            System.out.println("Принимаются только положительные числа");
//            return;
//        }
        int coordinateX = 1;
        int coordinateY = 1;


        land = new Land(coordinateX, coordinateY);


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
//        aliveClass.add(Bush.CarnivorousBush.class);

        for (Class<? extends Alive> aClass : aliveClass) {

            int amount = Parameters.getParameter(Constants.amount, aClass.getSimpleName());
            int probability = ThreadLocalRandom.current().nextInt(amount);

            for (int i = 0; i < probability; i++) {

                try {

                    land.add(x, y, aClass.getDeclaredConstructor().newInstance());

                } catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
                    e.printStackTrace();
                    System.out.println("Object " + aClass.getSimpleName() + " create error in cell: " + x + " " + y);
                }
            }
        }
    }
}
