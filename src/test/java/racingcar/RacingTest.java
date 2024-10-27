package racingcar;

import static org.assertj.core.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;

import racingcar.model.Car;
import racingcar.model.Racing;

public class RacingTest {

  @Test
  void resultOfRound_정상_출력_테스트() {

    Car car1 = new Car("pobi");
    Car car2 = new Car("woni");
    car1.goFront();
    car2.goFront();
    car2.goFront();
    ArrayList<Car> cars = new ArrayList<>(List.of(car1, car2));
    Racing racing = new Racing(cars);

    String result = racing.resultOfRound();

    assertThat(result)
        .isEqualTo("pobi : -" + System.lineSeparator() + "woni : --" + System.lineSeparator());
  }

  @Test
  void pickWinner_단일_우승자_테스트() {
    Car car1 = new Car("pobi");
    Car car2 = new Car("woni");
    car1.goFront(); // pobi: 1
    car2.goFront();
    car2.goFront(); // woni: 2
    ArrayList<Car> cars = new ArrayList<>(List.of(car1, car2));
    Racing racing = new Racing(cars);

    ArrayList<String> winners = racing.pickWinner();

    assertThat(winners).containsExactly("woni");
  }

  @Test
  void pickWinner_동일_위치_여러_우승자_테스트() {
    Car car1 = new Car("pobi");
    Car car2 = new Car("woni");
    car1.goFront(); // pobi : 1
    car2.goFront(); // woni : 1
    ArrayList<Car> cars = new ArrayList<>(List.of(car1, car2));
    Racing racing = new Racing(cars);

    ArrayList<String> winners = racing.pickWinner();

    assertThat(winners).containsExactly("pobi", "woni");
  }
}
