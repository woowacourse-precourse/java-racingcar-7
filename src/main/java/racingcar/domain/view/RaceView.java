package racingcar.domain.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.util.UTF8ConsoleWriter;

public class RaceView {

	private static final String CAR_NAMES_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";

	public String receiveCarNames() {
		UTF8ConsoleWriter.println(CAR_NAMES_MESSAGE);
		return Console.readLine();
	}

}
