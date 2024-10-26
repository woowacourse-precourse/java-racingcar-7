package racingcar.model;

import java.util.List;
import java.util.stream.Collectors;
import racingcar.util.CarNameValidator;
import racingcar.util.MoveCountValidator;

public class Referee {
    private final String roundNumber;

    public Referee(String roundNumber) {
        CarNameValidator.checkEmpty(roundNumber);
        MoveCountValidator.validate(roundNumber);

        this.roundNumber = roundNumber;
    }

    public int getRoundNumber() {
        return Integer.parseInt(roundNumber);
    }

    public List<Car> judgementWinnerCars(Cars cars) {
        int maxMove = cars.getCars().stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElseThrow(() -> new IllegalArgumentException("자동차 목록이 비어 있습니다."));

        return cars.getCars().stream()
                .filter(car -> car.getPosition() == maxMove)
                .collect(Collectors.toList());
    }
}
