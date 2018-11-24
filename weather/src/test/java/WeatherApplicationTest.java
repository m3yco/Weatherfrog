import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.io.File;

import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

import de.fh.albsig.milazzdo.model.Weather;
import de.fh.albsig.milazzdo.model.Weatherfrog;
import de.fh.albsig.milazzdo.weather.WeatherFormatter;
import de.fh.albsig.milazzdo.weather.XMLCreator;
import de.fh.albsig.milazzdo.exception.WeatherException;

@TestInstance(value = Lifecycle.PER_CLASS)
public class WeatherApplicationTest {
    private Weather mockedWeather;
    private Weather weather;

    @BeforeAll
    void setup() {
        this.weather = null;
        this.mockedWeather = null;
    }

    @BeforeEach
    void init() {
        this.mockedWeather = mock(Weather.class);
        this.weather = new Weatherfrog();
        when(this.mockedWeather.getCity()).thenReturn("Gotham");
        when(this.mockedWeather.getRegion()).thenReturn("DC Universe");
        when(this.mockedWeather.getCountry()).thenReturn("USA");
        when(this.mockedWeather.getCondition()).thenReturn("dark");
        when(this.mockedWeather.getHumidity()).thenReturn("0");
        when(this.mockedWeather.getTemp()).thenReturn("666");
        when(this.mockedWeather.getSpeed()).thenReturn("2.59");
        when(this.mockedWeather.getDirection()).thenReturn("W");
        when(this.mockedWeather.getChill()).thenReturn("12");
        when(this.mockedWeather.getVisibility()).thenReturn("30");
        when(this.mockedWeather.getSunrise()).thenReturn("1");
        when(this.mockedWeather.getSunset()).thenReturn("0");
        when(this.mockedWeather.getTimestamp()).thenReturn("0");
        this.weather.setCity(this.mockedWeather.getCity());
        this.weather.setRegion(this.mockedWeather.getRegion());
        this.weather.setCountry(this.mockedWeather.getCountry());
        this.weather.setCondition(this.mockedWeather.getCondition());
        this.weather.setHumidity(this.mockedWeather.getHumidity());
        this.weather.setTemp(this.mockedWeather.getTemp());
        this.weather.setDirection("270");
        this.weather.setSpeed("161");
        this.weather.setChill(this.mockedWeather.getChill());
        this.weather.setVisibility(this.mockedWeather.getVisibility());
        this.weather.setSunrise(this.mockedWeather.getSunrise());
        this.weather.setSunset(this.mockedWeather.getSunset());
        this.weather.setTimestamp(this.mockedWeather.getTimestamp());
    }

    @Test
    void objectTest() {
        assertTrue(StringUtils.contains(this.weather.getCity(),
                this.mockedWeather.getCity()));
        assertTrue(StringUtils.contains(this.weather.getRegion(),
                this.mockedWeather.getRegion()));
        assertTrue(StringUtils.contains(this.weather.getCountry(),
                this.mockedWeather.getCountry()));
        assertTrue(StringUtils.contains(this.weather.getCondition(),
                this.mockedWeather.getCondition()));
        assertTrue(StringUtils.contains(this.weather.getHumidity(),
                this.mockedWeather.getHumidity()));
        assertTrue(StringUtils.contains(this.weather.getTemp(),
                this.mockedWeather.getTemp()));
        assertTrue(StringUtils.contains(this.weather.getDirection(),
                this.mockedWeather.getDirection()));
        assertTrue(StringUtils.contains(this.weather.getSpeed(),
                this.mockedWeather.getSpeed()));
    }

    @Test
    void formatterTest() throws WeatherException {
        String path = "output.vm";
        assertTrue(StringUtils.isNotBlank(path));
        String testContext = new WeatherFormatter().format(this.mockedWeather,
                path);
        assertNotNull(testContext);
    }

    @Test
    void xmlTest() throws WeatherException {
        String path = "src/test/resources/testXML.xml";
        XMLCreator xml = new XMLCreator();
        xml.toXML(this.weather, path);
        assertNotNull(xml);
    }

    @AfterEach
    void cleanEach() {
        this.weather = null;
        this.mockedWeather = null;
    }

    @AfterAll
    void cleanUp() {
        File file = new File(
                "src/test/resources/testXML.xml");
        file.delete();
    }
}