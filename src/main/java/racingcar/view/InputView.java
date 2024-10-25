package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
	public static final String ENTER_CAR_NAMES = "경주할 자동차 이름을 입력하세요. (이름은 쉼표(,) 기준으로 구분)";
	public static final String COMMA = ",";

	public String[] getCarNames() {
		System.out.println(ENTER_CAR_NAMES);
		String input = Console.readLine();
		if (input.isBlank()) {
			throw new IllegalArgumentException("이름은 비어있을 수 없습니다.");
		}
		return input.split(COMMA);
	}
}
