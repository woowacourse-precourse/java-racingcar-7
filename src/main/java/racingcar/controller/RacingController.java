package racingcar.controller;

import racingcar.domain.Cars;
import racingcar.domain.Winners;
import racingcar.handler.NameRequestHandler;
import racingcar.handler.NumberRequestHandler;

import java.util.List;

import static racingcar.view.WinnersView.showWinners;

public class RacingController {

    private final NameRequestHandler nameRequestHandler;
    private final NumberRequestHandler numberRequestHandler;

    public RacingController() {
        nameRequestHandler = new NameRequestHandler();
        numberRequestHandler = new NumberRequestHandler();
    }

    public void run() {
        List<String> names = nameRequestHandler.getNames();
        int moveNum = numberRequestHandler.getNumber();
        Cars cars = Cars.from(names);

        cars.racing(moveNum);
        showWinners(new Winners(cars.determineWinner()));
    }

}
