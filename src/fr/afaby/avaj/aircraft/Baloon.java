package fr.afaby.avaj.aircraft;

import fr.afaby.avaj.file.OutputLog;

/**
 * Baloon class. This class extends Aircraft class.
 * @see Aircraft
 */
public class Baloon extends Aircraft {

    /**
     * Constructor.
     * @param p_id          Baloon id.
     * @param p_name        Baloon name.
     * @param p_coordinate  Baloon coordinates.
     */
    public Baloon(long p_id, String p_name, Coordinates p_coordinate) {
        super(p_id, p_name, p_coordinate);
        this.type = "Baloon";
    }

    /**
     * Update the baloon coordinates according to the weather.
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
                this.coordinates.setLongitude(this.coordinates.getLongitude() + 2);
                this.coordinates.setHeight(this.coordinates.getHeight() + 4);
                this.checkHeight();
                break;
            case "RAIN":
                OutputLog.getInstance().log(this.getPrefix() + ": " + this.rainMessage);
                this.coordinates.setHeight(this.coordinates.getHeight() - 5);
                this.checkHeight();
                break;
            case "FOG":
                OutputLog.getInstance().log(this.getPrefix() + ": " + this.fogMessage);
                this.coordinates.setHeight(this.coordinates.getHeight() - 3);
                this.checkHeight();
                break;
            case "SNOW":
                OutputLog.getInstance().log(this.getPrefix() + ": " + this.snowMessage);
                this.coordinates.setHeight(this.coordinates.getHeight() - 15);
                this.checkHeight();
                break;
            default:
                OutputLog.getInstance().log(prefix + " Unknown weather type.");
                break;
        }
    }
}
