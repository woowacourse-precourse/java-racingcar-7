package racingcar.service.racing;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.container.DependencyInjectionContainer;
import racingcar.model.Car;
import racingcar.model.Cars;
import racingcar.model.CarsList;
import racingcar.model.Racing;
import racingcar.model.RacingRoundResult;

/**
 * @author : jiffyin7@gmail.com
 * @since : 24. 10. 28.
 */
class RacingServiceTest {
  private RacingService racingService;
  private Car car1;
  private Car car2;
  private Car car3;
  private Cars cars;

  @BeforeEach
  void setUp() {

    DependencyInjectionContainer container = new DependencyInjectionContainer();
    racingService = container.get(RacingService.class);
    car1 = Car.from("Car1");
    car2 = Car.from("Car2");
    car3 = Car.from("Car3");
    cars = CarsList.from(Arrays.asList(car1, car2, car3));
  }

  @DisplayName("[Success]open : Racing 객체 생성")
  @Test
  void open() {
    int roundCount = 5;
    Racing racing = racingService.open(cars, roundCount);

    assertNotNull(racing);
    assertEquals(roundCount, racing.getRoundCount());
  }

  @DisplayName("[Success]retrieveWinners : 우승자 목록 반환")
  @Test
  void retrieveWinners() {
    Racing racing = racingService.open(cars, 5);
    car1.move();
    car2.move();
    List<Car> winners = racingService.retrieveWinners(racing);

    assertNotNull(winners);
    assertEquals(2, winners.size());
    assertTrue(winners.contains(car1) && winners.contains(car2));
  }

  @DisplayName("[Success]executeRound : RacingRoundResult 반환")
  @Test
  void executeRound() {
    Racing racing = racingService.open(cars, 5);
    RacingRoundResult result = racingService.executeRound(racing);
    List<Car> movedCars = result.movedCars();
    assertTrue(0 <= movedCars.size() && movedCars.size() <= 3);
  }
}