package racingcar.Model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import racingcar.Utilities.Random;

public class Racing implements RacingRule {
  private ArrayList<Car> cars;

  public Racing(ArrayList<Car> cars) {
    this.cars = cars;
  }

  public static Racing startRacing(List<String> carNames) {
    ArrayList<Car> cars = new ArrayList<>();

    for (String name : carNames) {
      cars.add(new Car(name));
    }

    return new Racing(cars);
  }

  public void runRound() {
    for (Car car : cars) {
      boolean goOrStop = goOrStop();
      if (goOrStop) {
        car.goFront();
      }
    }
  }

  @Override
  public boolean goOrStop() {
    int randomNumber = Random.generateRandomNumber();
    if (randomNumber > 3) {
      return true;
    }
    return false;
  }

  public String resultOfRound() {
    StringBuilder sb = new StringBuilder();
    for (Car car : cars) {
      sb.append(car.nameWithLocationToString()).append(System.lineSeparator());
    }
    return sb.toString();
  }

  @Override
  public ArrayList<String> pickWinner() {
    Map<String, Object> result = new HashMap<>();
    ArrayList<String> winners = new ArrayList<>();
    int maxNumber = Integer.MIN_VALUE;
    for (Car car : cars) {
      result = car.compareLocation(maxNumber, winners);
      winners = (ArrayList<String>) result.get("winners");
      maxNumber = (int) result.get("maxNumber");
    }
    return winners;
  }
}
