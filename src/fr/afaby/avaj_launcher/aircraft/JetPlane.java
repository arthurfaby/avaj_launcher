package fr.afaby.avaj_launcher.aircraft;

import fr.afaby.avaj_launcher.file.OutputLog;

public class JetPlane extends Aircraft {

    public JetPlane(String p_name, Coordinates p_coordinates) {
        super(p_name, p_coordinates, "JetPlane");
    }

    @Override
    protected void updateSunnyConditions() {
        OutputLog.log(this.getPrefix() + ": Sun.");
        this.coordinates.setLatitude(this.coordinates.getLatitude() + 10);
        this.coordinates.setHeight(this.coordinates.getHeight() + 2);
        this.checkHeight();
    }

    @Override
    protected void updateRainyConditions() {
        OutputLog.log(this.getPrefix() + ": Rain.");
        this.coordinates.setLatitude(this.coordinates.getLatitude() + 5);
    }

    @Override
    protected void updateFoggyConditions() {
        OutputLog.log(this.getPrefix() + ": Fog.");
        this.coordinates.setLatitude(this.coordinates.getLatitude() + 1);
    }

    @Override
    protected void updateSnowyConditions() {
        OutputLog.log(this.getPrefix() + ": Snow.");
        this.coordinates.setHeight(this.coordinates.getHeight() - 7);
        this.checkHeight();
    }

}
