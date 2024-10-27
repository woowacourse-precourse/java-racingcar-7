package racingcar.Model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Car {
  private static final String NAME_AND_LOCATION_DELIMITER = " : ";

  private String name;
  private int location;

  public Car(String name) {
    this.name = name;
    this.location = 0;
  }

  public void goFront() {
    this.location++;
  }

  public String nameWithLocationToString() {
    return name
        + NAME_AND_LOCATION_DELIMITER
        + IntStream.range(0, location).mapToObj(i -> "-").collect(Collectors.joining());
  }

  public Map<String, Object> compareLocation(int maxNumber, ArrayList<String> winners) {//* 이 함수 길이를 줄여보기 *//
    if (location == maxNumber) { 
      winners.add(name);
    }
    if (location > maxNumber) {
      winners.clear();
      winners.add(name);
      maxNumber = location;
    }

    Map<String, Object> result = new HashMap<>();
    result.put("maxNumber", maxNumber);
    result.put("winners", winners);

    return result;
  }
}
