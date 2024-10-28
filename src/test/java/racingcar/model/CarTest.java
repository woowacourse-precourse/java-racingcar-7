package racingcar.model;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.junit.jupiter.api.Assertions.*;

import java.util.PriorityQueue;
import java.util.concurrent.PriorityBlockingQueue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.strategy.CarBasicStrategy;

/**
 * @author : jiffyin7@gmail.com
 * @since : 24. 10. 28.
 */
class CarTest {

  private Car car;

  @BeforeEach
  void setUp() {
    car = Car.from("test");
  }

  @DisplayName("[Success]from : 자동차 생성 테스트")
  @Test
  void from() {
    String name = "test1";
    Car carCreated = Car.from(name);

    assertEquals(name, carCreated.getName());
    assertEquals(0, carCreated.getPosition());
  }

  @DisplayName("[Success]move : 자동차 이동 테스트")
  @Test
  void move() {
    int initialPosition = car.getPosition();
    car.move();
    assertEquals(initialPosition + 1, car.getPosition());
  }

  @DisplayName("[Success]moveOrStay : 자동차 이동 또는 정지 테스트")
  @Test
  void moveOrStay() {
    int initialPosition = car.getPosition();
    HasCarMoved result = car.moveOrStay();
    if (result.moved()){
      assertEquals(initialPosition + 1, car.getPosition());
    }
    else {
      assertEquals(initialPosition, car.getPosition());
    }
  }

  @DisplayName("[Success]moveOrStay : 난수 값이 4 이상일 때 전진 테스트")
  @ParameterizedTest
  @ValueSource(ints = {4,5,6,7,8,9})
  void moveOrStay_moveWhenGreaterThanOrEqualFour(int randomValue) {
    int initialPosition = car.getPosition();
    assertRandomNumberInRangeTest(
        () -> {
          HasCarMoved result = car.moveOrStay();
          assertTrue(result.moved());
          assertEquals(initialPosition + 1, car.getPosition());
        },
        randomValue
    );
  }

  @DisplayName("[Success]moveOrStay : 난수 값이 4 미만일 때 정지 테스트")
  @ParameterizedTest
  @ValueSource(ints = {0,1,2,3})
  void moveOrStay_stayWhenLessThanFour(int randomValue) {
    int initialPosition = car.getPosition();
    assertRandomNumberInRangeTest(
        () -> {
          HasCarMoved result = car.moveOrStay();
          assertFalse(result.moved());
          assertEquals(initialPosition, car.getPosition());
        },
        randomValue
    );
  }

  @DisplayName("[Success]compareTo : 자동차 비교 테스트")
  @Test
  void compareTo() {
    Car car0 = Car.from("Car0");
    Car car1 = Car.from("Car1");
    Car car2 = Car.from("Car2");

    PriorityQueue<Car> priorityQueue = new PriorityQueue<>();
    // car1을 한 번 이동
    car1.move();

    // car2를 두 번 이동
    car2.move();
    car2.move();

    priorityQueue.add(car0);
    priorityQueue.add(car1);
    priorityQueue.add(car2);

    assertEquals(car2, priorityQueue.poll());
    assertEquals(car1, priorityQueue.poll());
    assertEquals(car0, priorityQueue.poll());
    assertTrue(car1.compareTo(car2) > 0);
    assertEquals(0, car1.compareTo(car1));
  }

  @DisplayName("[Success]compareTo : 자동차 같은 위치 테스트")
  @Test
  void compareTo_samePosition() {
    Car car0 = Car.from("Car0");
    Car car1 = Car.from("Car1");

    assertEquals(0, car0.compareTo(car1));
  }
}