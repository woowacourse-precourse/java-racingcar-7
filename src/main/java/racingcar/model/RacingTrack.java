package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import racingcar.exception.RacingTrackException;

public class RacingTrack {
    private final List<Car> cars;

    public RacingTrack() {
        this.cars = new ArrayList<>();
    }

    public void addCar(List<String> carNames) {
        for (String carName : carNames) {
            checkDuplicatedCarName(carName);
            cars.add(new Car(carName));
        }
    }

    public void checkDuplicatedCarName(String name) {
        var duplicatedName = cars.stream()
                .anyMatch(car -> car.getName().equals(name));
        if (duplicatedName) {
            throw new IllegalArgumentException(RacingTrackException.DUPLICATED_CAR_NAME.getMessage());
        }
    }

    public List<String> step() {
        for (Car car : cars) {
            var seed = Randoms.pickNumberInRange(0, 9);
            car.move(seed);
        }

        return getCarPositions();
    }

    public List<String> getCarPositions() {
        return cars.stream()
                .map(Car::getPositionInfo)
                .toList();
    }

    public List<String> getWinnerNames() {
        int winnerPosition = getWinnerPosition();
        return cars.stream()
                .filter(car -> car.getPosition() == winnerPosition)
                .map(Car::getName)
                .toList();
    }

    public int getWinnerPosition() {
        return cars.stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElse(0);
    }

    public List<Car> getCarsForTest() {
        return cars;
    }
}
