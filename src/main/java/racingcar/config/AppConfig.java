package racingcar.config;

import racingcar.domain.car.Car;
import racingcar.domain.car.CarFactory;
import racingcar.domain.car.CarRegistry;
import racingcar.presentation.io.Input;
import racingcar.presentation.io.View;
import racingcar.domain.race.RaceResult;
import racingcar.domain.race.Stadium;

import java.util.Set;

public class AppConfig {
    private static AppConfig INSTANCE;

    private AppConfig() {}

    public static AppConfig getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new AppConfig();
        }
        return INSTANCE;
    }

    public Input createInput() {
        return new Input();
    }

    public View createView() {
        return new View();
    }

    public CarFactory createCarFactory() {
        return new CarFactory();
    }

    public CarRegistry createCarRegistry(Set<Car> cars) {
        return new CarRegistry(cars);
    }

    public RaceResult createRaceResult(CarRegistry carRegistry) {
        return new RaceResult(new StringBuilder(), carRegistry);
    }

    public Stadium createStadium(CarRegistry carRegistry, RaceResult raceResult) {
        return new Stadium(carRegistry, raceResult);
    }
}
