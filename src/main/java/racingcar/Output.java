package racingcar;

import java.util.List;

public class Output {
  public static void showRound(List<Car> cars) {
    for (Car car : cars) {
      System.out.println(car.getName() + " : " + "-".repeat(car.getPosition()));
    }
    System.out.println();
  }

  public static void showWinner(String winner){
    System.out.println("최종 우승자 : " + winner);
  }
}
