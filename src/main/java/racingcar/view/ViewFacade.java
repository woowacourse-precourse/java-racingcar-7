package racingcar.view;

import java.util.List;
import racingcar.model.Car;
import racingcar.model.Cars;

public class ViewFacade {
    private final InputView inputView;
    private final OutputView outputView;

    public ViewFacade(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    // InputView 메서드 호출
    public String getCarNames() {
        return inputView.getCarNames();
    }

    public String getCount() {
        return inputView.getCount();
    }

    // OutputView 메서드 호출
    public void showResultMessage() {
        outputView.showResultMessage();
    }

    public void showRoundResult(Cars cars) {
        outputView.showRoundResult(cars);
    }

    public void showWinners(List<Car> winners) {
        outputView.showWinners(winners);
    }
}
