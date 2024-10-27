package racingcar.service;

import racingcar.controller.*;
import racingcar.service.evaluator.WinnerEvaluator;
import racingcar.service.evaluator.WinnerEvaluatorEmb;
import racingcar.service.factory.CarFactory;
import racingcar.service.factory.CarFactoryEmb;

public class RaceControllerFactoryEmb implements RaceControllerFactory {
    @Override
    public RaceController createRaceController() {
        OutputController outputController = new OutputControllerEmb();
        InputController inputController = new InputControllerEmb();
        CarFactory carFactory = new CarFactoryEmb();
        RacingCarController racingCarController = new RacingCarControllerEmb();
        WinnerEvaluator winnerEvaluator = new WinnerEvaluatorEmb();

        return new RaceControllerEmb(outputController, inputController, carFactory, racingCarController, winnerEvaluator);
    }
}
