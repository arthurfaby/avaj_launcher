package aircraft;

import coordinates.Coordinates;
import file.OutputLog;

public class JetPlane extends Aircraft {

    public JetPlane(String p_name, Coordinates p_coordinates) {
        super(p_name, p_coordinates, "JetPlane");
    }

    @Override
    protected void updateSunnyConditions() {
        this.coordinates.setLatitude(this.coordinates.getLatitude() + 10);
        this.coordinates.setHeight(this.coordinates.getHeight() + 2);
        OutputLog.log(this.getPrefix() + ": Sun.");
    }

    @Override
    protected void updateRainyConditions() {
        this.coordinates.setLatitude(this.coordinates.getLatitude() + 5);
        OutputLog.log(this.getPrefix() + ": Rain.");
    }

    @Override
    protected void updateFoggyConditions() {
        this.coordinates.setLatitude(this.coordinates.getLatitude() + 1);
        OutputLog.log(this.getPrefix() + ": Fog.");
    }

    @Override
    protected void updateSnowyConditions() {
        this.coordinates.setHeight(this.coordinates.getHeight() - 7);
        OutputLog.log(this.getPrefix() + ": Snow.");
    }

}
