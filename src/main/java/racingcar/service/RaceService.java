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

    public Cars registerCars(final String lapCount, final List<String> carNames) {
        List<Car> cars = carNames.stream()
                .map(name -> Car.from(name, MyProgress.from(Lap.from(lapCount), Position.initiate())))
                .toList();
        return Cars.of(cars);
    }

    public DashBoard startRace(final Lap lap, final Cars cars) {
        Race race = Race.from(lap);
        DashBoard dashBoard = DashBoard.from(cars);
        while (race.isUnderway()) { // is underway : 실제 F1 경기에서 경기중을 상태를 표현하는 단어
            cars.move();
            dashBoard.offerLapChart();
            race.moveToNextLap();
        }
        return dashBoard;
    }
}
