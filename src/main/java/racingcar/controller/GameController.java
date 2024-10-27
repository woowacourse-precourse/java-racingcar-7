package racingcar.controller;

import racingcar.model.RacingCar;
import racingcar.utils.StringConvertor;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class GameController {

    public void startGame(){
        OutputView.requestCarNames();
        String registerdCars = InputView.inputCarName();

        OutputView.requestTrialCount();
        int trialCount = StringConvertor.toInt(InputView.inputTrialCount());

        RacingCar racingCar = new RacingCar(StringConvertor.toCarList(registerdCars));

        while(trialCount > 0){
            racingCar.moving();
            OutputView.printRacing(racingCar.getCars());
            trialCount--;
        }

        OutputView.printWinner(racingCar.getWinner());
    }

}
