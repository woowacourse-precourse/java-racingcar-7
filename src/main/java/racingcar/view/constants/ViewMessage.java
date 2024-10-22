package racingcar.view.constants;

public enum ViewMessage {

    INPUT_CAR_NAMES("자동차 이름을 쉼표(,)로 구분하여 입력하세요."),
    RACE_RESULT_TITLE("실행 결과"),
    RACE_STATUS("%s : %s"),
    ;

    private final String message;

    ViewMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
