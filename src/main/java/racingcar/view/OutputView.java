package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.domain.Car;

import java.util.List;

public class OutputView {
    private final String PRINT_RESULT = "\n실행 결과";
    private final String PRINT_WINNERS = "최종 우승자 : ";

    public void printRoundResult(boolean isFirstRound, List<Car> participants) {
        if (isFirstRound) {
            System.out.println(PRINT_RESULT);
        }
        for (Car car : participants) {
            System.out.println(car.getName() + " : " + "-".repeat(car.getMovedCnt()));
        }
        System.out.println();
    }

    public void printWinners(List<String> winners) {
        System.out.print(PRINT_WINNERS + String.join(", ", winners));
    }
}
