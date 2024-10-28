package racingcar.validator;

public enum Exception {
    CUSTOM_DELIMITER_FORMAT_ERROR("자동차 이름은 1자 이상 5자 이하로 입력해 주세요."),
    DUPLICATE_CAR_NAME_ERROR("자동차 이름은 중복될 수 없습니다."),
    INVALID_CHARACTERS_IN_CAR_NAME_ERROR("자동차 이름은 한글, 영어, 숫자 외의 글자를 포함할 수 없습니다."),
    POSITIVE_NUMBER_REQUIRED_ERROR("횟수는 1 이상의 정수로 입력해 주세요.");
    private final String value;

    Exception(String value){
        this.value =value;
    }
    public String getValue(){
        return value;
    }
}
