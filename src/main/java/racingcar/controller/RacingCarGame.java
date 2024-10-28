package racingcar.controller;

import racingcar.Util;
import racingcar.model.Car;
import racingcar.model.CarList;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.ArrayList;

public class RacingCarGame {
    private CarList carList;
    private int roundNumber;

    public void run(){

        String inputCarNames= InputView.setCarName();
        ArrayList<String> carNames= Util.toArrayList(inputCarNames);

        String inputRoundNumber= InputView.setRoundNumber();
        roundNumber=Util.toInt(inputRoundNumber);

        carList=new CarList();
        for (String car : carNames) {
            carList.addCar(new Car(car));
        }

        OutputView.printResultMesseage();

        for (int i = 0; i < roundNumber; i++) {
            OutputView.printPlayResult(carList.play());
        }

        OutputView.printWinnerResult(carList.winnerResult());
    }
}
