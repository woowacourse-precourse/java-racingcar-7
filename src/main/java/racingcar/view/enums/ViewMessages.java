package racingcar.view.enums;

public enum ViewMessages {

    ENTER_CAR_NAMES("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)"),
    ENTER_NUMBER_OF_ATTEMPTS("시도할 횟수는 몇 회인가요?"),
    ATTEMPTS_RESULT("실행 결과"),
    FINAL_WINNERS("최종 우승자 : ");

    private final String viewMessages;

    ViewMessages(String viewMessages) {
        this.viewMessages = viewMessages;
    }

    public String getViewMessages() {
        return viewMessages;
    }

}