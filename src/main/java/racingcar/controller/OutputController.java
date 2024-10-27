package racingcar.controller;

import racingcar.model.Car;
import racingcar.view.ResultView;
import racingcar.view.WinnerView;

import java.util.List;

public class OutputController {

    private final ResultView resultView;
    private final WinnerView winnerView;

    public OutputController(ResultView resultView, WinnerView winnerView) {
        this.resultView = resultView;
        this.winnerView = winnerView;
    }

    public void getOutputView(final List<Car> carList, final int inputTurns, final List<String> winners) {
        System.out.println("실행 결과");
        resultView.printResultView(carList, inputTurns);
        winnerView.printWinnerView(winners);
    }
}
