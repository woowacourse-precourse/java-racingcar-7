package racingcar;

import  camp.nextstep.edu.missionutils.Randoms;

public class RandomNumbersPicker {

    final static Integer MIN_PICK_NUMBER = 0;
    final static Integer MAX_PICK_NUMBER = 9;

    public static Integer pickRandomNumbers() {
        return Randoms.pickNumberInRange(MIN_PICK_NUMBER, MAX_PICK_NUMBER);
    }
}
