package racingcar.race.manager;

import static racingcar.race.manager.ManagerConstant.CAR_NAME_OUT_OF_RANGE;
import static racingcar.race.manager.ManagerConstant.ROUND_OUT_OF_RANGE;

import java.util.List;

public class ValidManager {

    public void validateRange(int round) {
        ROUND_OUT_OF_RANGE.validate(round);
    }

    public void validateSize(List<String> names) {
        CAR_NAME_OUT_OF_RANGE.validate(names.size());
    }
}
