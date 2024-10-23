package racingcar;

import java.util.Arrays;
import java.util.List;
import racingcar.domain.Car;
import racingcar.view.InputView;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        InputView inputView = new InputView();
        String[] carNames = inputView.inputCarNames().split(",");
        int raceRound = inputView.inputRaceRound();

        List<Car> cars = Arrays.stream(carNames).map(Car::new).toList();
        while (raceRound-- > 0) {
            System.out.println("?");
            cars.forEach(Car::move);
        }
    }
}
