package racingcar;

import camp.nextstep.edu.missionutils.Console;

public class Input {
  // 유저가 형식에 따라 자동차 이름과 시도 횟수를 입력한다
  // 자동차 이름 입력
  // 시도 횟수 입력

  private String inputCarNames;
  private int inputPlayCounts;

  public Input() {
    this.inputCarNames = getInputCarNames();
    this.inputPlayCounts = getCountsValue();
  }

  public int getCountsValue() {
    String playCounts = Console.readLine();
    int countsValue = Integer.parseInt(playCounts);
    return countsValue;
  }

  // nullpointer
  public String getInputCarNames() {
    return Console.readLine();
  }
}
