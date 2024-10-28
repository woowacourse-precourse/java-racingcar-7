package racingcar.model.infrastructure;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.model.domain.Rule;

public class RaceRule implements Rule{
    @Override
    public int play() {
        return Randoms.pickNumberInRange(0, 9);
    }
}
