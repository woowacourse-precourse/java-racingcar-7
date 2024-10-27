package model;

import java.util.Arrays;
import java.util.List;

public class RaceCarParicipant {

  public List<String> cars ;

  public void validateCars(String input) {
    // 허용된 문자들만 포함되어 있는지 검사 (콤마, 영어, 숫자)
    if (input.matches(".*[^,A-Za-z0-9].*")) {
      throw new IllegalArgumentException("입력에 허용되지 않은 문자가 포함되어 있습니다.");
    }

    this.cars = Arrays.asList(input.split(","));
  }


}
