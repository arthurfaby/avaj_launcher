package fr.afaby.avaj.tower;

import java.util.ArrayList;
import java.util.List;

import fr.afaby.avaj.aircraft.Flyable;
import fr.afaby.avaj.file.OutputLog;

/**
 * Tower class
 */
public class Tower {

    /**
     * List of flyables
     */
    private final List<Flyable> observers;

    /**
     * Constructor.
     */
    public Tower() {
        this.observers = new ArrayList<>();
    }

    /**
     * List of flyables to delete from tower after a simulation
     */
    public static List<Flyable> flyablesToDeleteFromTower = new ArrayList<>();

    /**
     * Register a flyable to the tower.
     * @param p_flyable Flyable to register.
     */
    public void register(Flyable p_flyable) {
        if (this.observers.contains(p_flyable)) {
            return;
        }
        if (p_flyable == null) {
            return;
        }
        this.observers.add(p_flyable);
        OutputLog.getInstance().log("Tower says: " + p_flyable.getPrefix() + " registered to weather tower.");
    }

    /**
     * Unregister a flyable from the tower.
     * @param p_flyable Flyable to unregister.
     */
    public void unregister(Flyable p_flyable) {
        Tower.flyablesToDeleteFromTower.add(p_flyable);
        OutputLog.getInstance().log("Tower says: " + p_flyable.getPrefix() + " unregistered to weather tower.");
    }

    /**
     * Notify the flyables that the weather has changed.
     * Delete the flyables that have landed.
     */
    protected void conditionChanged() {
        for (Flyable flyable : this.observers) {
            flyable.updateConditions();
        }
        for (Flyable flyable : flyablesToDeleteFromTower) {
            this.observers.remove(flyable);
        }
        flyablesToDeleteFromTower.clear();
    }

}
