package racingcar.service;

import java.util.Arrays;
import java.util.List;
import net.bytebuddy.dynamic.loading.InjectionClassLoader.Strategy;
import racingcar.domain.Car;
import racingcar.domain.GenerateNumberStrategy;
import racingcar.domain.Race;
import racingcar.domain.RandomGenerateNumberStrategy;
import racingcar.request.CarCreateRequest;

public class RaceService {
    private final Race race;
    private final int totalRound;
    private int round;

    public RaceService(CarCreateRequest request) {
        List<Car> cars = Arrays.stream(request.getNames()).map(Car::new).toList();
        GenerateNumberStrategy strategy = new RandomGenerateNumberStrategy();

        this.race = new Race(cars, strategy);
        this.totalRound = request.getTryCount();
    }

    public List<Car> play() {
        round++;
        return race.moveAllCars();
    }

    public List<Car> getWinner() {
        return race.getWinner();
    }

    public boolean isGameEnd() {
        return round >= totalRound;
    }
}
