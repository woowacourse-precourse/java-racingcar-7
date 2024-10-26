package racingcar.util;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomMoveCondition {

  private RandomMoveCondition() {

  }

  public static boolean isMovable() {
    int randomValue = Randoms.pickNumberInRange(0, 9);
    return randomValue >= 4;
  }
}
