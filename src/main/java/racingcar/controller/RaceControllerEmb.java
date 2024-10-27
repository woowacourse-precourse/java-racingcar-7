package racingcar.controller;

import racingcar.controller.IO.InputController;
import racingcar.controller.IO.OutputController;
import racingcar.model.RacingCar;
import racingcar.service.factory.CarFactory;
import racingcar.service.evaluator.WinnerEvaluator;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class RaceControllerEmb implements RaceController {
    private List<RacingCar> racingCars = new ArrayList<>();
    private final OutputController outputController;
    private final InputController inputController;
    private final RacingCarController racingCarController;
    private final CarFactory carFactory;
    private final WinnerEvaluator winnerEvaluator;
    private Long currentRound = 0L;
    private Long totalRound = 0L;
    public RaceControllerEmb(OutputController outputController, InputController inputController,CarFactory carFactory,RacingCarController racingCarController,WinnerEvaluator winnerEvaluator) {
        this.outputController = outputController;
        this.inputController = inputController;
        this.carFactory = carFactory;
        this.racingCarController = racingCarController;
        this.winnerEvaluator = winnerEvaluator;
    }

    @Override
    public void readyForRace(){
        outputController.requestUserCarsInput();
        this.racingCars = carFactory.createCars(inputController.getCarsInput());
        outputController.requestUserRoundInput();
        this.totalRound = inputController.getRoundInput();
    }

    @Override
    public void advanceCars(){
        if(isFinished()) return;
        racingCars.forEach(racingCarController::moveForward);
        currentRound++;
    }

    @Override
    public boolean isFinished(){
        return Objects.equals(currentRound, totalRound);
    }

    @Override
    public void announceWinner(){
        outputController.printWinner(racingCars);
    }
}
