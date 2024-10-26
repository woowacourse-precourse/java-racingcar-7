package racingcar.Controller;

import static racingcar.view.InputView.inputCarNames;
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

        System.out.println("시도할 횟수는 몇 회인가요?");
        int tryCount = Integer.parseInt(Console.readLine());
        validateTryCount(tryCount);

        for (int i = 0; i < tryCount; i++) {
            carGroup.move();
            carGroup.getCars()
                    .forEach(OutputView::printProgress);
            printNewLine();
        }

        List<Car> winners = carGroup.getWinners();
        printWinners(winners);
    }

    private void validateTryCount(int tryCount) {
        if (tryCount < 1) {
            throw new IllegalArgumentException("시도 횟수는 양수여야 합니다.");
        }
    }
}
