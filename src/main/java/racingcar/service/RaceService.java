package racingcar.service;

import java.util.ArrayList;
import java.util.List;
import racingcar.model.car.Car;
import racingcar.model.car.Cars;
import racingcar.model.car.MyProgress;
import racingcar.model.dashboard.DashBoard;
import racingcar.model.race.Lap;
import racingcar.model.race.Race;

public class RaceService {

    public Cars registerCars(final long lapCount, final List<String> carNames) {
        List<Car> cars = new ArrayList<>();
        for (String carName : carNames) {
            Lap lap = Lap.from(lapCount);
            MyProgress myProgress = MyProgress.from(lap);
            Car car = Car.from(carName, myProgress);
            cars.add(car);
        }
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
