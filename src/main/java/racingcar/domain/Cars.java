package racingcar.domain;

import java.util.ArrayList;
import java.util.List;
import static racingcar.domain.CarName.validateCarName;

public class Cars {
    private final List<Car> cars = new ArrayList<>();
    public Cars(List<String> carNames){
        validateCarName(carNames);
        for (String carName : carNames) {
            cars.add(new Car(carName));
        }
    }
    public List<Car> getCars() {
        return cars;
    }
}
