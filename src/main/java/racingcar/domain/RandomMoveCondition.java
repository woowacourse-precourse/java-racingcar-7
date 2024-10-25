package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomMoveCondition {

  public boolean isMovable() {
    int randomValue = Randoms.pickNumberInRange(0, 9);
    return randomValue >= 4;
  }
}
