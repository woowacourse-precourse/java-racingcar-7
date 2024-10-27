package racingcar.controller;

import java.sql.Array;
import java.util.ArrayList;
import java.util.List;
import racingcar.model.Car;
import racingcar.view.RacingGameView;

public class RacingGameController {

    RacingGameView view = new RacingGameView();
    List<Car> cars = new ArrayList<>();

    public void run(){
        view.carNameInputMessage();
        createCarInstances();
        view.trialCountInputMessage();

    }

    private void createCarInstances(){
        List<String> carNames = new ArrayList<>(List.of(view.getCarNames().split(",")));
        for(String name:carNames){
            cars.add(new Car(name));
        }
    }

}
