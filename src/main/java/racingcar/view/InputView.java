package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.dto.CarNamesInput;

public class InputView {

	public CarNamesInput readCarNames() {
		String CarNames = Console.readLine();
		return new CarNamesInput(CarNames.trim());
	}
}
