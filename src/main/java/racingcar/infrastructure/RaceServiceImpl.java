package racingcar.infrastructure;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.domain.application.RaceService;

import static racingcar.Const.*;

public class RaceServiceImpl implements RaceService {

    @Override
    public boolean canGo() {
        int randomNumber = Randoms.pickNumberInRange(START_NUMBER, END_NUMBER);
        return randomNumber >= CRITERIA;
    }
}
