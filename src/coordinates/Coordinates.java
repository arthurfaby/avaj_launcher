package coordinates;

public class Coordinates {

    /**
     * The longitude coordinate
     */
    private int longitude;

    /**
     * The latitude coordinate
     */
    private int latitude;

    /**
     * The height coordinate
     */
    private int height;

    /**
     * Constructor
     * 
     * @param p_longitude
     * @param p_latitude
     * @param p_height
     */
    public Coordinates(int p_longitude, int p_latitude, int p_height) {
        this.longitude = p_longitude;
        this.latitude = p_latitude;
        this.height = p_height;
    }

    /**
     * Getter for longitude
     * 
     * @return longitude
     */
    public int getLongitude() {
        return this.longitude;
    }

    /**
     * Getter for latitude
     * 
     * @return latitude
     */
    public int getLatitude() {
        return this.latitude;
    }

    /**
     * Getter for height
     * 
     * @return height
     */
    public int getHeight() {
        return this.height;
    }

    /**
     * Setter for longitude
     * 
     * @param p_longitude
     */
    public void setLongitude(int p_longitude) {
        this.longitude = p_longitude;
        if (this.longitude < 0) {
            // TODO : throw exception
            this.longitude = 0;
        }
    }

    /**
     * Setter for latitude
     * 
     * @param p_latitude
     */
    public void setLatitude(int p_latitude) {
        this.latitude = p_latitude;
        if (this.latitude < 0) {
            // TODO : throw exception
            this.latitude = 0;
        }
    }

    /**
     * Setter for height
     * 
     * @param p_height
     */
    public void setHeight(int p_height) {
        this.height = p_height;
        if (this.height > 100) {
            this.height = 100;
        } else if (this.height < 0) {
            this.height = 0;
        }
    }
}
