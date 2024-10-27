package racingcar.Service;

import racingcar.Domain.Car;
import racingcar.Dto.CarData;
import racingcar.Dto.RoundResult;

import java.util.ArrayList;
import java.util.List;

public class RacingCarService {
    public RoundResult runRound(List<Car> cars) {
        List<CarData> carDataList = new ArrayList<>();
        for (Car car : cars) {
            car.move();
            CarData carData = car.getCurrentCarData();
            carDataList.add(carData);
        }
        //cars.forEach(Car::move);
        return new RoundResult(carDataList);
    }
}
