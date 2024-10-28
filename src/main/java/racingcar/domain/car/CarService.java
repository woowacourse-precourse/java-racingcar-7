package racingcar.domain.car;

import camp.nextstep.edu.missionutils.Randoms;

public class CarService {
  private final int MIN_NUM = 0;
  private final int MAX_NUM = 9;
  private final int MOVE_THRESHOLD = 4;


  public boolean canMoveForward() {
    int randomNum = Randoms.pickNumberInRange(MIN_NUM, MAX_NUM);

    if (randomNum >= MOVE_THRESHOLD) {
      return true;
    } else {
      return false;
    }

  }
}
