package racingcar.domain;

import java.util.HashMap;
import java.util.Map;

public class Cars {
  private final Map<String, Car> cars;

  public Cars(String input) {
    cars = new HashMap<>();
    if (input == null || input.isEmpty()) {
      throw new IllegalArgumentException("Error: 입력값은 비어있을 수 없습니다.");
    }
    String[] carNames = input.split(",");

    for (String name : carNames) {
      String trimmedName = name.trim();
      if (cars.containsKey(trimmedName)) {
        throw new IllegalArgumentException("Error: 중복된 자동차 이름은 허용되지 않습니다.");
      }
      cars.put(trimmedName, new Car(trimmedName));
    }
  }

  public boolean contains(Car car) {
    return cars.containsValue(car);
  }

  public int size() {
    return cars.size();
  }
}
