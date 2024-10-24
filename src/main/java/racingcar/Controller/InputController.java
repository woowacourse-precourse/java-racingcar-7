package racingcar.Controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import racingcar.Model.Car;
import racingcar.Model.GameCars;
import racingcar.View.EndView;
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