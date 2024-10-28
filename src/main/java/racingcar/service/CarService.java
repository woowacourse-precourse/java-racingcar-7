package racingcar.service;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.model.Car;
import racingcar.view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class CarService {
  private final List<Car> cars;
  private final int attemptsCount;

  public CarService(List<Car> cars, int attemptsCount) {
    this.cars = cars;
    this.attemptsCount = attemptsCount;
  }
  public static List<Car> createCars(String[] carNames) {
    List<Car> cars = new ArrayList<>();
    for (String name : carNames) {
      cars.add(new Car(name));
    }
    return cars;
  }
  private boolean canMove() {
    return Randoms.pickNumberInRange(0, 9) >= 4;
  }

  private void printStatus() {
    for (Car car : cars) {
      System.out.println(car.getStatus());
    }
  }
  private int findMaxPosition() {
    int maxPosition = 0;

    for (Car car : cars) {
      if (car.getPosition() > maxPosition) {
        maxPosition = car.getPosition();
      }
    }
    return maxPosition;
  }
  private List<String> findWinners() {
    int maxPosition = findMaxPosition();
    List<String> winners = new ArrayList<>();
    for (Car car : cars) {
      if (car.getPosition() == maxPosition) {
        winners.add(car.getName());
      }
    }
    return winners;
  }
  private void moveCars() {
    for (Car car : cars) {
      if (canMove()) {
        car.move();
      }
    }
  }
  public void startRace() {
    System.out.println("실행 결과");
    for (int i = 0; i < attemptsCount; i++) {
      moveCars();
      printStatus();
      System.out.println();
    }
    List<String>Winners = findWinners();
    OutputView.printWinners(Winners);
  }
}
