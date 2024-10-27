package racingcar;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;

public class RacingGameView {

    public String getCarsName() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        return Console.readLine();
    }

    public String getTurn() {
        System.out.println("시도할 횟수는 몇 회 인가요?");
        return Console.readLine();
    }

    public void displayStartRacing() {
        System.out.println();
        System.out.println("실행 결과");
    }

    public void displayCarState(String name, int distance) {
        String output = String.format("%s : %s", name, "-".repeat(distance));
        System.out.println(output);
    }

    public void displayCurrentTurnOver() {
        System.out.println();
    }

    public void displayWinners(List<String> winnersName) {
        String output = String.join(", ", winnersName);
        output = String.format("최종 우승자 : %s", output);
        System.out.println(output);
    }
}
