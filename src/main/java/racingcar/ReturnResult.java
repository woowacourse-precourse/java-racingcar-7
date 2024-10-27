package racingcar;

import java.util.List;
import java.util.stream.Collectors;
import racingcar.Vehicle.Car;

public class ReturnResult {

  private List<Car> carList;
  public ReturnResult(List<Car> carList){
    this.carList = carList;
  }

  public List<Car> getTopCars() {
    int maxMove = carList.stream()
        .mapToInt(Car::getMove)
        .max()
        .orElse(0);


    return carList.stream()
        .filter(car -> car.getMove() == maxMove)
        .collect(Collectors.toList());
  }

  public void printWinners(List<Car> winners) {
    String winnerNames = winners.stream()
        .map(Car::getName)
        .collect(Collectors.joining(", "));

    System.out.println("최종 우승자 : " + winnerNames);
  }
}