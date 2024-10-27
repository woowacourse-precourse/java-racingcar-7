package racingcar;

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
        cars.forEach(this::printCarPosition);
        System.out.println();
    }

    private void printCarPosition(Car car) {
        System.out.printf("%s : %s%n",
                car.getName(),
                POSITION_MARK.repeat(car.getPosition())
        );
    }

    public void printWinners(List<Car> winners) {
        String winnerNames = winners.stream()
                .map(Car::getName)
                .collect(Collectors.joining(", "));
        System.out.println(WINNER_MESSAGE + winnerNames);
    }
}
