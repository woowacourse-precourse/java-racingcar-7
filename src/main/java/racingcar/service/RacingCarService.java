package racingcar.service;

import static racingcar.exception.ExceptionMessage.EMPTY_CARS;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import racingcar.domain.Car;
import racingcar.domain.Cars;
import camp.nextstep.edu.missionutils.Randoms;
import racingcar.domain.Position;

public class RacingCarService {
    private static final int MIN_RANDOM_NUMBER = 0;
    private static final int MAX_RANDOM_NUMBER = 9;
    private static final int STOP_BOUNDARY = 3;

    private Cars cars;

    public RacingCarService(Cars cars){
        this.cars = cars;
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

        List<Car> winners = new ArrayList<>();
        for (Car car : cars.getCars()){
            if(car.getPosition().getValue() == longestPosition.getValue()){
                winners.add(car);
            }
        }

        List<String> winnersNames = new ArrayList<>();
        for (Car car : winners){
            winnersNames.add(car.getName().toString());
        }
        return winnersNames;
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
