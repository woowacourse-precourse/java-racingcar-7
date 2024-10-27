package racingcar.controller;

import java.util.ArrayList;
import java.util.List;
import racingcar.view.RacingGameView;

public class RacingGameController {

    RacingGameView view = new RacingGameView();

    public void run(){
        view.carNameInputMessage();
        createCarInstances();
    }

    private List<String> createCarInstances(){
        List<String> carNames = new ArrayList<>(List.of(view.getCarNames().split(",")));
        return carNames;
    }

}
