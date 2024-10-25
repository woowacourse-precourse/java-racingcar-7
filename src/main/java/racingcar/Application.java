package racingcar;

import static racingcar.RacingConstants.CAR_START_POSITION;
import static racingcar.RacingConstants.MAX_NUMBER;
import static racingcar.RacingConstants.MIN_NUMBER;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        OutputView outputView = new OutputView();
        NumberGenerator numberGenerator = new NumberGenerator(MIN_NUMBER, MAX_NUMBER);
        NumberValidator numberValidator = new NumberValidator();
        List<Car> cars = new ArrayList<>();
        cars.add(new Car("pobi", CAR_START_POSITION));
        cars.add(new Car("woni", CAR_START_POSITION));
        cars.add(new Car("jun", CAR_START_POSITION));
        Move move = new Move(cars, numberValidator, numberGenerator);
        move.tryOnce();
        outputView.printCarStatus(cars.stream().map(Car::createCurrentCar).toList());
    }
}
