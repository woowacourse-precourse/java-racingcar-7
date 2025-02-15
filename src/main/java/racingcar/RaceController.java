package racingcar;

import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;

public class RaceController {
	private final List<Car> cars;
	private final int tryCount;

	public RaceController(List<Car> cars, int tryCount) {
		this.cars = cars;
		this.tryCount = tryCount;
	}

	public void runRace() {
		for (int i = 0; i < tryCount; i++) {
			playRound();
			OutputView.displayRoundResult(cars);
		}
		OutputView.displayWinners(cars);
	}

	private void playRound() {
		for (Car car : cars) {
			int randomValue = Randoms.pickNumberInRange(0, 9);
			car.move(randomValue);
		}
	}
}
