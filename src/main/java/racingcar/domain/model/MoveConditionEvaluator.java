package racingcar.domain.model;

import camp.nextstep.edu.missionutils.Randoms;

final class MoveConditionEvaluator {
    private static final int MOVE_THRESHOLD = 4;
    private static final int MAX_NUMBER = 9;
    private static final int MIN_NUMBER = 0;

    static boolean isCanMove() {
        return generateRandomMoveNumber() >= MOVE_THRESHOLD;
    }

    private static int generateRandomMoveNumber() {
        return Randoms.pickNumberInRange(MIN_NUMBER, MAX_NUMBER);
    }
}
