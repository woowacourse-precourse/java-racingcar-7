package racingcar.exception;

public enum ExceptionCode {

    NAME_SIZE_OVER("Car name exceeds size limit"),
    NAME_NULL("Car name is empty"),
    NAME_LIST_NULL("Car name List is empty"),
    INVALID_DELIMITER("Invalid delimiter"),
    NO_RACE_CAR("No cars available"),
    EMPTY_LIMIT_NUMBER("Limit number is empty");


    private final String message;

    ExceptionCode(String message) {
        this.message = message;
    }

    public String getMessage() {
        return this.message;
    }


}
