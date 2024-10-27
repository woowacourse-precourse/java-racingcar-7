package racingcar.view;

import java.util.ArrayList;

import camp.nextstep.edu.missionutils.Console;
import racingcar.util.Parser;
import racingcar.util.Validator;

public class InputView {

	private final Validator validator;
	private final Parser parser;

	private static final String CAR_NAMES_INPUT_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
	private static final String RACE_COUNT_INPUT_MESSAGE = "시도할 횟수는 몇 회인가요?";

	public InputView(Validator validator, Parser parser) {
		this.validator = validator;
		this.parser = parser;
	}

	public ArrayList<String> getCarNames() {
		System.out.println(CAR_NAMES_INPUT_MESSAGE);
		String input = Console.readLine();
		ArrayList<String> carNames = parser.stringToList(input);
		validator.checkCarNames(carNames);
		return carNames;
	}
}
