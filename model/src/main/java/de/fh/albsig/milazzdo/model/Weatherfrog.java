package de.fh.albsig.milazzdo.model;

import java.text.DecimalFormat;

/**
 * @author milazzdo
 *
 */
public class Weatherfrog implements Weather {
    /**
     * City Name of the location.
     */
    private String city;

    /**
     * Region of the city location.
     */
    private String region;

    /**
     * Country of the city location.
     */
    private String country;

    /**
     * Condition of the weather.
     */
    private String condition;

    /**
     * Value of the temperature.
     */
    private String temp;

    /**
     * Temperature of the wind.
     */
    private String chill;

    /**
     * Wind direction.
     */
    private String direction;

    /**
     * Wind speed.
     */
    private String speed;

    /**
     * Wind humidity.
     */
    private String humidity;

    /**
     * Visibility in kilometer.
     */
    private String visibility;

    /**
     * Time of sunrise.
     */
    private String sunrise;

    /**
     * Time of sunset.
     */
    private String sunset;

    /**
     * Time stamp of the data.
     */
    private String timestamp;

    /**
     * Weather default constructor.
     */
    public Weatherfrog() {
    }

    /**
     * @return attribute city.
     */
    @Override
    public final String getCity() {
        return city;
    }

    /**
     * @param inputCity
     *            set attribute.
     */
    @Override
    public final void setCity(final String inputCity) {
        this.city = inputCity;
    }

    /**
     * @return attribute region.
     */
    @Override
    public final String getRegion() {
        return region;
    }

    /**
     * @param inputRegion
     *            set attribute.
     */
    @Override
    public final void setRegion(final String inputRegion) {
        this.region = inputRegion;
    }

    /**
     * @return attribute country.
     */
    @Override
    public final String getCountry() {
        return country;
    }

    /**
     * @param inputCountry
     *            set attribute.
     */
    @Override
    public final void setCountry(final String inputCountry) {
        this.country = inputCountry;
    }

    /**
     * @return attribute condition.
     */
    @Override
    public final String getCondition() {
        return condition;
    }

    /**
     * @param inputCondition
     *            set attribute.
     */
    @Override
    public final void setCondition(final String inputCondition) {
        this.condition = inputCondition;
    }

    /**
     * @return attribute temperature.
     */
    @Override
    public final String getTemp() {
        return temp;
    }

    /**
     * @param inputTemp
     *            set attribute.
     */
    @Override
    public final void setTemp(final String inputTemp) {
        this.temp = inputTemp;
    }

    /**
     * @return attribute chill.
     */
    @Override
    public String getChill() {
        return chill;
    }

    /**
     * @param inputChill
     *            convert fahrenheit to celsius.
     */
    @Override
    public final void setChill(final String inputChill) {
        double celsius = Double.parseDouble(inputChill);
        final double parameterDegree = 32;
        final double parameterQuotient = 1.8;
        celsius = (celsius - parameterDegree) / parameterQuotient;
        celsius = Double
                .parseDouble(new DecimalFormat("###,##").format(celsius));
        this.chill = Double.toString(celsius);
    }

    /**
     * @return attribute direction.
     */
    @Override
    public String getDirection() {
        return direction;
    }

    /**
     * @param inputDirection
     *            convert degree to compass direction.
     */
    @Override
    public final void setDirection(final String inputDirection) {
        final double degree = Double.parseDouble(inputDirection);
        final String[] compass = { "N", "NE", "E", "SE", "S", "SW", "W", "NW",
                "N" };
        final int circle = 360;
        final int qartitionCircle = 45;
        this.direction = compass[(int) Math
                .round((degree % circle) / qartitionCircle)];
    }

    /**
     * @return attribute speed.
     */
    @Override
    public String getSpeed() {
        return speed;
    }

    /**
     * @param inputSpeed
     *            convert m/h to km/h.
     */
    @Override
    public final void setSpeed(final String inputSpeed) {
        double haste = Double.parseDouble(inputSpeed);
        final double parameterMilesQuotient = 1.61;
        haste = haste * parameterMilesQuotient;
        haste = Double.parseDouble(new DecimalFormat("###,##").format(haste));
        this.speed = Double.toString(haste);
    }

    /**
     * @return attribute humidity.
     */
    @Override
    public final String getHumidity() {
        return humidity;
    }

    /**
     * @param inputHumidity
     *            set attribute.
     */
    @Override
    public final void setHumidity(final String inputHumidity) {
        this.humidity = inputHumidity;
    }

    /**
     * @return attribute visibility.
     */
    @Override
    public final String getVisibility() {
        return visibility;
    }

    /**
     * @param inputVisibility
     *            convert miles to kilometer
     */
    @Override
    public final void setVisibility(final String inputVisibility) {
        final double view = Double.parseDouble(inputVisibility);
        final double parameterQuotientMiles = 1.61;
        final double countView = view * parameterQuotientMiles;
        final double returnView = Double
                .parseDouble(new DecimalFormat("####,##").format(countView));
        this.visibility = Double.toString(returnView);
    }

    /**
     * @return attribute sunrise.
     */
    @Override
    public final String getSunrise() {
        return sunrise;
    }

    /**
     * @param inputSunrise
     *            set attribute.
     */
    @Override
    public final void setSunrise(final String inputSunrise) {
        this.sunrise = inputSunrise;
    }

    /**
     * @return attribute sunset.
     */
    @Override
    public final String getSunset() {
        return sunset;
    }

    /**
     * @param inputSunset
     *            set attribute.
     */
    @Override
    public final void setSunset(final String inputSunset) {
        this.sunset = inputSunset;
    }

    /**
     * @return attribute time.
     */
    @Override
    public final String getTimestamp() {
        return timestamp;
    }

    /**
     * @param inpitTimestamp
     *            set attribute.
     */
    @Override
    public void setTimestamp(final String inpitTimestamp) {
        this.timestamp = inpitTimestamp;
    }

}
