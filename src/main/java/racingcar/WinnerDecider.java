package racingcar;

import java.util.List;
import java.util.stream.Collectors;

public class WinnerDecider {
    private final String NOT_FOUND_CAR = "자동차를 찾을 수 없습니다.";

    public List<String> decideWinner(List<Car> carList) {
        int maxPosition = carList.stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElseThrow(() -> new IllegalArgumentException(NOT_FOUND_CAR));

        return carList.stream()
                .filter(car -> car.getPosition() == maxPosition)
                .map(Car::getName)
                .collect(Collectors.toList());
    }
}
