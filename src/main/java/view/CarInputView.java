package view;

import camp.nextstep.edu.missionutils.Console;

public class CarInputView {
  private String carInput ;

  public void CarInput() {
    System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    this.carInput = Console.readLine();
  }

  public String getCarInput() {
    return carInput;
  }
}
