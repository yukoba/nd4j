package org.nd4j.linalg.jocl.kernel;

/**
 * Created by agibsoncccc on 4/18/15.
 */
public class JoclException extends RuntimeException  {
    public JoclException() {
    }

    public JoclException(String message) {
        super(message);
    }

    public JoclException(String message, Throwable cause) {
        super(message, cause);
    }

    public JoclException(Throwable cause) {
        super(cause);
    }

    public JoclException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
