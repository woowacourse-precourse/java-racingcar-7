package racingcar.view;

import java.util.stream.Collectors;
import racingcar.domain.Car;
import racingcar.response.RoundResponse;
import racingcar.response.WinnerResponse;

public class OutputView {
    static final String DELIMITER = ",";

    public static void printStart() {
        System.out.println("\n실행 결과");
    }

    public static void printRoundResult(RoundResponse res) {
        for (Car car : res.cars()) {
            System.out.printf("%s : %s\n", car.getName(), "-".repeat(car.getMovement()));
        }
        System.out.println();
    }

    public static void printWinners(WinnerResponse res) {
        String names = res.winners().stream().map(Car::getName).collect(Collectors.joining(DELIMITER));
        System.out.println("최종 우승자 : " + names);
    }
}
