package racingcar;

import camp.nextstep.edu.missionutils.Console;

public class Input {
  // 유저가 형식에 따라 자동차 이름과 시도 횟수를 입력한다
  // 자동차 이름 입력
  // 시도 횟수 입력

  private String inputCarNames;
  private int inputPlayCounts;

  public Input() {
    this.inputCarNames = Console.readLine();
    this.inputPlayCounts = Integer.parseInt(Console.readLine());
  }

  public int getCountsValue() {
    return inputPlayCounts;
  }

  // nosuchelementExeption
  public String getInputCarNames() {
    return inputCarNames;
  }
}
