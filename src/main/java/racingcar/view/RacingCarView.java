package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

public class RacingCarView {
    private static final String CAR_INPUT_STRING = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String TRY_INPUT_STRING = "시도할 횟수는 몇 회인가요?";
    private static final String OUTPUT_STRING = "최종 우승자 : ";
    private static final String NOW_STRING = "실행 결과";

    public String readInput() {
        return Console.readLine();
    }

    public void printCarInputString() {
        System.out.println(CAR_INPUT_STRING);
    }

    public void printTryInputString() {
        System.out.println(TRY_INPUT_STRING);
    }

    public void printOutputString(String carNames) {
        System.out.println(OUTPUT_STRING + carNames);
    }

    public void printNow(String carName, String carScoreDash) {
        System.out.println(carName + " : " + carScoreDash);
    }

    public void printNowString() {
        System.out.println(NOW_STRING);
    }
}
