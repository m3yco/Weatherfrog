package de.fh.albsig.milazzdo.service;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.apache.log4j.Logger;
import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import de.fh.albsig.milazzdo.exception.WeatherException;
import de.fh.albsig.milazzdo.model.Weather;

/**
 * @author milazzdo
 *
 */
public class XMLCreator {
    /**
     * Logger for error documentation.
     */
    private static Logger log = Logger.getLogger(XMLCreator.class);
    /**
     * factory for the document builder.
     */
    private DocumentBuilderFactory factory;
    /**
     * document builder.
     */
    private DocumentBuilder textBuilder;
    /**
     * document.
     */
    private Document textDoc;
    /**
     * main root element.
     */
    private Element rootElement;
    /**
     * child root element.
     */
    private Element memberChildElement;
    /**
     * attribute of the child.
     */
    private Attr memberAttribute;
    /**
     * factory for the transformer.
     */
    private TransformerFactory textTransformerFactory;
    /**
     * transformer.
     */
    private Transformer textTransformer;
    /**
     * source for the document.
     */
    private DOMSource source;
    /**
     * stream for the path.
     */
    private StreamResult result;

    /**
     * @param w
     *            object variable.
     * @param xmlFile
     *            xml path.
     * @throws WeatherException
     *             weather exception.
     */
    public final void toXML(final Weather w, final String xmlFile)
            throws WeatherException {
        try {
            log.info("Create Output XML");
            factory = DocumentBuilderFactory.newInstance();
            textBuilder = factory.newDocumentBuilder();
            textDoc = textBuilder.newDocument();
            final String[] attibutes = { "cityName", "region", "country",
                    "temperature", "conditions", "humidity", "chill",
                    "direction", "speed", "visibility", "timestamp", "sunrise",
                    "sunset" };
            rootElement = textDoc.createElement("weather");
            textDoc.appendChild(rootElement);
            memberChildElement = textDoc.createElement("city");
            rootElement.appendChild(memberChildElement);

            for (String value : attibutes) {
                memberAttribute = textDoc.createAttribute(value);
                memberAttribute.setValue(w.getSunset());
                memberChildElement.setAttributeNode(memberAttribute);
            }

            textTransformerFactory = TransformerFactory.newInstance();
            textTransformer = textTransformerFactory.newTransformer();
            source = new DOMSource(textDoc);

            result = new StreamResult(xmlFile);
            textTransformer.transform(source, result);

        } catch (ParserConfigurationException | TransformerException e) {
            log.error(e.getMessage(), e);
            throw new WeatherException(e.getMessage(), e);
        }
    }
}
