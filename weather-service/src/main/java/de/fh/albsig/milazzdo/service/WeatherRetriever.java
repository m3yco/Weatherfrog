package de.fh.albsig.milazzdo.service;

import java.io.IOException;
import java.io.InputStream;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ResourceBundle;

import org.apache.http.client.utils.URIBuilder;
import org.apache.log4j.Logger;

import de.fh.albsig.milazzdo.exception.WeatherException;

/**
 * @author milazzdo
 *
 */
public class WeatherRetriever {
    /**
     * Logger for error documentation.
     */
    private static Logger log = Logger.getLogger(WeatherRetriever.class);

    /**
     * @param city
     *            get select from bundle.
     * @return the url connection.
     * @throws IOException
     *             for input exception.
     * @throws WeatherException
     *             weather exception.
     */

    public InputStream retrieve(final String city)
            throws IOException, WeatherException {
        ResourceBundle bundle;
        String query;
        URIBuilder uriBuilder;
        URLConnection connection;

        log.info("Get Yahoo Weather API XML");
        bundle = ResourceBundle.getBundle("cities");
        query = bundle.getString(city);
        connection = null;
        try {
            uriBuilder = new URIBuilder(
                    "https://query.yahooapis.com/v1/public/yql");
            uriBuilder.addParameter("format", "xml");
            uriBuilder.addParameter("q", query);

            URL url = uriBuilder.build().toURL();
            connection = url.openConnection();
        } catch (URISyntaxException e) {
            log.error(e.getMessage(), e);
            throw new WeatherException(e.getMessage(), e);
        }
        return connection.getInputStream();
    }
}
