package fr.afaby.avaj.aircraft;

import fr.afaby.avaj.file.OutputLog;

public class JetPlane extends Aircraft {

    public JetPlane(int p_id, String p_name, Coordinates p_coordinates) {
        super(p_id, p_name, p_coordinates, "JetPlane");
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
                this.coordinates.setLatitude(this.coordinates.getLatitude() + 10);
                this.coordinates.setHeight(this.coordinates.getHeight() + 2);
                this.checkHeight();
                break;
            case "RAIN":
                OutputLog.log(this.getPrefix() + ": " + this.rainMessage);
                this.coordinates.setLatitude(this.coordinates.getLatitude() + 5);
                break;
            case "FOG":
                OutputLog.log(this.getPrefix() + ": " + this.fogMessage);
                this.coordinates.setLatitude(this.coordinates.getLatitude() + 1);
                break;
            case "SNOW":
                OutputLog.log(this.getPrefix() + ": " + this.snowMessage);
                this.coordinates.setHeight(this.coordinates.getHeight() - 7);
                this.checkHeight();
                break;
            default:
                OutputLog.log(prefix + " Unknown weather type.");
                break;
        }
    }
}
