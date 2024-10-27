package racingcar.controller;

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
            carNameValidator(name);
            cars.add(new Car(name));
        }
    }

    private void carNameValidator(String name){
        if(name.isEmpty() || name.length()>5 || name.isBlank()) {
            throw new IllegalArgumentException("자동차 이름은 1글자 이상 5글자 이하여야합니다.");
        }
    }

}
