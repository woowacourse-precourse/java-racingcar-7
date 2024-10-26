package racingcar.config;

import racingcar.repository.CarRepository;
import racingcar.repository.InMemoryCarRepository;

public class AppConfig {

    CarRepository carRepository;

    private AppConfig() {
        carRepository = InMemoryCarRepository.getInstance();
    }

    public static class Holder {
        private static final AppConfig INSTANCE = new AppConfig();
    }
    public static AppConfig getInstance() {
        return Holder.INSTANCE;
    }

    public CarRepository getCarRepository() {
        return carRepository;
    }
}
