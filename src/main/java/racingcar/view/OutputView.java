package racingcar.view;

import java.util.List;
import java.util.stream.Collectors;
import racingcar.model.Car;
import racingcar.model.Cars;

public class OutputView {
    private static final String RESULT_MESSAGE = "실행 결과";
    private static final String FINAL_WINNER_MESSAGE = "최종 우승자 : ";

    public void showResultMessage() {
        System.out.println(RESULT_MESSAGE);
    }

    public void showRoundResult(Cars cars) {
        StringBuilder result = new StringBuilder();
        for (Car car : cars.getCars()) {
            addCarWithNameAndPosition(result, car);
        }
        System.out.println(result);
    }

    private void addCarWithNameAndPosition(StringBuilder result, Car car) {
        result.append(car.getName()).append(" : ");
        result.append("-".repeat(car.getPosition()));
        result.append("\n");
    }

    public void showWinners(List<Car> winners) {
        System.out.print(FINAL_WINNER_MESSAGE);

        String result = winners.stream()
                .map(Car::getName)
                .collect(Collectors.joining(", "));
        System.out.println(result);
    }
}
