package racingcar;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;

public class IOController {

    private static final String CAR_NAME_ENTER_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String REPEAT_COUNT_ENTER_MESSAGE = "시도할 횟수는 몇 회인가요?";
    private static final String WINNER_PRINT_MESSAGE = "최종 우승자 : ";

    public String enterCarNames() {
        System.out.println(CAR_NAME_ENTER_MESSAGE);
        String carNames = Console.readLine();

        return carNames;
    }

    public String enterRepeatCount() {
        System.out.println(REPEAT_COUNT_ENTER_MESSAGE);
        String repeatCount = Console.readLine();

        return repeatCount;
    }

    public void printResults(List<Car> cars) {
        for (Car car : cars) {
            printResultByCar(car.getName(), car.getMoveCount());
            System.out.println();
        }
    }

    public void printResultByCar(String carName, long moveCount) {
        System.out.print(carName + " : ");
        for (int i = 0; i < moveCount; i++) {
            System.out.print("-");
        }
    }

    public void printWinners(List<Car> winners) {
        System.out.print(WINNER_PRINT_MESSAGE);

        for (int i = 0; i < winners.size(); i++) {
            Car winner = winners.get(i);
            System.out.print(winner.getName());

            if (i != winners.size() - 1) {
                System.out.print(", ");
            }
        }
    }
}
