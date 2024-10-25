package racingcar.racingcar;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import racingcar.constant.Strings;

public class RacingCarValidator {
    private static final RacingCarValidator RACING_CAR_VALIDATOR = new RacingCarValidator();

    private RacingCarValidator() {

    }

    public static RacingCarValidator getInstance() {
        return RACING_CAR_VALIDATOR;
    }

    // isExist 로 하려다가 이름이 뭔가 boolean 으로 반환 해야 할 것 같기도 하고,
    // boolean 으로 반환 해봤자 false가 갈 일이 없기도 하고,
    // 아래에 있는 메서드들이랑 일관성이 없기도 해서 이렇게 함.
    public void existCheck(String joinedCarNames) {
        if (joinedCarNames.isBlank()) {
            throw new IllegalArgumentException(Strings.MORE_THAN_ONE.getMessage());
        }
    }

    public void lengthCheck(List<String> carNames, int maxLength) {
        for (String name : carNames) {
            if (name.length() > maxLength) {
                throw new IllegalArgumentException(Strings.OVER_MAX_LENGTH.getMessage());
            }
        }
    }

    public void sameNameCheck(List<String> carNames) {
        Set<String> nameSet = new HashSet<>(carNames);
        if (nameSet.size() != carNames.size()) {
            throw new IllegalArgumentException(Strings.EXIST_SAME_NAME.getMessage());
        }
    }
}
