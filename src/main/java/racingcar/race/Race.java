package racingcar.race;

import camp.nextstep.edu.missionutils.Console;
import racingcar.car.Cars;
import racingcar.util.IOValidator;

public class Race {
	private static final String NAMES_SEPARATOR = ",";

	public void start() {
		String[] players = readPlayers();
		Cars cars = new Cars(players);
	}

	private String[] readPlayers() {
		System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");

		String strPlayers = Console.readLine();
		IOValidator.validateContainsSeparator(strPlayers);

		return strPlayers.split(NAMES_SEPARATOR);
	}
}
