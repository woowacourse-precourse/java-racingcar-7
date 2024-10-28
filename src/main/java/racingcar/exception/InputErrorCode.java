package racingcar.exception;

public enum InputErrorCode implements ErrorCode {


    INPUT_NAME_ERROR("이름 입력이 잘못되었습니다."),

    INPUT_NAME_LENGTH_ERROR("이름은 5자 이하여야 합니다."),

    INPUT_TIMES_ERROR("입력 횟수가 잘못되었습니다.");

    private final String message;

    InputErrorCode(String message) {
        this.message = message;
    }

    @Override
    public String message() {
        return message;
    }
}
