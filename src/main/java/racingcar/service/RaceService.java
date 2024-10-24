package racingcar.service;

import java.util.List;
import racingcar.model.car.Car;
import racingcar.model.car.Cars;
import racingcar.model.car.MyProgress;
import racingcar.model.dashboard.DashBoard;
import racingcar.model.race.Lap;
import racingcar.model.race.Position;
import racingcar.model.race.Race;

public class RaceService {

    public Cars registerCars(final List<String> carNames, final String lapCount) {
        List<Car> cars = carNames.stream()
                .map(name -> Car.from(name, MyProgress.from(Lap.of(lapCount), Position.initiate())))
                .toList();
        return Cars.of(cars);
    }

    public DashBoard startRace(Race race, Cars cars) {
        DashBoard dashBoard = DashBoard.of(cars);
        while (race.isUnderway()) {
            cars.move();
            // TODO : Print out lap chart
            dashBoard.offerLapChart();
            race.moveToNextLap();
        }
        return dashBoard;
    }
}
