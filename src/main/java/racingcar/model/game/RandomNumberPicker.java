package racingcar.model.game;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomNumberPicker implements NumberPicker {
    @Override
    public int pickNumberInRange(int startInclusive, int endInclusive) {
        return Randoms.pickNumberInRange(startInclusive, endInclusive);
    }
}
