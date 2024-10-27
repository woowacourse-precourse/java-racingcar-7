package racingcar.config;

import racingcar.repository.CarRepository;
import racingcar.repository.InMemoryCarRepository;
import racingcar.service.RaceService;
import racingcar.service.RaceServiceImpl;

public class AppConfig {

    CarRepository carRepository;
    RaceService raceService;

    private AppConfig() {
        carRepository = InMemoryCarRepository.getInstance();
        raceService = RaceServiceImpl.getInstance();
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

    public RaceService getRaceService() {
        return raceService;
    }
}
