package racingcar.common;

import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;

public class RealRandom implements Random{
	@Override
	public int pickRandomNumber() {
		return Randoms.pickNumberInList(List.of(0, 1, 2, 3, 4, 5, 6, 7, 8, 9));
	}
}
