package comp3350.srsys.persistence.hsqldb;

public class PersistenceException extends RuntimeException {
    public PersistenceException(final Exception cause) {
        super(cause);
    }
}