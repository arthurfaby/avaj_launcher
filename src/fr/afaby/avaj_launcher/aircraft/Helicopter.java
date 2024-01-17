package fr.afaby.avaj_launcher.aircraft;

import fr.afaby.avaj_launcher.file.OutputLog;

public class Helicopter extends Aircraft {

    public Helicopter(String p_name, Coordinates p_coordinates) {
        super(p_name, p_coordinates, "Helicopter");
    }



    @Override
    protected void updateSunnyConditions() {
        OutputLog.log(this.getPrefix() + ": Sun.");
        this.coordinates.setLongitude(this.coordinates.getLongitude() + 10);
        this.coordinates.setHeight(this.coordinates.getHeight() + 2);
        this.checkHeight();
    }

    @Override
    protected void updateRainyConditions() {
        OutputLog.log(this.getPrefix() + ": Rain.");
        this.coordinates.setLongitude(this.coordinates.getLongitude() + 5);
    }

    @Override
    protected void updateFoggyConditions() {
        OutputLog.log(this.getPrefix() + ": Fog.");
        this.coordinates.setLongitude(this.coordinates.getLongitude() + 1);
    }

    @Override
    protected void updateSnowyConditions() {
        OutputLog.log(this.getPrefix() + ": Snow.");
        this.coordinates.setHeight(this.coordinates.getHeight() - 12);
        this.checkHeight();
    }

}
