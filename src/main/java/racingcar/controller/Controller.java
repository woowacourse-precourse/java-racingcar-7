package racingcar.controller;

import static racingcar.View.constant.OutputMessage.START_COUNT;
import static racingcar.View.constant.OutputMessage.START_MESSAGE;

import java.util.List;
import racingcar.View.InputView;
import racingcar.View.OutputView;
import racingcar.domain.Car;
import racingcar.domain.CarImpl;
import racingcar.domain.Parser;
import racingcar.domain.ScoreBoard;

public class Controller {
    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();
    private final Parser parser = new Parser();

    public void start() {
        outputView.printMessage(START_MESSAGE);
        List<String> carNames = getCarNames();

        outputView.printMessage(START_COUNT);
        int tryCount = getTryCount();

        List<Car> carList = getCarList(carNames);
        ScoreBoard scoreBoard = ScoreBoard.from(carList);
    }

    public List<String> getCarNames() {
        return parser.parse(inputView.inputString());
    }

    public int getTryCount() {
        return parser.parseInt(inputView.inputString());
    }

    public List<Car> getCarList(List<String> carNames) {
        return carNames.stream()
                .map(CarImpl::from)
                .toList();
    }
}
