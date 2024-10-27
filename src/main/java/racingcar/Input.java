package racingcar;

import camp.nextstep.edu.missionutils.Console;

public class Input {

	private static final String CAR_NAMES_REQUEST_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
	private static final String MOVE_ATTEMPTS_REQUEST_MESSAGE = "시도할 횟수는 몇 회인가요?";

	public static CarList readNames() {
		System.out.println(CAR_NAMES_REQUEST_MESSAGE);

		return separateNames(Console.readLine());
	}

	public static CarList separateNames(String namesStr) {
		String[] names = namesStr.split(",");

		return new CarList(names);
	}

	public static int readAttemptNumber() {
		System.out.println(MOVE_ATTEMPTS_REQUEST_MESSAGE);

		return validateAttemptNumber(Console.readLine());
	}

	public static int validateAttemptNumber(String numStr) {

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
