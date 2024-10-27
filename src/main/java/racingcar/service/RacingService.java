package racingcar.service;

import java.util.ArrayList;
import java.util.List;
import racingcar.model.Car;
import racingcar.model.Cars;
import racingcar.model.Race;
import racingcar.view.OutputView;

public class RacingService {

    public Cars enterCars(List<String> carNames) {
        List<Car> cars = new ArrayList<>();
        for (String carName : carNames) {
            Car car = Car.of(carName);
            cars.add(car);
        }

        return Cars.of(cars);
    }

    public void startRace(Cars cars, Race race) {
        while (race.hasNext()) {
            cars.moveAll();
            OutputView.display(cars);
        }
    }
}
