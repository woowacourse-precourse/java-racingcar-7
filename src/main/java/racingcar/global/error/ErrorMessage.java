package racingcar.global.error;

public enum ErrorMessage {
    CAR_NAME_IS_DUPLICATED("카 이름이 중복 되었습니다 "),
    ONLY_KOREAN_OR_ENGLISH_ARE_ACCEPTED("한글 또는 영어만 허용합니다: "),
    CAR_NAME_IS_LONGER_THAN_5_CHARACTERS("자동차 이름이 5자가 넘습니다 : "),
    TO_RACE_A_CAR_YOU_NEED_AT_LEAST_TWO_CARS("자동차 경주 하려면 두대 이상 되어야 합니다"),
    EMPTY_NAMES_OR_NAMES_WITH_SPACES_ARE_NOT_ALLOWED("빈 이름이나 공백 포함된 이름은 허용되지 않습니다: "),
    NEGATIVE_NUMBERS_ARE_NOT_ALLOWED("음수는 허용 하지 않습니다 : ");

    private final String explanation;

    ErrorMessage(String explanation) {
        this.explanation = explanation;
    }

    public String getExplanation() {
        return explanation;
    }

}
