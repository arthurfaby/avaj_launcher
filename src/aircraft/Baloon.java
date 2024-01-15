package aircraft;

import coordinates.Coordinates;
import file.OutputLog;

public class Baloon extends Aircraft {

    public Baloon(String p_name, Coordinates p_coordinates) {
        super(p_name, p_coordinates, "Baloon");
    }

    protected void updateSunnyConditions() {
        this.coordinates.setLongitude(this.coordinates.getLongitude() + 2);
        this.coordinates.setHeight(this.coordinates.getHeight() + 4);
        OutputLog.log(this.getPrefix() + ": Sun.");
    }

    @Override
    protected void updateRainyConditions() {
        this.coordinates.setHeight(this.coordinates.getHeight() - 5);
        OutputLog.log(this.getPrefix() + ": Rain.");
    }

    @Override
    protected void updateFoggyConditions() {
        this.coordinates.setHeight(this.coordinates.getHeight() - 3);
        OutputLog.log(this.getPrefix() + ": Fog.");
    }

    @Override
    protected void updateSnowyConditions() {
        this.coordinates.setHeight(this.coordinates.getHeight() - 15);
        OutputLog.log(this.getPrefix() + ": Snow.");
    }

}
