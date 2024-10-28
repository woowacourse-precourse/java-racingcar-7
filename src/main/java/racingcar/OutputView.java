package racingcar;

import java.util.List;
import java.util.stream.Collectors;

public class OutputView {
    private static final String ROUND_RESULT = "\n실행 결과";
    private static final String WINNER_RESULT = "최종 우승자 : ";
    private static final String NAME_POSITION_DELIMITER = " : ";
    private static final String POSITION_SYMBOL = "-";
    private static final String JOIN_DELIMITER = ", ";

    public void printInfo() {
        System.out.println(ROUND_RESULT);
    }

    public void printRound(List<Car> cars) {
        cars.forEach(this::printRound);
        System.out.println();
    }

    private void printRound(Car car) {
        System.out.println(car.getName() + NAME_POSITION_DELIMITER + POSITION_SYMBOL.repeat(car.getPosition()));
    }

    public void printWinner(List<Car> winners) {
        String winnerNames = winners.stream()
                .map(Car::getName)
                .collect(Collectors.joining(JOIN_DELIMITER));
        System.out.println(WINNER_RESULT + winnerNames);
    }
}
