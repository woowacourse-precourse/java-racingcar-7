package racingcar.model;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * @author : jiffyin7@gmail.com
 * @since : 24. 10. 28.
 */
class RacingTest {

  private Car car1;
  private Car car2;
  private Car car3;
  private Cars cars;
  private Racing racing;


  @BeforeEach
  void setUp() {
    car1 = Car.from("Car1");
    car2 = Car.from("Car2");
    car3 = Car.from("Car3");
    cars = CarsList.from(Arrays.asList(car1, car2, car3));
    racing = Racing.from(cars, 5);
  }

  @DisplayName("[Success]from : Racing 객체 생성")
  @Test
  void from() {
    assertNotNull(racing);
    assertEquals(5, racing.getRoundCount());
  }

  @DisplayName("[Success]executeRound : RacingRoundResult 반환")
  @Test
  void executeRound() {
    RacingRoundResult result = racing.executeRound();
    assertNotNull(result);
    List<Car> movedCars = result.movedCars();
    assertTrue(0 <= movedCars.size() && movedCars.size() <= 3);
  }

  @DisplayName("[Success]retrieveWinners : 우승자 목록 반환")
  @Test
  void testRetrieveWinners() {
    car1.move();
    car2.move();
    List<Car> winners = racing.retrieveWinners();
    assertNotNull(winners);
    assertTrue(winners.size() == 2);
    assertTrue(winners.contains(car1) && winners.contains(car2));
  }

}