package racingcar.Model;

import camp.nextstep.edu.missionutils.Randoms;

public class Random {
  private static final int MINIMUM_RANDOM_NUMBER = 0;
  private static final int MAXIMUM_RANDOM_NUMBER = 9;

  public static int generateRandomNumber() {
    int randomNumber = Randoms.pickNumberInRange(MINIMUM_RANDOM_NUMBER, MAXIMUM_RANDOM_NUMBER);
    return randomNumber;
  }
}
