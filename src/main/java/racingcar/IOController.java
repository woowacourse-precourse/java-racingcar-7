package racingcar;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;

public class IOController {

    public String enterCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String carNames = Console.readLine();

        return carNames;
    }

    public String enterRepeatCount() {
        System.out.println("시도할 횟수는 몇 회인가요?");
        String repeatCount = Console.readLine();

        return repeatCount;
    }

    public void printResultByCar(String carName, long moveCount) {
        System.out.print(carName + " : ");
        for (int i = 0; i < moveCount; i++) {
            System.out.print("-");
        }
    }

    public void printWinners(List<Car> winners) {
        System.out.print("최종 우승자 : ");

        for (int i = 0; i < winners.size(); i++) {
            Car winner = winners.get(i);
            System.out.print(winner.getName());

            if (i != winners.size()) {
                System.out.print(", ");
            }
        }
    }
}
