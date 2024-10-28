package racingcar.util.generator;

import camp.nextstep.edu.missionutils.Randoms;

public class BasicRacingCarGameRandomGenerator implements RacingCarGameRandomGenerator {
    @Override
    public int generateRandomNumbers() {
        return Randoms.pickNumberInRange(0, 9);
    }
}
