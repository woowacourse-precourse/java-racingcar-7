package racingcar.view;

import java.util.List;
import java.util.stream.Collectors;
import racingcar.model.Car;
import racingcar.model.Cars;

public class OutputView {

    private static final String RESULT_MESSAGE = "실행 결과";
    private static final String MOVEMENT_SYMBOL = "-";
    private static final String WINNER_MESSAGE = "최종 우승자";

    public void printResultMessage() {
        System.out.println();
        System.out.println(RESULT_MESSAGE);
    }

    public void printRaceResult(Cars cars) {
        cars.cars().forEach(car ->
                System.out.println(car.getName() + " : " + MOVEMENT_SYMBOL.repeat(car.getPosition()))
        );
        System.out.println();
    }

    public void printWinner(List<Car> winner) {
        System.out.print(WINNER_MESSAGE + " : ");
        String winners = winner.stream().map(Car::getName).collect(Collectors.joining(", "));
        System.out.println(winners);
    }
}
