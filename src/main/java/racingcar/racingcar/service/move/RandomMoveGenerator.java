package racingcar.racingcar.service.move.impl;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.constant.move.MoveConstant;

public class RandomMoveGenerator {
    public int generate() {
        return Randoms.pickNumberInRange(MoveConstant.MIN_MOVE_RANGE, MoveConstant.MAX_MOVE_RANGE);
    }
}
