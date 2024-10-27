package racingcar.Controller;

import racingcar.Model.Car;
import racingcar.Service.CarService;
import racingcar.Service.GameService;
import racingcar.View.InputView;

import java.util.ArrayList;

public class RacingcarRameController {
    GameService gameService=new GameService();
    CarService carService=new CarService();
    public void GameStart(){
        String CarNames=InputView.Car_names();
        int Count= InputView.Game_count();
        ArrayList<Car> cars=gameService.Separate_Carnames(CarNames);
        carService.Racing_Car(cars,Count);
    }
}
