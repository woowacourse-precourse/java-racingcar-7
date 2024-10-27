package racingcar.strategy;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.util.Constants;

public class RandomMoveStrategy implements MoveStrategy {

  @Override
  public boolean isMovable() {
    int randomValue = Randoms.pickNumberInRange(Constants.MIN_RANDOM_VALUE,
        Constants.MAX_RANDOM_VALUE);
    return randomValue >= Constants.MOVABLE_THRESHOLD;
  }
}
