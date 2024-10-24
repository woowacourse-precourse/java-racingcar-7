package racingcar.Controller;

import racingcar.Model.GameCars;
import racingcar.View.StartView;

public class InputController {


    public static GameCars setCars(){
        String[] car_names= StartView.inputCarInfo().split(",");
        return new GameCars(car_names);
    }

    public static int setGameCount(){
        return Integer.parseInt(StartView.inputNumOfMatch());
    }
}