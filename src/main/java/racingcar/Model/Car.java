package racingcar.model;

import java.util.ArrayList;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import racingcar.enums.TypeOfLocation;

public class Car {
  private final String NAME_AND_LOCATION_DELIMITER = " : ";

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

  public TypeOfLocation compareLocation(int maxNumber) {
    if (location == maxNumber) {
      return TypeOfLocation.SAME;
    }
    if (location > maxNumber) {
      return TypeOfLocation.IN_FRONT;
    }
    return TypeOfLocation.BEHIND;
  }

  public ArrayList<String> addWinnerName(ArrayList<String> winner) {
    winner.add(name);
    return winner;
  }

  public int updateWinnerLocation(int winnerLocation) {
    if (location > winnerLocation) {
      winnerLocation = location;
    }
    return winnerLocation;
  }
}
