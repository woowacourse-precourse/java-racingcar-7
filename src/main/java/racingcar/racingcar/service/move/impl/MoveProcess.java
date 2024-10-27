package racingcar.racingcar.service.move.impl;

import racingcar.racingcar.domain.RacingCar;
import racingcar.racingcar.dto.RacingCarInfo;
import racingcar.racingcar.domain.MoveState;
import racingcar.racingcar.service.move.MoveService;
import racingcar.racingcar.service.move.RandomMoveGenerator;

public class MoveProcess implements MoveService {
    private final RandomMoveGenerator randomMoveGenerator;
    public MoveProcess(RandomMoveGenerator randomMoveGenerator) {
        this.randomMoveGenerator = randomMoveGenerator;
    }
    @Override
    public String move(RacingCarInfo racingCarInfo) {
        racingCarInfo.getRacingCarInfo().forEach(this::move);
        return racingCarInfo.toString();
    }
    public void move(RacingCar racingCar) {
        int moveCount = randomMoveGenerator.generate();
        if (MoveState.isMove(moveCount)) racingCar.increaseMoveCount();
    }
}
