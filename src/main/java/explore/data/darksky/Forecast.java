package explore.data.darksky;

public class Forecast {
    private float latitude;
    private float longitude;
    private String timezone;
    private int offset;
    private Data currently;
    private Details hourly;

    public float getLatitude() {
        return latitude;
    }

    public void setLatitude(float latitude) {
        this.latitude = latitude;
    }
    public float getLongitude() {
        return longitude;
    }

    public void setLongitude(float longitude) {
        this.longitude = longitude;
    }

    public String getTimezone() {
        return timezone;
    }

    public void setTimezone(String timezone) {
        this.timezone = timezone;
    }

    public int getOffset() {
        return offset;
    }

    public void setOffset(int offset) {
        this.offset = offset;
    }

    public Data getCurrently() {
        return currently;
    }

    public void setCurrently(Data currently) {
        this.currently = currently;
    }

    public Details getHourly() {
        return hourly;
    }

    public void setHourly(Details hourly) {
        this.hourly = hourly;
    }
}
