package racingcar.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import racingcar.validator.CarNameValidator;

public class CarFactory {

    private final CarNameValidator carNameValidator = new CarNameValidator();

    private static final String DELIMITER = ",";

    public ArrayList<Car> createCar(String rawCarNames) {
        ArrayList<String> carNameList = new ArrayList<>(Arrays.asList(rawCarNames.split(DELIMITER)));

        ArrayList<Car> carList = new ArrayList<>();
        HashSet<String> carNameSet = new HashSet<>();

        for(String carName : carNameList) {
            carName = carNameValidator.isValid(carName, carNameSet);

            carList.add(Car.createCar(carName));
            carNameSet.add(carName);
        }

        return carList;
    }
}
