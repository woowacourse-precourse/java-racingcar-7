package racingcar.Controller;

import java.util.List;
import racingcar.Model.RacingCar;
import racingcar.Service.RacingGameService;
import racingcar.View.InputView;
import racingcar.View.OutputView;

public class RacingGameController {

    private final OutputView outputView;
    private final InputView inputView;
    private final RacingGameService service;

    public RacingGameController(OutputView outputView, InputView inputView,
        RacingGameService service) {
        this.outputView = outputView;
        this.inputView = inputView;
        this.service = service;
    }

    public void run() {
        outputView.askCarNames();
        List<RacingCar> carList = inputView.inputCarNames();

        outputView.askNumber();
        int number = inputView.inputNumber();
        service.validateNumber(number);

        outputView.printResultMessage();
        service.play(carList, number);
        printRoundResult(carList);

        printGameResult(service.determineWinners(carList));
    }


    private void printRoundResult(List<RacingCar> carList) {
        carList.forEach(OutputView::printBars);
        System.out.println();
    }

    private void printGameResult(List<RacingCar> winners) {
        if(winners.size() > 1) {
            OutputView.printWinners(winners);
        } else {
            OutputView.printOneWinner(winners);
        }
    }
}
