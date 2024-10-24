package racingcar.core.view;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class RacingView {

    public String inputCars() {
        printMessage("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        return readLine();
    }

    public String inputTryCount() {
        printMessage("시도할 횟수는 몇 회인가요?");
        return readLine();
    }

    public void printRaceStart() {
        printMessage("\n실행 결과");
    }

    private void printMessage(String message) {
        System.out.println(message);
    }
}
