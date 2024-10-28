package racingcar.view.console;

import camp.nextstep.edu.missionutils.Console;
import racingcar.dto.CarNamesInput;
import racingcar.dto.TryCountInput;
import racingcar.view.InputView;

public class ConsoleInputView implements InputView {
    @Override
    public CarNamesInput readCarNames() {
        String carNames = Console.readLine();
        return new CarNamesInput(carNames.trim());
    }

    @Override
    public TryCountInput readTryCount() {
        String TryCount = Console.readLine();
        return new TryCountInput(TryCount.trim());
    }
}
