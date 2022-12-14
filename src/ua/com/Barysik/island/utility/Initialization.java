package ua.com.Barysik.island.utility;

import ua.com.Barysik.island.settings.Land;

import java.util.Scanner;

public class Initialization {

    public void start() {

        FillTable.startTable();

        System.out.println("Введите размер острова по горизонтали");
        int coordinateX = new Scanner(System.in).nextInt();

        System.out.println("Введите размер острова по вертикали");
        int coordinateY = new Scanner(System.in).nextInt();

        Land.newLand(coordinateX, coordinateY);

    }

}
