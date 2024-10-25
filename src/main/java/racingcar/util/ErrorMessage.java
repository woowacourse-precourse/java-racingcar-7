package racingcar.util;

public enum ErrorMessage {
    DEFAULT(
            "[ERROR_CODE]",
            "ERROR_MESSAGE"),
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