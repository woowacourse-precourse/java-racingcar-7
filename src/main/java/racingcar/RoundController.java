package racingcar;


import java.util.ArrayList;

public class RoundController {
    private final InputView inputView;
    private final OutputView outputView;

    public RoundController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    void gameStart(){
        ArrayList<String> carNameList = InputHandler.handleCarNames(inputView);
        int roundNumber = inputView.inputRounds();
        Judge judge = new Judge();

        for (String carName : carNameList) {
            Car car = new Car(carName);
            car.move(inputView);
        }
        judge.judgeWinner(Car.getCarList());

        outputView.outputWinnerList(Judge.getWinnerList());
    }

}
