package racingcar;

import static racingcar.RacingConstants.CAR_START_POSITION;
import static racingcar.RacingConstants.MAX_NUMBER;
import static racingcar.RacingConstants.MIN_NUMBER;

public class Application {
    public static void main(String[] args) {
        NumberGenerator numberGenerator = new NumberGenerator(MIN_NUMBER, MAX_NUMBER);
        NumberValidator numberValidator = new NumberValidator();
        Car car = new Car("pobi", CAR_START_POSITION);
        Move move = new Move(car, numberValidator, numberGenerator);
        move.tryOnce();
    }
}
