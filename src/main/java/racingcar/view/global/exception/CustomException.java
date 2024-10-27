package racingcar.view.global.exception;

public class CustomException extends IllegalArgumentException {
    private CustomException(ErrorMessage errorMessage) {
        super(errorMessage.getMessage());
    }

    public static CustomException of(ErrorMessage errorMessage) {
        return new CustomException(errorMessage);
    }
}
