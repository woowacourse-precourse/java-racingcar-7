package racingcar.domain.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.domain.model.ErrorMessage;
import racingcar.util.UTF8ConsoleWriter;

public class RaceView {

	private static final String CAR_NAMES_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
	private static final String RACE_LAP_MESSAGE = "시도할 횟수는 몇 회인가요?";
	private static final String START_LAP_MESSAGE = "\n실행 결과";
	private static final String RACE_RESULT_MESSAGE = "최종 우승자 : ";

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

	public void displayCarPosition(String name, int position) {
		UTF8ConsoleWriter.println(name + " : " + "-".repeat(Math.max(0, position)));
	}

	public void displayWinner(String winner) {
		UTF8ConsoleWriter.println(RACE_RESULT_MESSAGE + winner);
	}

	public void startLap() {
		UTF8ConsoleWriter.println(START_LAP_MESSAGE);
	}

	public void nextLap() {
		UTF8ConsoleWriter.print("\n");
	}
}
