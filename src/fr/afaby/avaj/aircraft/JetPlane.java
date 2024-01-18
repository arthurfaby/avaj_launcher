package fr.afaby.avaj.aircraft;

import fr.afaby.avaj.file.OutputLog;

/**
 * JetPlane class. This class extends Aircraft class.
 * @see Aircraft
 */
public class JetPlane extends Aircraft {

    /**
     * Constructor.
     * @param p_id          JetPlane id.
     * @param p_name        JetPlane name.
     * @param p_coordinate  JetPlane coordinates.
     */
    public JetPlane(long p_id, String p_name, Coordinates p_coordinate) {
        super(p_id, p_name, p_coordinate);
        this.type = "JetPlane";
    }

    /**
     * Update the jetplane coordinates according to the weather.
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
                this.coordinates.setLatitude(this.coordinates.getLatitude() + 10);
                this.coordinates.setHeight(this.coordinates.getHeight() + 2);
                this.checkHeight();
                break;
            case "RAIN":
                OutputLog.getInstance().log(this.getPrefix() + ": " + this.rainMessage);
                this.coordinates.setLatitude(this.coordinates.getLatitude() + 5);
                break;
            case "FOG":
                OutputLog.getInstance().log(this.getPrefix() + ": " + this.fogMessage);
                this.coordinates.setLatitude(this.coordinates.getLatitude() + 1);
                break;
            case "SNOW":
                OutputLog.getInstance().log(this.getPrefix() + ": " + this.snowMessage);
                this.coordinates.setHeight(this.coordinates.getHeight() - 7);
                this.checkHeight();
                break;
            default:
                OutputLog.getInstance().log(prefix + " Unknown weather type.");
                break;
        }
    }
}
