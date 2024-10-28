package racingcar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;
import racingcar.application.RacingService;

import java.util.List;
import java.util.stream.Collectors;
import java.util.Arrays;
import racingcar.domain.dto.CarDTO;

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

    List<CarDTO> carDTOs = racingService.getCarDTOs(cars);
    carDTOs.forEach(carDTO -> assertThat(carDTO.position()).isNotNegative());
  }

  @Test
  void 공동_우승자_계산_테스트() {
    List<Car> cars = Arrays.asList(new Car("jhs"), new Car("hsj"), new Car("jwj"));

    cars.get(0).tryToMove(4);
    cars.get(2).tryToMove(4);

    List<CarDTO> winners = racingService.findWinners(racingService.getCarDTOs(cars));

    String winnerNames = winners.stream().map(CarDTO::name).collect(Collectors.joining(", "));

    assertThat(winnerNames).isEqualTo("jhs, jwj");
  }

  @Test
  void 단독_우승자_계산_테스트() {
    List<Car> cars = Arrays.asList(new Car("jhs"), new Car("hsj"), new Car("jwj"));
    cars.get(1).tryToMove(6);

    List<CarDTO> winners = racingService.findWinners(racingService.getCarDTOs(cars));
    String winnerNames = winners.stream().map(CarDTO::name).collect(Collectors.joining(", "));

    assertThat(winnerNames).isEqualTo("hsj");
  }
}