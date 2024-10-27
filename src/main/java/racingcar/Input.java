package racingcar;

import camp.nextstep.edu.missionutils.Console;

public class Input {

	private final String CAR_NAMES_REQUEST_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
	private final String MOVE_ATTEMPTS_REQUEST_MESSAGE = "시도할 횟수는 몇 회인가요?";

	public Car[] readNames() throws IllegalArgumentException {
		System.out.println(CAR_NAMES_REQUEST_MESSAGE);

		return separateNames(Console.readLine());
	}

	private Car[] separateNames(String namesStr) throws IllegalArgumentException {
		String[] names = namesStr.split(",");
		Car[] cars = new Car[names.length];

		for (int i = 0; i < names.length; i++) {
			cars[i] = new Car(names[i]);
		}

		return cars;
	}

	public int readAttemptNumber() throws IllegalArgumentException {
		System.out.println(MOVE_ATTEMPTS_REQUEST_MESSAGE);

		return validateAttemptNumber(Console.readLine());
	}

	public int validateAttemptNumber(String numStr) throws IllegalArgumentException {

		if (!numStr.matches("\\d+")) {
			throw new IllegalArgumentException("유효한 숫자가 아닙니다.");
		}

		int attemptNumber = Integer.parseInt(numStr);
		if (attemptNumber < 0) {
			throw new IllegalArgumentException("이동 횟수는 음수일 수 없습니다.");
		}

		return attemptNumber;
	}
}
