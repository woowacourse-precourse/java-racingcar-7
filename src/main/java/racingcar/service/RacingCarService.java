package racingcar.service;

import static racingcar.exception.ExceptionMessage.EMPTY_CARS;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import racingcar.domain.Car;
import racingcar.domain.Cars;
import camp.nextstep.edu.missionutils.Randoms;
import racingcar.domain.Position;

public class RacingCarService {
    private static final int MIN_RANDOM_NUMBER = 0;
    private static final int MAX_RANDOM_NUMBER = 9;
    private static final int STOP_BOUNDARY = 3;

    private Cars cars;
    private TryCount tryCount;

    public void createCars(List<String> carNameList){
        this.cars = new Cars(carNameList);
    }

    public void setTryCount(int value) {
        this.tryCount = new TryCount(value);
    }

    public boolean isAvailable() {
        return tryCount.playOneRound();
    }

    public void moveCars() {
        for (Car car : cars.getCars()) {
            int randomNumber = Randoms.pickNumberInRange(MIN_RANDOM_NUMBER, MAX_RANDOM_NUMBER);
            if (randomNumber > STOP_BOUNDARY) {
                car.move();
            }
        }
    }

    public List<String> findWinnersName() {
        Position longestPosition = getLongestPosition();
        return cars.getCars()
                .stream()
                .filter(car -> car.getPosition().getValue() == longestPosition.getValue())
                .map(car -> car.getName().toString())
                .collect(Collectors.toList());
    }

    private Position getLongestPosition() {
        return cars.getCars()
                .stream()
                .map(Car::getPosition)
                .max(Comparator.comparing(Position::getValue))
                .orElseThrow(() -> new IllegalArgumentException(EMPTY_CARS.getMessage()));
    }

    public Cars getCars() {
        return cars;
    }

}
