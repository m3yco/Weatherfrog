package de.fh.albsig.milazzdo.weather;

import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;

import org.apache.log4j.Logger;
import org.dom4j.Document;
import org.dom4j.DocumentFactory;
import org.dom4j.io.SAXReader;

import de.fh.albsig.milazzdo.model.Weather;
import de.fh.albsig.milazzdo.model.Weatherfrog;

/**
 * @author milazzdo
 *
 */
public class WeatherParser {

    /**
     * Logger for error documentation.
     */
    private static Logger log = Logger.getLogger(WeatherParser.class);

    /**
     * @param inputStream
     *            to extract the values of the document.
     * @return filled object.
     * @throws Exception
     *             default.
     */
    public final Weatherfrog parse(final InputStream inputStream)
            throws Exception {
        Weather weather;
        ResourceBundle weatherBundle;
        SAXReader xmlReader;
        Document doc;

        weather = new Weatherfrog();
        weatherBundle = ResourceBundle.getBundle("weather");

        log.info("Creating XML Reader");
        xmlReader = createXmlReader();
        doc = xmlReader.read(inputStream);

        log.info("Parsing XML Response");
        weather.setCity(doc.valueOf(weatherBundle.getString("city")));
        weather.setRegion(doc.valueOf(weatherBundle.getString("region")));
        weather.setCountry(doc.valueOf(weatherBundle.getString("country")));
        weather.setCondition(doc.valueOf(weatherBundle.getString("condition")));
        weather.setTemp(doc.valueOf(weatherBundle.getString("temp")));
        weather.setChill(doc.valueOf(weatherBundle.getString("chill")));
        weather.setDirection(doc.valueOf(weatherBundle.getString("direction")));
        weather.setSpeed(doc.valueOf(weatherBundle.getString("speed")));
        weather.setHumidity(doc.valueOf(weatherBundle.getString("humidity")));
        weather.setVisibility(
                doc.valueOf(weatherBundle.getString("visibility")));
        weather.setSunrise(doc.valueOf(weatherBundle.getString("sunrise")));
        weather.setSunset(doc.valueOf(weatherBundle.getString("sunset")));
        weather.setTimestamp(doc.valueOf(weatherBundle.getString("timestamp")));

        return (Weatherfrog) weather;
    }

    /**
     * @return the xml reader.
     */
    private SAXReader createXmlReader() {
        Map<String, String> uris = new HashMap<String, String>();
        uris.put("yweather", "http://xml.weather.yahoo.com/ns/rss/1.0");

        DocumentFactory factory = new DocumentFactory();
        factory.setXPathNamespaceURIs(uris);

        SAXReader xmlReader = new SAXReader();
        xmlReader.setDocumentFactory(factory);
        return xmlReader;
    }

}
