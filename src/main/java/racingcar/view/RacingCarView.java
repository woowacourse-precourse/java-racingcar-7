package racingcar.view;

public class RacingCarView {
    private final String carInputString = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private final String tryInputString = "시도할 횟수는 몇 회인가요?";
    private final String outputString = "최종 우승자 : ";

    public void getCarInputString() {
        System.out.println(carInputString);
    }

    public void getTryInputString() {
        System.out.println(tryInputString);
    }

    public void getOutputString(String carNames) {
        System.out.println(outputString + carNames);
    }
}
