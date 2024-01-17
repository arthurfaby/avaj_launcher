package fr.afaby.avaj_launcher.aircraft;

import fr.afaby.avaj_launcher.file.OutputLog;

public class Baloon extends Aircraft {

    public Baloon(String p_name, Coordinates p_coordinates) {
        super(p_name, p_coordinates, "Baloon");
    }

    protected void updateSunnyConditions() {
        OutputLog.log(this.getPrefix() + ": Sun.");
        this.coordinates.setLongitude(this.coordinates.getLongitude() + 2);
        this.coordinates.setHeight(this.coordinates.getHeight() + 4);
        this.checkHeight();
    }

    @Override
    protected void updateRainyConditions() {
        OutputLog.log(this.getPrefix() + ": Rain.");
        this.coordinates.setHeight(this.coordinates.getHeight() - 5);
        this.checkHeight();
    }

    @Override
    protected void updateFoggyConditions() {
        OutputLog.log(this.getPrefix() + ": Fog.");
        this.coordinates.setHeight(this.coordinates.getHeight() - 3);
        this.checkHeight();
    }

    @Override
    protected void updateSnowyConditions() {
        OutputLog.log(this.getPrefix() + ": Snow.");
        this.coordinates.setHeight(this.coordinates.getHeight() - 15);
        this.checkHeight();
    }


}
