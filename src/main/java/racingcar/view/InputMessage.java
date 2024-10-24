package racingcar.view;

public enum InputMessage {
    자동차_이름_입력("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)"),
    총_라운드_입력("시도할 횟수는 몇 회인가요?");

    private String message;

    InputMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
