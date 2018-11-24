package de.fh.albsig.milazzdo.exception;

/**
 * @author milazzdo
 *
 */
public class WeatherException extends Exception {
    private static final long serialVersionUID = 1L;

    /**
     * super constructor for weather exception.
     */
    public WeatherException() {
        super();
    }

    /**
     * @param message
     *            from the exception.
     */
    public WeatherException(String message) {
        super(message);
    }

    /**
     * @param message
     *            from the exception.
     * @param cause
     *            from the parent element.
     */
    public WeatherException(String message, Exception cause) {
        super(message, cause);
    }

    /**
     * @param cause
     *            from the parent element.
     */
    public WeatherException(Exception cause) {
        super(cause);
    }

    /**
     * @param message
     *            from the exception.
     * @param cause
     *            from the parent element.
     */
    public WeatherException(String message, RuntimeException cause) {
        super(message, cause);
    }

    /**
     * @param cause
     *            from the parent element.
     */
    public WeatherException(RuntimeException cause) {
        super(cause);
    }
}
