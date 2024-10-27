package racingcar.controller;


import java.util.ArrayList;
import racingcar.view.InputView;
import racingcar.view.OutputView;
import racingcar.model.Car;
import racingcar.model.Judge;

public class RoundController {
    private final InputView inputView;
    private final OutputView outputView;

    public RoundController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void gameStart(){
        ArrayList<String> carNameList = InputHandler.handleCarNames(inputView);
        Judge judge = new Judge();
        int roundNumber = inputView.inputRounds();

        for (String carName : carNameList) {
            Car car = new Car(carName);
            car.move(roundNumber);
        }

        judge.judgeMaxLength(Car.getCarList());
        judge.judgeWinner(Car.getCarList());

        outputView.outputProcess(roundNumber);
        outputView.outputWinnerList(Judge.getWinnerList());
    }

}
