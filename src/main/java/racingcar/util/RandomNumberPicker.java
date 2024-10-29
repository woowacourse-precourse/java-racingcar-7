package racingcar.util;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.config.RaceConfig;

public class RandomNumberPicker {
	private RandomNumberPicker() {

	}

	public static int pickNumber() {
		return Randoms.pickNumberInRange(
			RaceConfig.RANDOM_NUMBER_START.getNumber(),
			RaceConfig.RANDOM_NUMBER_END.getNumber()
		);
	}
}
