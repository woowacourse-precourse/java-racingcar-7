package racingcar.service;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.domain.Car;

public class MovementCondition {
	private int getRandomNumber() {
		return Randoms.pickNumberInRange(0, 9);
	}

	private boolean judgmentNumber(int number) {
		return number < 6;
	}

	public void movementBasedOnJudgment(Car car) {
		if(judgmentNumber(getRandomNumber())) {
			car.movement();
		}
	}
}
