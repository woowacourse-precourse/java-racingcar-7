package racingcar;

import java.util.List;

public class Application {
    public static void main(String[] args) {

        RacingCarInput car = new RacingCarInput();

        List<String> carNames = car.getCarNames();
        int count = car.getCount();

        System.out.println(carNames + " " + count);
    }
}
