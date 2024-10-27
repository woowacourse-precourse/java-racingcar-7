package racingcar.view;

public class RacingCarView {
    private static final String CAR_INPUT_STRING = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String TRY_INPUT_STRING = "시도할 횟수는 몇 회인가요?";
    private static final String OUTPUT_STRING = "최종 우승자 : ";

    public void printCarInputString() {
        System.out.println(CAR_INPUT_STRING);
    }

    public void printTryInputString() {
        System.out.println(TRY_INPUT_STRING);
    }

    public void getOutputString(String carNames) {
        System.out.println(OUTPUT_STRING + carNames);
    }
}
