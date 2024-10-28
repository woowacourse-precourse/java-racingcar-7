package racingcar.service;

import static racingcar.constants.CarRaceConstants.CAR_NAMES_INPUT_SEPARATOR;

import java.util.ArrayList;
import java.util.List;
import racingcar.domain.Car;
import racingcar.domain.CarValidator;
import racingcar.domain.TrialCountValidator;
import racingcar.view.InputView;

public class InputService {
    private final InputView inputView;

    public InputService(InputView inputView) {
        this.inputView = inputView;
    }

    public List<Car> getCars() {
        String carNamesInput = inputView.getCarNames();
        List<Car> cars = createCars(carNamesInput);
        CarValidator.validate(cars);
        return cars;
    }

    public int getTrialCount() {
        String trialCountInput = inputView.getTrialCount();
        TrialCountValidator.validate(trialCountInput);
        return Integer.parseInt(trialCountInput);
    }

    private List<Car> createCars(String carNamesInput) {
        List<Car> cars = new ArrayList<>();
        for (String carName : carNamesInput.split(CAR_NAMES_INPUT_SEPARATOR)) {
            cars.add(new Car(carName.trim()));
        }
        return cars;
    }
}
