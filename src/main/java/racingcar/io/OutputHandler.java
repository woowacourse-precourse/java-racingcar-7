package racingcar.io;

import java.util.List;

public class OutputHandler {

	 public void showStartMessage() {
		System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
	}

	public void showTryMessage() {
		System.out.println("시도할 횟수는 몇 회인가요?");
	}

	public void showOnlyOneInputWinner(List<String> carNames) {
		System.out.println("최종 우승자 : " + carNames.get(0));
	}

	 public void showWinner(List<String> winner) {
		System.out.print("최종 우승자 : ");

		if(winner.size() == 1){	// 우승자가 1명인 경우
			System.out.println(winner.get(0));
			return;
		}
		// 우승자가 여러 명인 경우
		System.out.println(String.join(", ", winner));
	}

	public void showStartResultMessage() {
		showBlankSpace();
		System.out.println("실행 결과");
	}

	public void showBlankSpace() {
		System.out.println();
	}
}
