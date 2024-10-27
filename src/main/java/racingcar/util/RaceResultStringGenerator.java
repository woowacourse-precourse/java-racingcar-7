package racingcar.util;

import racingcar.model.Car;

import java.util.List;

public class RaceResultStringGenerator {
    private static final String CAR_MOVEMENT_DELIMITER = " : "; // 차량 출력 구분자
    private static final String MOVEMENT_SYMBOL = "-";
    private static final String NEW_LINE = "\n";

    public String generateRaceResultString(List<Car> cars) {
        StringBuilder resultString = new StringBuilder();

        for (Car car : cars) {
            resultString.append(generateOneCarString(car)+NEW_LINE);
        }
        return resultString.append(NEW_LINE).toString();
    }

    private String generateOneCarString(Car car){
        StringBuilder oneCarString = new StringBuilder(car.getName() + CAR_MOVEMENT_DELIMITER);

        for (int i = 0; i < car.getMovedNumber(); i++) {
            oneCarString.append(MOVEMENT_SYMBOL);
        }
        return oneCarString.toString();
    }
}
