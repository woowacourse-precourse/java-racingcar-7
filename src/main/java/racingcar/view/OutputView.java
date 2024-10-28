package racingcar.view;

import java.util.stream.Collectors;
import java.util.stream.IntStream;
import racingcar.model.Car;
import racingcar.model.CarsManager;

public class OutputView {
    private static final String EXECUTION_RESULT_MESSAGE = "실행 결과";
    private static final String RACING_FORMAT = "%s : %s%n";
    private static final String FINAL_WINNER_FORMAT = "최종 우승자 : %s";

    public void printResult() {
        System.out.println(EXECUTION_RESULT_MESSAGE);
    }

    public void printWinners(CarsManager cars) {
        System.out.printf(FINAL_WINNER_FORMAT, cars.getWinners());
    }

    private String joinResults(CarsManager cars) {
        return cars.getCars().stream()
                .map(this::formatResult)
                .collect(Collectors.joining());
    }

    private String formatResult(Car car) {
        return String.format(RACING_FORMAT, car.getName(),
                getPositionDisplay(car.getPosition()));
    }

    private String getPositionDisplay(int position) {
        return IntStream.rangeClosed(1, position)
                .mapToObj(element -> "-")
                .collect(Collectors.joining());
    }

    public void printRacing(CarsManager cars) {
        System.out.println(joinResults(cars));
    }
}