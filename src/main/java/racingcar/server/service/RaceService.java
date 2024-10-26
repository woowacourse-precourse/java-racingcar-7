package racingcar.server.service;

import static racingcar.server.model.position.Position.ON_START_LINE;
import static racingcar.server.model.race.Lap.ONE;

import java.util.ArrayList;
import java.util.List;
import racingcar.server.model.car.Car;
import racingcar.server.model.car.Cars;
import racingcar.server.model.car.MyProgress;
import racingcar.server.model.dashboard.DashBoard;
import racingcar.server.model.race.Lap;
import racingcar.server.model.race.Race;

public class RaceService {

    public Cars registerCars(final long lapCount, final List<String> carNames) {
        List<Car> cars = new ArrayList<>();
        for (String carName : carNames) {
            Lap lap = Lap.from(lapCount);
            MyProgress myProgress = MyProgress.from(lap, ON_START_LINE);
            Car car = Car.from(carName, myProgress);
            cars.add(car);
        }
        return Cars.of(cars);
    }

    public DashBoard startRace(final Lap lap, final Cars cars) {
        Race race = Race.from(lap);
        DashBoard dashBoard = DashBoard.from(cars);
        while (race.isUnderway()) {
            cars.move();
            dashBoard.offerLapChart();
            race.countDownRemainingLapCount(ONE);
        }
        return dashBoard;
    }
}
