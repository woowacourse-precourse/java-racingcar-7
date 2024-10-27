package racingcar.controller;

import racingcar.domain.Cars;
import racingcar.domain.Winners;
import racingcar.handler.NameRequestHandler;
import racingcar.handler.NumberRequestHandler;
import racingcar.view.WinnersView;

public class RacingController {

    private final NameRequestHandler nameRequestHandler;
    private final NumberRequestHandler numberRequestHandler;
    private final WinnersView winnersView;

    public RacingController() {
        nameRequestHandler = new NameRequestHandler();
        numberRequestHandler = new NumberRequestHandler();
        winnersView = new WinnersView();
    }

    public void run() {
        String[] names = nameRequestHandler.getNames();
        int moveNum = numberRequestHandler.getNumber();
        Cars cars = Cars.from(names);

        cars.racing(moveNum);
        winnersView.show(new Winners(cars.determineWinner()));
    }

}
