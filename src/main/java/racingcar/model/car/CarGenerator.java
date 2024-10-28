package racingcar.model.car;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CarGenerator {

    public List<String> extractCarNames(String carInput) {
        String[] splitResult = carInput.split(",");
        return Arrays.asList(splitResult);
    }

    public Cars generateCars(List<String> carNames) {
        List<Car> carList = new ArrayList<>();
        Cars cars = new Cars(carList);
        for (String carName : carNames) {
            cars.addCar(new Car(carName));
        }

        return cars;
    }
}
