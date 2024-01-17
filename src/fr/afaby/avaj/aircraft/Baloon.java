package fr.afaby.avaj.aircraft;

import fr.afaby.avaj.file.OutputLog;

public class Baloon extends Aircraft {

    public Baloon(int p_id, String p_name, Coordinates p_coordinates) {
        super(p_id, p_name, p_coordinates, "Baloon");
    }

    @Override
    public void updateConditions() {
        if (this.weatherTower == null) {
            OutputLog.log("Error: no weather tower for " + this.getPrefix() + ".");
            return;
        }
        String weatherType = this.weatherTower.getWeather(this.coordinates);
        String prefix = this.getPrefix();
        switch (weatherType) {
            case "SUN":
                OutputLog.log(this.getPrefix() + ": " + this.sunMessage);
                this.coordinates.setLongitude(this.coordinates.getLongitude() + 2);
                this.coordinates.setHeight(this.coordinates.getHeight() + 4);
                this.checkHeight();
                break;
            case "RAIN":
                OutputLog.log(this.getPrefix() + ": " + this.rainMessage);
                this.coordinates.setHeight(this.coordinates.getHeight() - 5);
                this.checkHeight();
                break;
            case "FOG":
                OutputLog.log(this.getPrefix() + ": " + this.fogMessage);
                this.coordinates.setHeight(this.coordinates.getHeight() - 3);
                this.checkHeight();
                break;
            case "SNOW":
                OutputLog.log(this.getPrefix() + ": " + this.snowMessage);
                this.coordinates.setHeight(this.coordinates.getHeight() - 15);
                this.checkHeight();
                break;
            default:
                OutputLog.log(prefix + " Unknown weather type.");
                break;
        }
    }
}
