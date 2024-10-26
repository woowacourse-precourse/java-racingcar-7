package racingcar.ui;

import java.util.List;
import racingcar.domain.Car;

public class ResultView {

    public void printRaceResult(String result) {
        System.out.println("실행 결과");
        System.out.println(result);
    }

    public void printWinners(List<Car> winners) {
        String winnerNames = getWinnerNames(winners);

        System.out.println("최종 우승자 : " + winnerNames);
    }

    private String getWinnerNames(List<Car> winners) {
        List<String> winnerNames = winners.stream()
                .map(Car::getName)
                .toList();

        return String.join(", ", winnerNames);
    }
}
