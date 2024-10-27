package racingcar.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import racingcar.domain.Car;
import racingcar.repository.CarRepository;

public class CarService {
    private final static Validator validator = new Validator();
    private final static CarRepository CAR_REPOSITORY = new CarRepository();


    public void makeCar(String input) {
        validator.checkCarName(input);
        saveCar(splitRacer(input));
    }

    public void saveCar(List<String> carNames) {
        for (String carName : carNames) {
            CAR_REPOSITORY.save(new Car(carName));
        }
    }

    public List<String> splitRacer(String input) {
        return new ArrayList<>(Arrays.asList(input.split(",")));
    }
}
