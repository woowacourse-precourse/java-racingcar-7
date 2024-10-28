package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;

class MoveConditionGenerator {
    private static final int MAX_VALUE = 9;
    private static final int MIN_VALUE = 0;

    MoveCondition getCondition() {
        final int result = Randoms.pickNumberInRange(MIN_VALUE, MAX_VALUE);
        validateRange(result);
        return new MoveCondition(result);
    }

    private void validateRange(final int result) {
        if (result < MIN_VALUE|| result > MAX_VALUE) {
            throw new IllegalArgumentException("외부 라이브러리 에러");
        }
    }
}
