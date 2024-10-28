package racingcar.validator;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomValidator {
  public boolean checkRandomThreshold() {
    int ranNum;
    ranNum = Randoms.pickNumberInRange(0, 9);
    return ranNum >= 4;
  }
}
