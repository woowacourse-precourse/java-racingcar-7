package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class Dice {
  private int number;

  public Dice() {
      this.number = 0;
  }

  public void rolling() {
      number = Randoms.pickNumberInRange(0, 9);
  }

  public int getNumber() {
      return number;
  }
}
