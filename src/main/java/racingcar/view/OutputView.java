package racingcar.view;

import racingcar.domain.Car;
import racingcar.dto.GameResult;
import racingcar.dto.RoundResults;

import java.util.List;

public class OutputView {

    public static void printResult(GameResult gameResult) {
        printRoundResults(gameResult.getRoundResults());
        printWinners(gameResult.getWinnerNames());
    }

    private static void printRoundResults(RoundResults roundResults) {
        System.out.println();
        for (List<Car> cars : roundResults.getResult()) {
            printSingleCarRoundResult(cars);
        }
    }

    private static void printSingleCarRoundResult(List<Car> cars) {
        for (Car car : cars) {
            System.out.println(car.getCarName() +" : "+"-".repeat(car.getPosition()));
        }
        System.out.println();
    }

    private static void printWinners(List<String> winnerNames) {
        System.out.print("최종 우승자 : "+ String.join(", ", winnerNames));
    }
}
