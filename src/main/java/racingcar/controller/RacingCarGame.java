package racingcar.controller;

import racingcar.Util;
import racingcar.model.Car;
import racingcar.model.CarList;
import racingcar.validator.Validator;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.ArrayList;

public class RacingCarGame {
    private CarList carList;
    private int roundNumber;
    private Validator validator=new Validator();

    public void run(){

        String inputCarNames = InputView.setCarName();
        ArrayList<String> carNames = validateCarNames(inputCarNames);

        String inputRoundNumber = InputView.setRoundNumber();
        validateRoundNumber(inputRoundNumber);

        setCarList(carNames);
        OutputView.printResultMesseage();

        for (int i = 0; i < roundNumber; i++) {
            OutputView.printPlayResult(carList.play());
        }

        OutputView.printWinnerResult(carList.winnerResult());
    }

    private ArrayList<String> validateCarNames(String inputCarNames) {
        validator.isRightNamesString(inputCarNames);
        ArrayList<String> carNames = Util.toArrayList(inputCarNames);
        validator.isRightNameSize(carNames);
        validator.isNotDuplicate(carNames);
        return carNames;
    }

    private void validateRoundNumber(String inputRoundNumber) {
        validator.isRightRoundNumber(inputRoundNumber);
        roundNumber = Util.toInt(inputRoundNumber);
    }


    private void setCarList(ArrayList<String> carNames) {
        carList = new CarList();
        for (String car : carNames) {
            carList.addCar(new Car(car));
        }
    }
}
