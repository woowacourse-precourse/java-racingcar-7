package racingcar.makingcars;

import java.util.ArrayList;
import java.util.List;
import racingcar.MakingCars;
import racingcar.domain.Car;

public class MakingCarsImpl implements MakingCars {

    @Override
    public List<Car> makeCars(List<String> carNames) {
        ArrayList<Car> cars = new ArrayList<>();
        for (String name : carNames) {
            cars.add(new Car(name, 0));
        }
        return cars;
    }
}
