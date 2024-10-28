package racingcar.controller;

import racingcar.domain.Car;
import racingcar.domain.CarGroup;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingGame {

    private final InputView inputView;
    private final OutputView outputView;

    public RacingGame(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run(){
        CarGroup carGroup = new CarGroup(inputView.readCars());
        int roundCount = inputView.readRoundCount();
        for(int i = 0; i<roundCount; i++){
            carGroup.moveCars();
            outputView.printRoundResult(carGroup);
        }

        outputView.printWinners(carGroup.getWinners());
    }

}
