package aircraft;

import coordinates.Coordinates;
import file.OutputLog;

public class Helicopter extends Aircraft {

    public Helicopter(String p_name, Coordinates p_coordinates) {
        super(p_name, p_coordinates, "Helicopter");
    }

    @Override
    protected void updateSunnyConditions() {
        this.coordinates.setLongitude(this.coordinates.getLongitude() + 10);
        this.coordinates.setHeight(this.coordinates.getHeight() + 2);
        OutputLog.log(this.getPrefix() + ": Sun.");
    }

    @Override
    protected void updateRainyConditions() {
        this.coordinates.setLongitude(this.coordinates.getLongitude() + 5);
        OutputLog.log(this.getPrefix() + ": Rain.");
    }

    @Override
    protected void updateFoggyConditions() {
        this.coordinates.setLongitude(this.coordinates.getLongitude() + 1);
        OutputLog.log(this.getPrefix() + ": Fog.");
    }

    @Override
    protected void updateSnowyConditions() {
        this.coordinates.setHeight(this.coordinates.getHeight() - 12);
        OutputLog.log(this.getPrefix() + ": Snow.");
    }

}
