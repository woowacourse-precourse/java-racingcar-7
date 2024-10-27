package racingcar.racingcar.validator.name;

import racingcar.constant.errormessage.ErrorMessage;
import racingcar.racingcar.domain.RacingCar;
import racingcar.racingcar.dto.RacingCarInfo;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class NameValidator {
    private static final int MAX_WITHIN_RANGE = 5;
    public static void withingRangeNameLength(String name) {
        if (name.length() > MAX_WITHIN_RANGE) throw new IllegalArgumentException(ErrorMessage.WITHIN_RANGE_ERROR_MESSAGE);
    }
    public static void isDuplicateName(RacingCarInfo racingCarInfo) {
        List<RacingCar> racingCarList = racingCarInfo.getRacingCarInfo();
        Set<RacingCar> racingCarSet = new HashSet<>(racingCarList);
        if (racingCarSet.size() != racingCarList.size()) throw new IllegalArgumentException(ErrorMessage.DUPLICATE_ERROR);
    }
}
