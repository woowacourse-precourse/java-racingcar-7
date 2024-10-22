package racingcar.domain.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.domain.model.ErrorMessage;
import racingcar.util.UTF8ConsoleWriter;

public class RaceView {

	private static final String CAR_NAMES_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";

	private static final String RACE_LAP_MESSAGE = "시도할 횟수는 몇 회인가요?";

	public String receiveCarNames() {
		UTF8ConsoleWriter.println(CAR_NAMES_MESSAGE);
		return Console.readLine();
	}

	public int receiveRaceLap() {
		UTF8ConsoleWriter.println(RACE_LAP_MESSAGE);
		try {
			return Integer.parseInt(Console.readLine());
		} catch (NumberFormatException e) {
			throw new IllegalArgumentException(ErrorMessage.NUMBER_FORMAT_ERROR.getMessage());
		}
	}
}
