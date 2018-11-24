package de.fh.albsig.milazzdo.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import de.fh.albsig.milazzdo.model.Weather;
import de.fh.albsig.milazzdo.weather.WeatherService;;

/**
 * Servlet implementation class WeatherServlet.
 */
public class WeatherServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    /**
     * Logger for error documentation.
     */
    private static Logger log = Logger.getLogger(WeatherServlet.class);

    /**
     * @see HttpServlet#HttpServlet()
     */
    public WeatherServlet() {
        super();
    }

    /**
     * @see Weather Servlet.
     */
    @Override
    protected void doGet(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
        log.info("Start Weather Application");
        final String city = "Albstadt";
        WeatherService service = new WeatherService();
        PrintWriter out = response.getWriter();
        try {
            out.println(service.start(city));
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }
        out.flush();
        out.close();
    }
}
