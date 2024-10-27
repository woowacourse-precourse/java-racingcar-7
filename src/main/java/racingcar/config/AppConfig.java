package racingcar.config;

import racingcar.car.Car;
import racingcar.car.CarFactory;
import racingcar.car.CarRegistry;
import racingcar.io.Input;
import racingcar.io.View;
import racingcar.race.RaceResult;
import racingcar.race.Stadium;

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
