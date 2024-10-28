package racingcar.view;

import java.util.List;
import java.util.stream.Collectors;
import racingcar.model.Car;
import racingcar.utils.ConstantMessage;

public class OutputView {
    public void printResultMessage() {
        System.out.println(ConstantMessage.OUTPUT_RESULT_MESSAGE);
    }

    public void printExecuteResult(List<Car> winners) {
        System.out.printf(ConstantMessage.OUTPUT_WINNER_MESSAGE);
        String winnerNames = winners.stream()
                .map(Car::getName)
                .collect(Collectors.joining(ConstantMessage.COMMA_SEPARATOR));
        System.out.println(winnerNames);
    }

    public void printRacingProgress(List<Car> carList) {
        carList.forEach(this::printCarInfo);
    }

    private void printCarInfo(Car car) {
        String carInfo = ConstantMessage.DISTANCE_MARKER.repeat(car.getDistance());
        System.out.printf("%s : %s%n", car.getName(), carInfo);
    }
}
