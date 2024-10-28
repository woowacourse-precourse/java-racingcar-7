package racingcar.domain;

import java.util.List;

public class CarMover {
    public static void decideMoveOrNot(List<Car> racingCarList) {
        for(Car car : racingCarList) {
            RandomNumberGenerator numberGenerator = new RandomNumberGenerator();
            int randomNumber = numberGenerator.generate();
            moveCarIfNeeded(car, randomNumber);
        }
    }
    private static void moveCarIfNeeded(Car car, int randomNumber) {
        if (isMoveAllowed(randomNumber))
            car.move();
    }
    private static boolean isMoveAllowed(int randomNumber) {
        return randomNumber >= 4;
    }
}