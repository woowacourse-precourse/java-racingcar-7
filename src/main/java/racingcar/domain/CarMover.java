package racingcar.domain;

import java.util.List;

public class CarMover {
    private static void moveCarIfNeeded(Car car, int randomNumber) {
        if (isMoveAllowed(randomNumber))
            car.move();
    }
    private static boolean isMoveAllowed(int randomNumber) {
        return randomNumber >= 4;
    }
}