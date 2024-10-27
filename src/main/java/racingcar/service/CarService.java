package racingcar.service;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.model.Car;

import java.util.ArrayList;
import java.util.List;

public class CarService {
  private final List<Car> cars;
  private final int attemptsCount;

  public CarService(List<Car> cars, int attemptsCount) {
    this.cars = cars;
    this.attemptsCount = attemptsCount;
  }

  private boolean canMove() {
    return Randoms.pickNumberInRange(0, 9) >= 4;
  }

  private void printStatus() {
    for (Car car : cars) {
      System.out.println(car.getStatus());
    }
  }
  private void printWinners() {
    int maxPosition = 0;
    for (Car car : cars) {
      if (car.getPosition() > maxPosition) {
        maxPosition = car.getPosition();
      }
    }
    List<String> winners = new ArrayList<>();
    for (Car car : cars) {
      if (car.getPosition() == maxPosition) {
        winners.add(car.getName());
      }
    }
    System.out.print("최종 우승자 : ");
    for (int i = 0; i < winners.size(); i++) {
      System.out.print(winners.get(i));
      if (i != winners.size() - 1) {
        System.out.print(", ");
      }
    }
    System.out.println();
  }
  public void start() {
    System.out.println("실행 결과");
    for (int i = 0; i < attemptsCount; i++) {
      for (Car car : cars) {
        if (canMove()) {
          car.move();
        }
      }
      printStatus();
      System.out.println();
    }
    printWinners();
  }
}
