package racingcar.service;

import racingcar.model.Car;
import racingcar.model.CarRacingGame;
import racingcar.view.RacingOutputView;

import java.util.List;

public class RacingService {
    public List<Car> carRacingGameStart(CarRacingGame carRacingGame) {
        List<Car> carList = carRacingGame.getCarList();
        for (int i = 0; i < carRacingGame.getTryCount(); i++) {
            for (Car car : carList) {
                car.move();
            }
            RacingOutputView.printRacingResult(carList);
        }
        return carList;
    }
}
