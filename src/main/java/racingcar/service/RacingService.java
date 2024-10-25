package racingcar.service;

import racingcar.model.Car;
import racingcar.model.RacingGame;

import java.util.List;

public class RacingService {
    private RacingGame racingGame;

    public RacingService() {
    }

    public RacingGame initGame(List<Car> cars, int num){
        return new RacingGame(cars,num);
    }

    public List<Car> playOneGame(){
        List<Car> carList = racingGame.getCarList();

        for (Car car : carList) {
            car.move();
        }

        return carList;
    }

    public RacingGame getRacingGame() {
        return racingGame;
    }
}
