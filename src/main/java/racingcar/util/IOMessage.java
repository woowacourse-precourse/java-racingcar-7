package racingcar.util;

public enum IOMessage {
    INPUT_CAR_NAME_MESSAGE("자동차 이름은 다섯글자 이하로 입력해주세요."),
    INPUT_TRIAL_MESSAGE("한글자 이상의 자동차 이름을 입력해주세요."),
    OUTPUT_RESULT_MESSAGE("최종 우승자 : ");

    private final String message;

    IOMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
