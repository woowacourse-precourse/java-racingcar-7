package racingcar;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;

public class IOController {

    String enterCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String carNames = Console.readLine();

        return carNames;
    }

    String enterRepeatCount() {
        System.out.println("시도할 횟수는 몇 회인가요?");
        String repeatCount = Console.readLine();

        return repeatCount;
    }

    void printResultByCar(String carName, long moveCount) {
        System.out.print(carName + " : ");
        for (int i = 0; i < moveCount; i++) {
            System.out.print("-");
        }
    }

    void printWinner(List<String> winners) {
        System.out.print("최종 우승자 : ");

        for (int i = 0; i < winners.size(); i++) {
            System.out.print(winners.indexOf(i));

            if (i != winners.size()) {
                System.out.print(", ");
            }
        }
    }
}
