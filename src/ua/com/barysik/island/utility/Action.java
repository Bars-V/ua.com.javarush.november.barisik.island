package ua.com.barysik.island.utility;

import ua.com.barysik.island.baseClases.Alive;

import java.util.ArrayList;
import java.util.HashSet;

public class Action {

    private ArrayList receiveAlive(int x, int y){
        HashSet<Alive> cellHashSet = Initialization.land.getCellHashSet(x,y);
        ArrayList<Alive> alives = new ArrayList<>();
        for (Alive alive: cellHashSet) {
            alives.add(alive);
        }
        return alives;
    }

    public void find(ArrayList alives){
        // извлекаем попарно
    }

    private void isEat(){
        //кто кого ест и ест ли вообще
    }

    private void hungery(Animal animal){
        animal.hunger();
    }


}
