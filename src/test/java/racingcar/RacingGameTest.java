package racingcar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;
import racingcar.application.RacingService;

import java.util.List;
import java.util.stream.Collectors;
import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

class RacingGameTest {

  private RacingService racingService;

  @BeforeEach
  void setUp() {
    racingService = new RacingService();
  }

  @Test
  void 자동차_이동_시뮬레이션_테스트() {
    List<Car> cars = Arrays.asList(new Car("jhs"), new Car("hsj"), new Car("jwj"));

    racingService.moveCars(cars);

    cars.forEach(car -> assertThat(car.getPosition()).isGreaterThanOrEqualTo(0));
  }

  @Test
  void 공동_우승자_계산_테스트() {
    List<Car> cars = Arrays.asList(new Car("jhs"), new Car("hsj"), new Car("jwj"));

    cars.get(0).tryToMove(4);
    cars.get(2).tryToMove(4);

    List<Car> winners = racingService.findWinners(cars);
    String winnerNames = winners.stream()
        .map(Car::getName)
        .collect(Collectors.joining(", "));

    assertThat(winnerNames).isEqualTo("jhs, jwj");
  }

  @Test
  void 단독_우승자_계산_테스트() {
    List<Car> cars = Arrays.asList(new Car("jhs"), new Car("hsj"), new Car("jwj"));

    cars.get(1).tryToMove(6);

    List<Car> winners = racingService.findWinners(cars);
    String winnerNames = winners.stream()
        .map(Car::getName)
        .collect(Collectors.joining(", "));

    assertThat(winnerNames).isEqualTo("hsj");
  }
}