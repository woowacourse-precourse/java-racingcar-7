package racingcar.service;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomService {
  public int getRandomNumber() {
    return Randoms.pickNumberInRange(0, 9);
  }
}
