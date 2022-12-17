package ua.com.barysik.island.utility;

import ua.com.barysik.island.animals.Caterpillar;
import ua.com.barysik.island.animals.Duck;
import ua.com.barysik.island.animals.Horse;
import ua.com.barysik.island.animals.Wolf;
import ua.com.barysik.island.baseClases.Plant;
import ua.com.barysik.island.settings.Constants;
import ua.com.barysik.island.settings.Land;
import ua.com.barysik.island.settings.Parameters;

import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class Initialization {

    public void start() {

        FillTable.startTable();

        System.out.println("Введите размер острова по горизонтали");
        int coordinateX = new Scanner(System.in).nextInt();

        System.out.println("Введите размер острова по вертикали");
        int coordinateY = new Scanner(System.in).nextInt();

//        Land.newLand(coordinateX, coordinateY);
//        Land.newLand(10, 10);

//        заполнение ячеек животными

        for (int i = 0; i < coordinateX; i++) {
            for (int j = 0; j < coordinateY; j++) {
                insetAnimal(i, j);
                System.out.println(cellcalc);
            }
        }


    }

    private static int cellcalc = 0;

    private void insetAnimal(int x, int y) {

        int w = ThreadLocalRandom.current().nextInt(Parameters.getParameter(Constants.amount, Wolf.class.getSimpleName()));
        int h = ThreadLocalRandom.current().nextInt(Parameters.getParameter(Constants.amount, Horse.class.getSimpleName()));
        int d = ThreadLocalRandom.current().nextInt(Parameters.getParameter(Constants.amount, Duck.class.getSimpleName()));
        int c = ThreadLocalRandom.current().nextInt(Parameters.getParameter(Constants.amount, Caterpillar.class.getSimpleName()));
        int p = ThreadLocalRandom.current().nextInt(Parameters.getParameter(Constants.amount, Plant.class.getSimpleName()));

        for (int i = 0; i < w / 2; i++) {
            Land.add(x, y, new Wolf());
        }
        for (int i = 0; i < h / 2; i++) {
            Land.add(x, y, new Horse());
        }
        for (int i = 0; i < d / 2; i++) {
            Land.add(x, y, new Duck());
        }
        for (int i = 0; i < c / 2; i++) {
            Land.add(x, y, new Caterpillar());
        }
        for (int i = 0; i < p / 2; i++) {
            Land.add(x, y, new Plant());
        }
        cellcalc++;
    }

}
