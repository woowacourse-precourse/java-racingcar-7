package racingcar;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import java.util.HashMap;
import java.util.Map;


public class Application {

  public static void main(String[] args) {
    List<String> cars = getCarInput();
    Map<String, String> carGameRecords = createCarGameRecords(cars);
  }

  public static List<String> getCarInput() {
    System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    String input = Console.readLine();
    validateInput(input);

    List<String> cars = Arrays.asList(input.split(","));
    return cars;
  }

  public static void validateInput(String input) {
    // 허용된 문자들만 포함되어 있는지 검사 (콤마, 영어, 숫자)
    if (input.matches(".*[^,A-Za-z0-9].*")) {
      throw new IllegalArgumentException("입력에 허용되지 않은 문자가 포함되어 있습니다.");
    }
  }

  public static Map<String, String> createCarGameRecords(List<String> cars) {
    Map<String, String> carGameRecords = new HashMap<>();

    // 차 이름이 5자를 초과하는지 검증
    for (String carName : cars) {
      if (carName.length() > 5) {
        throw new IllegalArgumentException("차 이름이 5자를 초과했습니다: " + carName);
      }
      carGameRecords.put(carName, "");  // 초기 값은 빈 문자열_전진을 안했으니까
    }

    return carGameRecords;
  }


}
