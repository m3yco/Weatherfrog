import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

import de.fh.albsig.milazzdo.model.Weather;
import de.fh.albsig.milazzdo.model.Weatherfrog;

@TestInstance(value = Lifecycle.PER_CLASS)
public class ConverterSpeedTest {
    private Weather mockedWeather;
    private Weather weather;

    @BeforeAll
    void setup() {
        this.weather = null;
        this.mockedWeather = null;
    }

    @BeforeEach
    void init() {
        this.mockedWeather = mock(Weatherfrog.class);
        when(this.mockedWeather.getSpeed()).thenReturn("2.0");
        this.weather = new Weatherfrog();
        this.weather.setSpeed("1");
    }

    @Test
    void speedTest() {
        assertTrue(StringUtils.contains(this.weather.getSpeed(), this.mockedWeather.getSpeed()));
    }

    @AfterAll
    void cleanUp() {
        this.weather = null;
        this.mockedWeather = null;
    }
}
