package racingcar.util;

public enum ErrorMessage {
    MAX_CAR_COUNT(
            "[R0001]",
            "자동차는 5대까지만."),
    DUPLICATE_CAR(
            "[D0001]",
            "중복 자동차가 있어요."),
    PLAY_COUNT_FORMAT(
            "[F0001]",
            "숫자만 입력하세요."),
    PLAY_COUNT_LIMIT(
            "[R0002]",
            "1에서 9사이가 좋겠어요."),
    EMPTY_CAR_NAME(
            "[F0002]",
            "자동차 이름이 없어요."),
    MAX_CAR_NAME_LENGTH(
            "[R0003]",
            "자동차 이름은 5자 이하만 돼요."),
    CAR_NAME_FORMAT(
            "[F0003]",
            "자동차 이름은 영문 대소문자와 숫자만 돼요"),
    ;

    String errorCode;
    String errorMessage;

    ErrorMessage(String errorCode, String errorMessage) {
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }

    public String getError() {
        return Message.ERROR_TAG.getSentence() + errorCode + " " + errorMessage;
    }
}