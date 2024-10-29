package racingcar.app.server.service;

import static racingcar.app.server.model.race.Lap.ONE;

import java.util.ArrayList;
import java.util.List;
import racingcar.app.server.model.car.Car;
import racingcar.app.server.model.car.Cars;
import racingcar.app.server.model.car.MyProgress;
import racingcar.app.server.model.dashboard.DashBoard;
import racingcar.app.server.model.location.Distance;
import racingcar.app.server.model.race.Lap;
import racingcar.app.server.model.race.Race;

public class RaceService {

    public Cars registerCars(final long lapCount, final List<String> carNames) {
        List<Car> cars = new ArrayList<>();
        for (String carName : carNames) {
            Lap lap = Lap.from(lapCount);
            MyProgress myProgress = MyProgress.from(lap, Distance.ZERO);
            Car car = Car.of(carName, myProgress);
            cars.add(car);
        }
        return Cars.of(cars);
    }

    public DashBoard startRace(final Lap lap, final Cars cars) {
        Race race = Race.from(lap);
        DashBoard dashBoard = DashBoard.from(cars);
        while (race.isUnderway()) {
            cars.move();
            dashBoard.addLapChart();
            race.countDownRemainingLapCount(ONE);
        }
        return dashBoard;
    }
}
