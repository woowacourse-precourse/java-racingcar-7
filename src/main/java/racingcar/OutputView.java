package racingcar;

import java.util.ArrayList;
import java.util.List;

public class OutputView {
	public static void promptForCarName() {
		System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
	}

	public static void promptForIterationCount() {
		System.out.println("시도 횟수는 몇 회인가요?");
	}

	public static void printResultTitle() {
		System.out.println();
		System.out.println("실행 결과");
	}

	public static void printResultData(List<String> carNames, List<Long> carPosition) {
		for (int i = 0; i < carNames.size(); i++) {
			try {
				int repeatCount = Math.toIntExact(carPosition.get(i));
				System.out.printf("%s : %s%n", carNames.get(i), "-".repeat(repeatCount));
			} catch (ArithmeticException e) {
				throw new IllegalArgumentException("The input value exceeds the maximum value for an int");
			}
		}

		System.out.println();
	}

	public static void printWinners(List<String> winners) {
		System.out.printf("최종 우승자 : %s", String.join(", ", winners));
	}
}
