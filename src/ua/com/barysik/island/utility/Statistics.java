package ua.com.barysik.island.utility;

import ua.com.barysik.island.entities.Alive;

import java.util.Collection;
import java.util.HashMap;
import java.util.concurrent.CopyOnWriteArrayList;

public class Statistics extends Thread {

    @Override
    public void run(){

        while (true) {

            HashMap<String, Long> statistics = new HashMap<>();

            Collection<CopyOnWriteArrayList<Alive>> list = Initialization.island.getAll();

            for (CopyOnWriteArrayList<Alive> alivesList : list) {
                for (Alive alive : alivesList) {
                    String name = alive.getName();
                    if (statistics.containsKey(name)) {
                        Long i = statistics.get(name) + 1;
                        statistics.put(name, i);
                    } else {
                        statistics.put(name, 1L);
                    }
                }
            }
            System.out.println(statistics);

            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }
}


