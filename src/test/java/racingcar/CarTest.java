package racingcar;

import static org.assertj.core.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.Test;
import racingcar.Model.Car;

public class CarTest {

  @Test
  void nameWithLocationToString_정상_출력_테스트() {
    Car car = new Car("pobi");
    car.goFront();
    car.goFront();

    assertThat(car.nameWithLocationToString()).isEqualTo("pobi : --");
  }

  @Test
  void compareLocation_동일한_위치_추가_테스트() {

    Car car = new Car("pobi");
    car.goFront();
    car.goFront(); // location = 2
    ArrayList<String> winners = new ArrayList<>(List.of("woni"));

    Map<String, Object> result = car.compareLocation(2, winners);

    assertThat(result.get("maxNumber")).isEqualTo(2);
    assertThat((List<String>) result.get("winners")).containsExactly("woni", "pobi");
  }

  @Test
  void compareLocation_더_큰_위치_새로운_우승자_테스트() {

    Car car = new Car("pobi");
    car.goFront();
    car.goFront();
    car.goFront(); // location = 3
    ArrayList<String> winners = new ArrayList<>(List.of("woni"));

    Map<String, Object> result = car.compareLocation(2, winners);

    assertThat(result.get("maxNumber")).isEqualTo(3);
    assertThat((List<String>) result.get("winners")).containsExactly("pobi");
  }

  @Test
  void compareLocation_기존_우승자_여러명_동일한_위치_추가_테스트() {

    Car car = new Car("pobi");
    car.goFront();
    ArrayList<String> winners = new ArrayList<>(List.of("woni", "gigi"));

    Map<String, Object> result = car.compareLocation(1, winners);

    assertThat(result.get("maxNumber")).isEqualTo(1);
    assertThat((List<String>) result.get("winners")).containsExactly("woni", "gigi", "pobi");
  }
}
