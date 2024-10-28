package racingcar.view.enumerate;

public enum ErrorOutputConstant {
    NAME_LENGTH_OVER_5_ERROR("5글자이하의 자동차의 이름을 입력해주세요."),
    INPUT_TRY_TIME_UNDER_1_ERROR("횟수는 1 이상의 정수로 입력해 주세요."),
    ABRUPT_ERROR("예상치못한 오류입니다.");

    ErrorOutputConstant(String sentence) {
        this.sentence = sentence;
    }

    public String getSentence() {
        return sentence;
    }

    private String sentence;
}
