package racingcar;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        List<Car> cars = RacingCarInput.carNameInput();
        int round = RacingCarInput.roundInput();
        RacingCar racingCar = new RacingCar(cars);
        racingCar.run(round);
    }
}
