package racingcar.view;

public class OutputView {
    private static final String ASK_INPUT_RACER_NAME = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    public void printAskInputRacerName() {
        printMessage(ASK_INPUT_RACER_NAME);
    }

    private void printMessage(String message) {
        System.out.println(message);
    }
}
