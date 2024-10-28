package racingcar.view;

import racingcar.domain.Car;

import java.util.List;
import java.util.stream.Collectors;

public class OutputView {
    private static final String RESULT_START_MESSAGE = "\n실행 결과";
    private static final String POSITION_MARK = "-";
    private static final String WINNER_MESSAGE = "최종 우승자 : ";

    public void printResultStart() {
        System.out.println(RESULT_START_MESSAGE);
    }

    public void printRoundResult(List<Car> cars) {
        cars.forEach(car -> {
            System.out.printf("%s : %s%n", car.getName(), POSITION_MARK.repeat(car.getPosition()));
        });
        System.out.println();
    }


    public void printWinners(List<Car> winners) {
        System.out.println(WINNER_MESSAGE + joinWinnerNames(winners));
    }

    private String joinWinnerNames(List<Car> winners) {
        return winners.stream()
                .map(Car::getName)
                .collect(Collectors.joining(", "));
    }
}
