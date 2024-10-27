package racingcar.Controller;

import static racingcar.view.InputView.inputCarNames;
import static racingcar.view.InputView.inputTryCount;
import static racingcar.view.OutputView.printNewLine;
import static racingcar.view.OutputView.printWinners;

import java.util.List;
import racingcar.model.Car;
import racingcar.model.CarGroup;
import racingcar.view.OutputView;

public class GameController {

    public void run() {
        List<String> carNames = inputCarNames();
        CarGroup carGroup = new CarGroup(carNames);

        int tryCount = inputTryCount();
        for (int i = 0; i < tryCount; i++) {
            carGroup.move();
            carGroup.getCars().forEach(OutputView::printProgress);
            printNewLine();
        }

        List<Car> winners = carGroup.getWinners();
        printWinners(winners);
    }
}
