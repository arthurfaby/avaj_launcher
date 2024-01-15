package tower;

import java.util.ArrayList;
import java.util.List;

import aircraft.Flyable;

public class Tower {

    private List<Flyable> observers;

    public Tower() {
        this.observers = new ArrayList<>();
    }

    public void register(Flyable flyable) {
        if (this.observers.contains(flyable)) {
            return;
        }
        if (flyable == null) {
            return;
        }
        this.observers.add(flyable);
    }

    public void unregister(Flyable flyable) {
        this.observers.remove(flyable);
    }

    public void conditionsChanged() {
        for (Flyable flyable : this.observers) {
            flyable.updateConditions();
        }
    }

}
