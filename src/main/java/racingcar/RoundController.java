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
        Judge judge = new Judge();
        int roundNumber = inputView.inputRounds();

        for (String carName : carNameList) {
            Car car = new Car(carName);
            car.move(roundNumber);
        }
        judge.judgeWinner(Car.getCarList());

        outputView.outputWinnerList(Judge.getWinnerList());
    }

    public static void main(String[] args) {
        InputView inputView1 = new InputView();
        OutputView outputView1 = new OutputView();

        RoundController controller = new RoundController(inputView1, outputView1);
        controller.gameStart();

    }
}
