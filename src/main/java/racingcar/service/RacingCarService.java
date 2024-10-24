package racingcar.service;

import java.util.ArrayList;
import racingcar.entity.Car;
import racingcar.entity.Race;
import racingcar.util.RandomNumberGenerator;

public class RacingCarService {
    final RandomNumberGenerator randomNumberGenerator;

    public RacingCarService(RandomNumberGenerator randomNumberGenerator) {
        this.randomNumberGenerator = randomNumberGenerator;
    }

    public String[] run(String userCarInput, String userRoundInput) {
        String[] carNames = userCarInput.split(",");
        int rounds = Integer.parseInt(userRoundInput);

        ArrayList<Car> cars = new ArrayList<>();
        for (String carName : carNames) {
            cars.add(new Car(carName));
        }

        Race race = new Race(cars);
        for (int round = 0; round < rounds; round++) {
            race.runSingleRound(randomNumberGenerator);
        }

        return race.getWinners();
    }
}
