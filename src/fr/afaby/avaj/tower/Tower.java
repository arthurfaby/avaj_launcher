package fr.afaby.avaj.tower;

import java.util.ArrayList;
import java.util.List;

import fr.afaby.avaj.aircraft.Flyable;
import fr.afaby.avaj.file.OutputLog;

public class Tower {

    private final List<Flyable> observers;

    public Tower() {
        this.observers = new ArrayList<>();
    }

    /**
     * List of flyables to delete from tower after a simulation
     */
    public static List<Flyable> flyablesToDeleteFromTower = new ArrayList<>();

    public void register(Flyable flyable) {
        if (this.observers.contains(flyable)) {
            return;
        }
        if (flyable == null) {
            return;
        }
        this.observers.add(flyable);
        OutputLog.log("Tower says: " + flyable.getPrefix() + " registered to weather tower.");
    }

    public void unregister(Flyable flyable) {
        Tower.flyablesToDeleteFromTower.add(flyable);
        OutputLog.log("Tower says: " + flyable.getPrefix() + " unregistered to weather tower.");
    }

    public void conditionsChanged() {
        for (Flyable flyable : this.observers) {
            flyable.updateConditions();
        }
        for (Flyable flyable : flyablesToDeleteFromTower) {
            this.observers.remove(flyable);
        }
        flyablesToDeleteFromTower.clear();
    }

}
