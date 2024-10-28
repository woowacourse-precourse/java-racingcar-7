package racingcar.Controller;

import racingcar.Model.Car;
import racingcar.Service.CarService;
import racingcar.Service.RaceService;
import racingcar.View.InputView;

import java.util.ArrayList;

public class RacingCarController {

    RaceService raceservice = new RaceService();
    CarService carService = new CarService();
    public void gameStart(){

        String CarNames = InputView.InputCarNames();
        int Count = InputView.InputRounds();

        ArrayList<Car> cars = carService.separateCarNames(CarNames);
        raceservice.raceCar(cars,Count);
    }
}
