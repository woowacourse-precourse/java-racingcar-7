package racingcar.view.console;

import camp.nextstep.edu.missionutils.Console;
import racingcar.dto.CarNamesInput;
import racingcar.view.InputView;

public class ConsoleInputView implements InputView {
	public CarNamesInput readCarNames() {
		String carNames = Console.readLine();
		return new CarNamesInput(carNames.trim());
	}
}
