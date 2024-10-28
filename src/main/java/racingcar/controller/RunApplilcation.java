package racingcar.controller;

import racingcar.model.Car;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class RunApplilcation {
    private List<Car> carList=new ArrayList<>();
    private int tryNumber;

    public void runAppliccation() {
        InputView inputView=new InputView();
        carList=inputView.inputCarList();
        tryNumber = inputView.inputRound();

        Race race=new Race();
        race.nRoundGame(tryNumber,carList);

        CalculateWinner calculateWinner=new CalculateWinner();
        String winnerNames=calculateWinner.calculateWinner(carList);

        OutputView outputView=new OutputView();
        outputView.printWinner(winnerNames);
    }
}
