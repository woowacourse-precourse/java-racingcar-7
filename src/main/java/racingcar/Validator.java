package racingcar;

public class Validator {

    public static void forwardOrStop(Car car) {
        if (RandomNumber.isMoreThanFour()) {
            car.move();
        }
    }

}
