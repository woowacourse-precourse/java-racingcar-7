package racingcar.model;

import java.util.List;
import racingcar.extractor.CarNameExtractor;
import racingcar.factory.CarFactory;
import racingcar.validator.CarNameValidator;

public class CarManager {

    private final CarNameValidator carNameValidator;
    private final CarNameExtractor carNameExtractor;
    private final CarFactory carFactory;

    public CarManager(CarNameValidator carNameValidator, CarNameExtractor carNameExtractor, CarFactory carFactory) {
        this.carNameValidator = carNameValidator;
        this.carNameExtractor = carNameExtractor;
        this.carFactory = carFactory;
    }

    public List<Car> processCarName(String inputCarNames) {
        carNameValidator.validateCarNamesInput(inputCarNames);
        String[] carNames = carNameExtractor.extractCarName(inputCarNames);
        String[] validatedCarNames = carNameValidator.validateCarNames(carNames);
        return carFactory.createCars(validatedCarNames);
    }

}
