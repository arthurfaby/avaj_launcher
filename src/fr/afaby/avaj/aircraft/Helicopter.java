package fr.afaby.avaj.aircraft;

import fr.afaby.avaj.file.OutputLog;

/**
 * Helicopter class. This class extends Aircraft class.
 * @see Aircraft
 */
public class Helicopter extends Aircraft {

    /**
     * Constructor.
     * @param p_id          Helicopter id.
     * @param p_name        Helicopter name.
     * @param p_coordinate  Helicopter coordinates.
     */
    public Helicopter(long p_id, String p_name, Coordinates p_coordinate) {
        super(p_id, p_name, p_coordinate);
        this.type = "Helicopter";
    }

    /**
     * Update the helicopter coordinates according to the weather.
     */
    @Override
    public void updateConditions() {
        if (this.weatherTower == null) {
            OutputLog.getInstance().log("Error: no weather tower for " + this.getPrefix() + ".");
            return;
        }
        String weatherType = this.weatherTower.getWeather(this.coordinates);
        String prefix = this.getPrefix();
        switch (weatherType) {
            case "SUN":
                OutputLog.getInstance().log(this.getPrefix() + ": " + this.sunMessage);
                this.coordinates.setLongitude(this.coordinates.getLongitude() + 10);
                this.coordinates.setHeight(this.coordinates.getHeight() + 2);
                this.checkHeight();
                break;
            case "RAIN":
                OutputLog.getInstance().log(this.getPrefix() + ": " + this.rainMessage);
                this.coordinates.setLongitude(this.coordinates.getLongitude() + 5);
                break;
            case "FOG":
                OutputLog.getInstance().log(this.getPrefix() + ": " + this.fogMessage);
                this.coordinates.setLongitude(this.coordinates.getLongitude() + 1);
                break;
            case "SNOW":
                OutputLog.getInstance().log(this.getPrefix() + ": " + this.snowMessage);
                this.coordinates.setHeight(this.coordinates.getHeight() - 12);
                this.checkHeight();
                break;
            default:
                OutputLog.getInstance().log(prefix + " Unknown weather type.");
                break;
        }
    }
}
