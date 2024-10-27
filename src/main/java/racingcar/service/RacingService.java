package racingcar.service;

import java.util.List;
import racingcar.domain.Car;
import racingcar.repository.CarRepository;
import racingcar.validator.Validator;
import racingcar.view.RaceOutputView;

public class RacingService {
    private final CarRepository carRepository;
    private final Validator validator;
    private final RaceOutputView raceOutputView;

    public RacingService(CarRepository carRepository, Validator validator, RaceOutputView raceOutputView) {
        this.carRepository = carRepository;
        this.validator = validator;
        this.raceOutputView = raceOutputView;
    }

    public void race(String rawNumber) {
        int count = parseInt(rawNumber);

        List<Car> cars = carRepository.findAll();

        for (int i = 0; i < count; i++) {
            for (Car car : cars) {
                car.moveOrStop();
            }
            raceOutputView.printResult(cars);
        }
    }

    private int parseInt(String rawNumber) {
        validator.validate(rawNumber);

        return Integer.parseInt(rawNumber);
    }
}
