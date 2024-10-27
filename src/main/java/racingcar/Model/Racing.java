package racingcar.Model;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import racingcar.Enum.TypeOfLocation;
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
    ArrayList<String> winner = new ArrayList<>();
    AtomicInteger winnerLocation = new AtomicInteger(Integer.MIN_VALUE);

    cars.stream()
        .filter(car -> car.compareLocation(winnerLocation.get()) != TypeOfLocation.BEHIND)
        .forEach(
            car -> {
              TypeOfLocation typeOfLocation = car.compareLocation(winnerLocation.get());
              if (typeOfLocation == TypeOfLocation.IN_FRONT) {
                winner.clear();
                winnerLocation.set(car.updateWinnerLocation(winnerLocation.get()));
              }
              car.addWinnerName(winner);
            });

    return winner;
  }
}
