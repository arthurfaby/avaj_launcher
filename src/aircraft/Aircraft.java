package aircraft;

import coordinates.Coordinates;
import file.OutputLog;

public class Aircraft extends Flyable {

    protected long id;
    protected String name;
    protected Coordinates coordinates;
    protected String type;

    private static int nbOfAircrafts = 0;

    protected Aircraft(String p_name, Coordinates p_coordinates, String p_type) {
        Aircraft.nbOfAircrafts++;
        this.id = Aircraft.nbOfAircrafts;
        this.name = p_name;
        this.coordinates = p_coordinates;
        this.type = p_type;
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
                this.updateSunnyConditions();
                break;
            case "RAIN":
                this.updateRainyConditions();
                break;
            case "FOG":
                this.updateFoggyConditions();
                break;
            case "SNOW":
                this.updateSnowyConditions();
                break;
            default:
                OutputLog.log(prefix + "Unknown weather type.");
                break;
        }
    }

    public String getPrefix() {
        return this.type + "#" + this.name + "(" + this.id + ")";
    }

    protected void updateSunnyConditions() {
        throw new UnsupportedOperationException("Should not be called.");
    }

    protected void updateRainyConditions() {
        throw new UnsupportedOperationException("Should not be called.");
    }

    protected void updateFoggyConditions() {
        throw new UnsupportedOperationException("Should not be called.");
    }

    protected void updateSnowyConditions() {
        throw new UnsupportedOperationException("Should not be called.");
    }
}
