package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.utils.StringUtils;

public class RequestView {
	private static final String INPUT_CAR_NAMES_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
	private static final String INPUT_TRY_COUNT_MESSAGE = "시도할 횟수는 몇 회인가요?";

	public String inputCarNames() {
		System.out.println(INPUT_CAR_NAMES_MESSAGE);
		String input = Console.readLine();
		StringUtils.validateNotEmpty(input);
		return input;
	}

	public int inputTryCount() {
		System.out.println(INPUT_TRY_COUNT_MESSAGE);
		String input = Console.readLine();
		return StringUtils.toNumber(input);
	}
}
