package racingcar.view;

import java.util.Arrays;
import java.util.List;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
	public List<String> readCarNames() {
		System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,) 기준으로 구분)");
		String input = Console.readLine();
		return Arrays.asList(input.split(","));
	}

	public int readTries() {
		System.out.println("시도할 회수는 몇회인가요?");
		String input = Console.readLine();
		validateNumber(input);
		return Integer.parseInt(input);
	}

	private void validateNumber(String input) {
		try {
			int number = Integer.parseInt(input);
			if (number <= 0) {
				throw new IllegalArgumentException("시도 횟수는 1 이상이어야 합니다.");
			}
		} catch (NumberFormatException e) {
			throw new IllegalArgumentException("유효한 숫자를 입력해주세요.");
		}
	}
}
