package racingcar;

import java.util.ArrayList;
import java.util.List;

public class Racing {

    public static void init() {

        // carName 및 round 입력
        String[] carNames = InputView.getCarNames();
        int rounds = InputView.getNumberOfRounds();

        // car 객체 생성
        List<Car> cars = new ArrayList<>();
        for (String carName : carNames) {
            cars.add(new Car(carName));
        }

        run(cars, rounds);

    }

    public static void run(List<Car> cars, int rounds) {
        for (int i = 0; i < rounds; i++) {
            for (Car car : cars) {
                car.move();
            }
            OutputView.printRoundResult(cars);
        }
        List<String> winners = getWinners(cars);
        OutputView.printWinners(winners);
    }

}
