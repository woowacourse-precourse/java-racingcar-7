package racingcar.io;

import java.util.List;

import racingcar.domain.car.CarStatus;
import racingcar.domain.car.Cars;

public class OutputHandler {
	private static final String PROMPT_CAR_NAMES = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
	private static final String PROMPT_ATTEMPT_COUNT = "시도할 횟수는 몇 회인가요?";
	private static final String PROMPT_GAME_STATUS = "실행 결과";
	private static final String PROMPT_GAME_WINNERS = "최종 우승자 : ";

	private OutputHandler() {
	}

	public static OutputHandler create() {
		return new OutputHandler();
	}

	public void promptForCarNames() {
		System.out.println(PROMPT_CAR_NAMES);
	}

	public void promptForAttemptCount() {
		System.out.println(PROMPT_ATTEMPT_COUNT);
	}

	public void promptGameResult() {
		System.out.println();
		System.out.println(PROMPT_GAME_STATUS);
	}

	public void promptGameStatus(Cars cars) {
		List<CarStatus> carsStatus = cars.getStatus();
		carsStatus.forEach(carStatus -> System.out.println(carStatus.getCarName() + " : " + "-".repeat(carStatus.getMoveDistance())));
		System.out.println();
	}

	public void promptGameWinners(List<String> winners) {
		System.out.print(PROMPT_GAME_WINNERS + String.join(", ", winners));
	}
}
