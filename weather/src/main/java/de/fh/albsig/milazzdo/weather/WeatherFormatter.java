package de.fh.albsig.milazzdo.weather;

import java.io.InputStreamReader;
import java.io.Reader;
import java.io.StringWriter;

import org.apache.log4j.Logger;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.Velocity;

import de.fh.albsig.milazzdo.exception.WeatherException;
import de.fh.albsig.milazzdo.model.Weather;

/**
 * @author milazzdo
 *
 */
public class WeatherFormatter {
    /**
     * Logger for error documentation.
     */
    private static Logger log = Logger.getLogger(WeatherFormatter.class);

    /**
     * @param weather
     *            value object.
     * @param output
     *            which kind of handling xml or html.
     * @return String for the stream.
     */

    public String format(final Weather weather, final String output)
            throws WeatherException {
        Reader reader;
        VelocityContext context;
        StringWriter writer;

        log.info("Formatting Weather Data");
        writer = new StringWriter();
        try {
            reader = new InputStreamReader(
                    getClass().getClassLoader().getResourceAsStream(output),
                    "UTF-8");
            context = new VelocityContext();
            context.put("weather", weather);
            Velocity.evaluate(context, writer, "", reader);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw new WeatherException(e.getMessage(), e);
        }
        return writer.toString();
    }
}
