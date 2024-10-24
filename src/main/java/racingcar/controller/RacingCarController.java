package racingcar.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import racingcar.entity.Car;
import racingcar.entity.Race;
import racingcar.util.RandomNumberGenerator;
import racingcar.view.RacingView;

public class RacingCarController {
    final private RacingView racingView;
    final private RandomNumberGenerator randomNumberGenerator;

    public RacingCarController(RacingView racingView, RandomNumberGenerator randomNumberGenerator) {
        this.racingView = racingView;
        this.randomNumberGenerator = randomNumberGenerator;
    }

    public void run() {
        String inputCarNames = this.racingView.inputCarNames();
        String inputRoundCount = this.racingView.inputRoundCount();

        String[] carNames = inputCarNames.split(",");
        int roundCount = Integer.parseInt(inputRoundCount);

        List<Car> cars = new ArrayList<>();
        for (String carName : carNames) {
            cars.add(new Car(carName));
        }

        Race race = new Race(cars);
        for (int i = 0; i < roundCount; i++) {
            race.runSingleRound(this.randomNumberGenerator);

            Map<String, Integer> results = new HashMap<>();
            for (Car car : cars) {
                results.put(car.getName(), car.getPosition());
            }
            racingView.printRoundResult(results);
        }

        racingView.printWinners(race.getWinners());
    }
}
