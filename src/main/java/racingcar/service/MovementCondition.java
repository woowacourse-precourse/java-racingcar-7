package racingcar.service;

import static racingcar.common.Constants.END_NUMBER;
import static racingcar.common.Constants.INIT_NUMBER;
import static racingcar.common.Constants.MOVEMENT_CONDITION_INIT_NUMBER;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.domain.Car;

public class MovementCondition {
	private static final MovementCondition INSTANCE = new MovementCondition();

	private MovementCondition() {}

	private int getRandomNumber() {
		return Randoms.pickNumberInRange(INIT_NUMBER, END_NUMBER);
	}

	private boolean judgmentNumber(int number) {
		return number >= MOVEMENT_CONDITION_INIT_NUMBER;
	}

	public void movementBasedOnJudgment(Car car) {
		if(judgmentNumber(getRandomNumber())) {
			car.movement();
		}
	}

	public static MovementCondition getInstance() {
		return INSTANCE;
	}
}
