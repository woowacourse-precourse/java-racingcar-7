package racingcar.controller;

import racingcar.domain.Cars;
import racingcar.handler.NameRequestHandler;
import racingcar.handler.NumberRequestHandler;

public class RacingController {

    private final NameRequestHandler nameRequestHandler;
    private final NumberRequestHandler numberRequestHandler;

    public RacingController() {
        nameRequestHandler = new NameRequestHandler();
        numberRequestHandler = new NumberRequestHandler();
    }

    public void run() {
        String[] names = nameRequestHandler.getNames();
        int number = numberRequestHandler.getNumber();
        Cars cars = new Cars(names);
    }
}
