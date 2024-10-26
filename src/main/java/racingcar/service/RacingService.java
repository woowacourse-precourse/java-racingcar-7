package racingcar.service;

import java.util.List;
import racingcar.domain.Car;
import racingcar.repository.CarRepository;
import racingcar.validator.Validator;
import racingcar.validator.impl.NumberValidator;
import racingcar.view.ExecutionView;

public class RacingService {
    CarRepository carRepository;
    Validator validator;
    ExecutionView executionView;

    public RacingService(CarRepository carRepository) {
        this.carRepository = carRepository;
        this.validator = new NumberValidator();
        this.executionView = new ExecutionView();
    }

    public void race(String rawNumber) {
        int count = parseInt(rawNumber);

        List<Car> cars = carRepository.findAll();

        executionView.printExecutionPrompt();
        for (int i = 0; i < count; i++) {
            for (Car car : cars) {
                car.moveOrStop();
            }
            executionView.printResult(cars);
        }
    }

    private int parseInt(String rawNumber) {
        validator.validate(rawNumber);

        return Integer.parseInt(rawNumber);
    }
}
