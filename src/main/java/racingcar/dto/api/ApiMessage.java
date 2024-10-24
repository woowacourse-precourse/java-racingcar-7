package racingcar.dto.api;

public enum ApiMessage {
    성공(500, "success")
    ;

    private final Integer code;
    private final String message;

    ApiMessage(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public Integer getCode() {
        return code;
    }
}
