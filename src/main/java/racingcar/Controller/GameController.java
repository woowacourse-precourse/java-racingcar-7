package racingcar.Controller;

import static racingcar.view.OutputView.*;
import static racingcar.view.OutputView.printNewLine;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import racingcar.model.Car;
import racingcar.model.CarGroup;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class GameController {
    public void run() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String carNames = Console.readLine();
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
    }

    private void validateTryCount(int tryCount) {
        if (tryCount < 1) {
            throw new IllegalArgumentException("시도 횟수는 양수여야 합니다.");
        }
    }
}
