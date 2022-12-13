package ua.com.Barysik.island.settings;

import java.util.HashMap;

public class EatTable {

    private static HashMap<String, HashMap<String, Integer>> eatTable = new HashMap<>();

    public static Integer getEatTable(String hunterClassName, String preyClassName) {
        if (eatTable.get(hunterClassName) == null) {
            return 0;
        } else if(eatTable.get(hunterClassName).get(preyClassName) == null){
            return 0;
        }
        return eatTable.get(hunterClassName).get(preyClassName);
    }

    public static void setEatTable(String hunterClassName, String preyClassName, Integer chance) {
        HashMap<String, Integer> eatMap = new HashMap<>();
        if (eatTable.containsKey(hunterClassName)) {
            eatMap = eatTable.get(hunterClassName);
        }
//            System.out.println("Для " + hunterClassName + " добавлена добыча " + preyClassName + " с вероятностью быть пойманной: " + chance);
//        } else {
//            System.out.println("Создан охотник " + hunterClassName + "\nДля " + hunterClassName + " добавлена добыча " + preyClassName + " с вероятностью быть пойманной: " + chance);
//        }
        eatMap.put(preyClassName, chance);
        eatTable.put(hunterClassName, eatMap);
    }
}
