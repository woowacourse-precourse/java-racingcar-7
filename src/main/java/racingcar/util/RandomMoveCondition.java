package racingcar.util;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomMoveCondition {

  private static final int MIN_RANDOM_VALUE = 0;
  private static final int MAX_RANDOM_VALUE = 9;
  private static final int MOVABLE_THRESHOLD = 4;

  private RandomMoveCondition() {
  }

  public static boolean isMovable() {
    int randomValue = Randoms.pickNumberInRange(MIN_RANDOM_VALUE, MAX_RANDOM_VALUE);
    return randomValue >= MOVABLE_THRESHOLD;
  }
}
