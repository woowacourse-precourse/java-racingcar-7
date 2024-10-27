package racingcar.viewHandler.api.message;

public class ExceptionMessageImpl extends RuntimeException implements ApiMessage {
    private final String message;
    private final Integer code;

    public ExceptionMessageImpl(String message, Integer code) {
        this.message = message;
        this.code = code;
    }

    public ExceptionMessageImpl(ErrorMessage errorMessage) {
        this.message = errorMessage.getMessage();
        this.code = errorMessage.getCode();
    }

    @Override
    public String getMessage() {
        return message;
    }

    @Override
    public Integer getCode() {
        return code;
    }
}
