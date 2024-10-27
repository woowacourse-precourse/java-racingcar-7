package racingcar.model.enums;

public enum ExceptionMessage {
    INPUT_CHARACTER_EXCEPTION("입력 값이 문자가 아닙니다."),
    INPUT_NUMERIC_EXCEPTION("입력 값이 숫자가 아닙니다."),
    INPUT_RANGE_EXCEPTION("입력 값은 양수여야 합니다."),
    INPUT_SAME_EXCEPTION("중복된 값이 입력되었습니다."),

    NAME_QUANTITY_EXCEPTION("5자 이상은 입력할 수 없습니다."),

    DELIMITER_NONEXISTENTION_EXCEPTION("쉼표가 적어도 1개 이상은 존재해야 합니다."),
    DELIMITER_DUPLICATION_EXCEPTION("쉼표와 쉼표 사이에 적어도 1개 이상의 문자가 입력되어야 합니다."),
    DELIMITER_RANGE_EXCEPTION("쉼표 외에 다른 구분자를 사용할 수 없습니다.");

    private final String message;

    ExceptionMessage(String message){
        this.message = message;
    }

    public String getMessage(){
        return message;
    }
}
