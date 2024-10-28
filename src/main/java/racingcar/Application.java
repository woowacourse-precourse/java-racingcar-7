package racingcar;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        String[] carNames = Input.inputCarNames();
        int tryCount = Input.inputTryCount();
        List<Car> cars = Race.initializeCars(carNames);//자동차 초기화

        Race.race(cars, tryCount);
        Output.printWinners(cars);

    }
}
