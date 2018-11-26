package de.fh.albsig.milazzdo.service;

import java.io.IOException;
import java.io.InputStream;
import java.net.URISyntaxException;

import org.apache.log4j.Logger;

import de.fh.albsig.milazzdo.model.Weatherfrog;

/**
 * @author milazzdo
 *
 */
public class WeatherService {
    /**
     * Logger for error documentation.
     */
    private static Logger log = Logger.getLogger(WeatherService.class);

    /**
     * default constructor.
     */
    public WeatherService() {
    }

    /**
     * @param city
     *            input for the location.
     * @return the response context.
     * @throws Exception
     *             default.
     */
    public String start(final String city) throws Exception {
        final String path = "src/main/resources/output.xml";
        InputStream dataIn;
        String context = null;
        try {
            log.info("Start Weather Service");
            dataIn = new WeatherRetriever().retrieve(city);
            Weatherfrog weather = new WeatherParser().parse(dataIn);
            XMLCreator xml = new XMLCreator();
            xml.toXML(weather, path);
            final String indexOutput = "index.vm";
            context = new WeatherFormatter().format(weather, indexOutput);
        } catch (URISyntaxException | IOException e) {
            log.error(e.getMessage(), e);
        }
        return context;
    }
}
