package racingcar.race;

import camp.nextstep.edu.missionutils.Console;
import racingcar.car.Cars;
import racingcar.util.IOValidator;

public class Race {
	private static final String NAMES_SEPARATOR = ",";

	public void start() {
		String[] players = readPlayers();
		Cars cars = new Cars(players);

		int totalRound = readRound();
		for (int round = 0; round < totalRound; round++) {
			cars.run();
		}
	}

	private String[] readPlayers() {
		System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");

		String strPlayers = Console.readLine();
		IOValidator.validateContainsSeparator(strPlayers);

		return strPlayers.split(NAMES_SEPARATOR);
	}

	private int readRound() {
		System.out.println("시도할 횟수는 몇 회인가요?");
		String strRound = Console.readLine();
		IOValidator.validateNaturalNumber(strRound);
		return Integer.parseInt(strRound);
	}
}
