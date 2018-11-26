package de.fh.albsig.milazzdo.service;

/**
 * @author milazzdo
 *
 */
public interface Service {
    /**
     * @param city
     *            input for the location.
     * @return the response context.
     * @throws Exception
     *             default.
     */
    String start(final String city) throws Exception;
}
