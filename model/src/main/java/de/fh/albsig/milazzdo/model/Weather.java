package de.fh.albsig.milazzdo.model;

/**
 * @author milazzdo
 *
 */
public interface Weather {
    /**
    * @return attribute city.
    */
    String getCity();
    /**
     * @param inputCity
     *            set attribute.
     */
    void setCity(final String inputCity);
    /**
     * @return attribute region.
     */
    String getRegion();
    /**
     * @param inputRegion
     *            set attribute.
     */
    void setRegion(final String inputRegion);
    /**
     * @return attribute country.
     */
    String getCountry();

    /**
     * @param inputCountry
     *            set attribute.
     */
    void setCountry(final String inputCountry);

    /**
     * @return attribute condition.
     */
    String getCondition();

    /**
     * @param inputCondition
     *            set attribute.
     */
    void setCondition(final String inputCondition);

    /**
     * @return attribute temperature.
     */
    String getTemp();

    /**
     * @param inputTemp
     *            set attribute.
     */
    void setTemp(final String inputTemp);

    /**
     * @return attribute chill.
     */
    String getChill();

    /**
     * @param inputChill
     *            convert fahrenheit to celsius.
     */
    void setChill(final String inputChill);

    /**
     * @return attribute direction.
     */
    String getDirection();

    /**
     * @param inputDirection
     *            convert degree to compass direction.
     */
    void setDirection(final String inputDirection);

    /**
     * @return attribute speed.
     */
    String getSpeed();

    /**
     * @param inputSpeed
     *            convert m/h to km/h.
     */
    void setSpeed(final String inputSpeed);

    /**
     * @return attribute humidity.
     */
    String getHumidity();

    /**
     * @param inputHumidity
     *            set attribute.
     */
    void setHumidity(final String inputHumidity);

    /**
     * @return attribute visibility.
     */
    String getVisibility();

    /**
     * @param inputVisibility
     *            convert miles to kilometer
     */
    void setVisibility(final String inputVisibility);

    /**
     * @return attribute sunrise.
     */
    String getSunrise();

    /**
     * @param inputSunrise
     *            set attribute.
     */
    void setSunrise(final String inputSunrise);

    /**
     * @return attribute sunset.
     */
    String getSunset();

    /**
     * @param inputSunset
     *            set attribute.
     */
    void setSunset(final String inputSunset);

    /**
     * @return attribute time.
     */
    String getTimestamp();

    /**
     * @param inpitTimestamp
     *            set attribute.
     */
    void setTimestamp(final String inpitTimestamp);

}
