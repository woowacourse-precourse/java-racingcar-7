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

    public String[] run(String[] carNames, int rounds) {
        ArrayList<Car> cars = createCars(carNames);
        Race race = new Race(cars);

        raceStart(rounds, race);
        return race.getWinners();
    }

    private ArrayList<Car> createCars(String[] carNames) {
        ArrayList<Car> cars = new ArrayList<>();
        for (String carName : carNames) {
            cars.add(new Car(carName));
        }
        return cars;
    }

    private void raceStart(int rounds, Race race) {
        for (int round = 0; round < rounds; round++) {
            race.runSingleRound(randomNumberGenerator);
        }
    }
}
