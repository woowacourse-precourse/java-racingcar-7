package view;

import camp.nextstep.edu.missionutils.Console;

public class CarInputView {
  public String carInput ;
  public int frequency ;

  public void CarInput() {
    System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    this.carInput = Console.readLine();
  }

  public void repeatFrequency() {
    System.out.println("시도할 횟수는 몇 회인가요");
    String frequencyInput = Console.readLine();

    if (frequencyInput.matches(".*[^0-9].*")) {
      throw new IllegalArgumentException();
    }

    this.frequency= Integer.parseInt(frequencyInput);
  }
}
