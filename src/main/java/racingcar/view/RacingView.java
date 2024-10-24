package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Map;

public class RacingView {

    public String inputCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,) 기준으로 구분)");
        return Console.readLine();
    }

    public String inputRoundCount() {
        System.out.println("시도할 회수는 몇회인가요?");
        return Console.readLine();
    }

    public void printRoundResult(Map<String, Integer> carPositions) {
        carPositions.forEach((name, position) ->
                System.out.println(name + " : " + "-".repeat(position))
        );
        System.out.println();
    }

    public void printWinners(String[] winners) {
        System.out.println("최종 우승자 : " + String.join(", ", winners));
    }

    public void viewClose() {
        Console.close();
    }
}


