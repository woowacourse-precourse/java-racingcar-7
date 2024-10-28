package racingcar;


import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class RacingGame {
  public void run() {
    List<Car> cars = createCars();
  }

  private List<Car> createCars() {
    System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    String input = Console.readLine();
    return Arrays.stream(input.split(","))
        .map(String::trim)
        .map(Car::new)
        .collect(Collectors.toList());
  }

  private int getAttempts() {
    System.out.println("시도할 횟수는 몇 회인가요?");
    String input = Console.readLine();
    int attempts = Integer.parseInt(input);
    if (attempts <= 0) throw new IllegalArgumentException("횟수는 1 이상이어야 합니다.");
    return attempts;
  }
}
