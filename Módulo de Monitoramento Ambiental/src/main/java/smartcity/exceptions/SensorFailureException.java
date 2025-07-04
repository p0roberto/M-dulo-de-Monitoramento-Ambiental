package smartcity.exceptions;

public class SensorFailureException extends Exception {
    public SensorFailureException(String message) {
        super(message);
    }
    
    public SensorFailureException(String message, Throwable cause) {
        super(message, cause);
    }
}
