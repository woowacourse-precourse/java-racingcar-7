package racingcar.controller;

import java.util.List;
import racingcar.model.Racing;
import racingcar.model.RacingCar;
import racingcar.util.StringConvertor;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingGameController {
    private final InputView inputView;
    private final OutputView outputView;

    public RacingGameController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void gameStart() {
        List<RacingCar> cars = receiveCarNames();
        Racing racing = new Racing(cars);

        int numberOfTurn = receiveNumberOfTurn();

        playRace(racing, numberOfTurn);
        announcementWinner(racing);
    }


    private List<RacingCar> receiveCarNames() {
        outputView.requestCarNames();
        return StringConvertor.toCarList(inputView.inputCarNames());
    }

    private int receiveNumberOfTurn() {
        outputView.requestNumberOfTurn();
        return StringConvertor.toInt(inputView.inputNumberOfTurn());
    }

    private void playRace(Racing racing, int numberOfTurn) {
        for (int i = 0; i < numberOfTurn; i++) {
            racing.playTurn();
            outputView.printResultOfTurn(racing.getCars());
        }
    }

    private void announcementWinner(Racing racing) {
        List<RacingCar> winners = racing.judgeWinners();
        outputView.printWinner(winners);
    }
}
