package racingcar;

import camp.nextstep.edu.missionutils.Console;
import racingcar.view.InputView;

public class RacingGame {
    public void race() {
        InputView.promptForInputCars();
        String cars = Console.readLine();
        InputView.promptForInputTryCount();
        int tryCount = Integer.parseInt(Console.readLine());
    }
}
