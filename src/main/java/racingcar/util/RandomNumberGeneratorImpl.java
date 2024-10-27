package racingcar.util;

import camp.nextstep.edu.missionutils.Randoms;

/**
 * @author : jiffyin7@gmail.com
 * @since : 24. 10. 25.
 */
public class RandomNumberGeneratorImpl implements RandomNumberGenerator{
  private static final int MINIMUM_RANDOM_NUMBER = 0;
  private static final int MAXIMUM_RANDOM_NUMBER = 9;

  @Override
  public int generate() {
    return Randoms.pickNumberInRange(MINIMUM_RANDOM_NUMBER, MAXIMUM_RANDOM_NUMBER);
  }
}
