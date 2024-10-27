package racingcar.controller.race;

import racingcar.controller.IO.InputController;
import racingcar.controller.IO.OutputController;
import racingcar.model.RacingCar;
import racingcar.service.factory.CarFactory;
import racingcar.service.evaluator.WinnerEvaluator;
import racingcar.view.ResultViewer;

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
    private final ResultViewer resultViewer;
    private Long currentRound = 0L;
    private Long totalRound = 0L;

    public RaceControllerEmb(OutputController outputController, InputController inputController,CarFactory carFactory,RacingCarController racingCarController,WinnerEvaluator winnerEvaluator,ResultViewer resultViewer) {
        this.outputController = outputController;
        this.inputController = inputController;
        this.carFactory = carFactory;
        this.racingCarController = racingCarController;
        this.winnerEvaluator = winnerEvaluator;
        this.resultViewer = resultViewer;
    }

    @Override
    public void readyForRace(){
        outputController.requestUserCarsInput();
        this.racingCars = carFactory.createCars(inputController.getCarsInput());
        outputController.requestUserRoundInput();
        this.totalRound = inputController.getRoundInput();
        resultViewer.output("\n");
    }

    @Override
    public void advanceCars() {
        racingCars.forEach(racingCarController::moveForward);
    }

    @Override
    public void broadcastRace(){
        if(currentRound == 0) resultViewer.output("실행 결과\n");
        while(!isFinished()) {
            advanceCars();
            outputController.printCarsCurrentDistance(racingCars);
            resultViewer.output("\n");
            currentRound++;
        }
    }

    @Override
    public boolean isFinished(){
        return Objects.equals(currentRound, totalRound);
    }

    @Override
    public void announceWinner(){
        outputController.printWinner(winnerEvaluator.determineWinners(racingCars));
    }

    @Override
    public List<RacingCar> getRacingCars() {
        return racingCars;
    }
}
