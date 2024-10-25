package racingcar.view;

public enum ViewMessage {
    자동차_이름_입력("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)"),
    총_라운드_입력("시도할 횟수는 몇 회인가요?"),
    라운드_결과_출력("\n실행 결과"),
    최종_우승자_출력("최종 우승자 : ");

    private String message;

    ViewMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
