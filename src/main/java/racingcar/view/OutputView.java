package racingcar.view;

import java.util.List;
import java.util.stream.Collectors;
import racingcar.model.Car;

public class OutputView {
    static final String ROUND_RESULT_HEADER = "실행 결과\n";
    static final String RACING_CAR_PROGRESS_BAR = "-";
    static final String WINNER_RESULT_HEADER = "최종 우승자 : ";
    static final String WINNER_DELIMITER = ", ";


    public static void printRoundResultHeader() {
        System.out.println(ROUND_RESULT_HEADER);
    }

    public static void printRoundResult(List<Car> racingCars) {
        String result = racingCars.stream().map(racingCar -> {
            return racingCar.getName() + " : " + RACING_CAR_PROGRESS_BAR.repeat(racingCar.getProgressCount()) + "\n";
        }).collect(Collectors.joining());

        System.out.println(result);
    }

    public static void printWinnerResult(List<String> winnerNames) {
        String result = WINNER_RESULT_HEADER + String.join(WINNER_DELIMITER, winnerNames);
        System.out.print(result);

    }
}
