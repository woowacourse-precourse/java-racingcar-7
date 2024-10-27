package racingcar.back.service.impl;

import camp.nextstep.edu.missionutils.Randoms;

class MoveConditionChecker {
    private static final Integer RAND_ORIGIN = 0;
    private static final Integer RAND_BOUND = 9;
    private static final Integer MOVE_THRESHOLD = 4;

    public static Boolean isMovable() {
        return generatorRandomNumber() >= MOVE_THRESHOLD;
    }

    private static Integer generatorRandomNumber() {
        return Randoms.pickNumberInRange(RAND_ORIGIN, RAND_BOUND);
    }
}
