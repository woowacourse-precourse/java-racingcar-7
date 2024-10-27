package racingcar.service.impl;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.service.NumberGenerator;

public class RandomNumberGeneratorService implements NumberGenerator {
    @Override
    public int generateNumber() {
        return Randoms.pickNumberInRange(0, 9);
    }
}
