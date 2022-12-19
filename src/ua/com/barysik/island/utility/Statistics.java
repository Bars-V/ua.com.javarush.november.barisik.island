package ua.com.barysik.island.utility;

import ua.com.barysik.island.baseClases.Alive;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

public class Statistics extends Thread {
    @Override
    public void run(){

        Integer x = Initialization.land.getX();
        Integer y = Initialization.land.getY();

        while (true) {

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            HashMap<String, Long> statistics = new HashMap<>();
            Collection<ArrayList<Alive>> all = Initialization.land.getAll();
            for (ArrayList<Alive> list : all) {
                ArrayList<Alive> list1 = new ArrayList<>();
                list1 = (ArrayList<Alive>) list.clone();

                for (Alive alive : list1) {
                    System.out.println(list1.size());
                    String name = alive.getName();
                    if(alive == null){
                        System.out.println("null");
                        continue;
                    }
                    if (statistics.containsKey(name)) {
                        Long i = statistics.get(name) + 1;
                        statistics.put(name, i);
                    } else {
                        statistics.put(name, 1L);
                    }
                }
            }
            System.out.println(statistics);
        }
    }
}


