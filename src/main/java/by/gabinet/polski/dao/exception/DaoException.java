package by.gabinet.polski.dao.exception;

public class DaoException extends Exception {

    private Exception exception;
    private String message;

    public DaoException() {
    }

    public DaoException(String message) {
        super(message);
        this.message = message;
    }

    public DaoException(Exception exception, String message) {
        this.exception = exception;
        this.message = message;
    }

    public DaoException(Throwable throwable) {
        super(throwable);
    }

    public Exception getException() {
        return exception;
    }

    public void setException(Exception exception) {
        this.exception = exception;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
