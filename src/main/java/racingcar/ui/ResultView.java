package racingcar.ui;

import java.util.List;
import racingcar.domain.Car;

public class ResultView {
    private static final String EXECUTION_RESULT = "실행 결과";
    private static final String FINAL_CHAMPIONS = "최종 우승자 : ";


    public void printRaceResult(String result) {
        System.out.println(EXECUTION_RESULT);
        System.out.println(result);
    }

    public void printWinners(List<Car> winners) {
        String winnerNames = getWinnerNames(winners);
        System.out.println(FINAL_CHAMPIONS + winnerNames);
    }

    private String getWinnerNames(List<Car> winners) {
        List<String> winnerNames = winners.stream()
                .map(Car::getName)
                .toList();

        return String.join(", ", winnerNames);
    }
}
