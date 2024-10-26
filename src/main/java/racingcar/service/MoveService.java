package racingcar.service;

import static racingcar.common.Constant.MOVE_CONDITION;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class MoveService {

    public List<Boolean> setMoveHistory(int attempt) {
        return IntStream.range(0, attempt)
                .mapToObj(i -> canMove())
                .collect(Collectors.toList());
    }

    private boolean canMove() {
        return pickRandomNumber() >= Integer.parseInt(MOVE_CONDITION.getValue());
    }

    private int pickRandomNumber() {
        return Randoms.pickNumberInRange(0, 9);
    }
}
