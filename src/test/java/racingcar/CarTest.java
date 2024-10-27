package racingcar;

import static org.assertj.core.api.Assertions.*;

import java.util.ArrayList;
import org.junit.jupiter.api.Test;
import racingcar.enums.TypeOfLocation;
import racingcar.model.Car;

public class CarTest {

  @Test
  void nameWithLocationToString_정상_출력_테스트() {
    Car car = new Car("pobi");
    car.goFront();
    car.goFront();

    assertThat(car.nameWithLocationToString()).isEqualTo("pobi : --");
  }

  @Test
  void compareLocation_같은_위치_테스트() {
    Car car = new Car("pobi");
    car.goFront();

    TypeOfLocation result = car.compareLocation(1);

    assertThat(result).isEqualTo(TypeOfLocation.SAME);
  }

  @Test
  void compareLocation_더_앞에_있는_테스트() {
    Car car = new Car("pobi");
    car.goFront();
    car.goFront();

    TypeOfLocation result = car.compareLocation(1);

    assertThat(result).isEqualTo(TypeOfLocation.IN_FRONT);
  }

  @Test
  void compareLocation_뒤에_있는_테스트() {
    Car car = new Car("pobi");
    car.goFront();

    TypeOfLocation result = car.compareLocation(2);

    assertThat(result).isEqualTo(TypeOfLocation.BEHIND);
  }

  @Test
  void addWinnerName_정상_추가_테스트() {
    Car car = new Car("pobi");
    ArrayList<String> winners = new ArrayList<>();

    car.addWinnerName(winners);

    assertThat(winners).containsExactly("pobi");
  }
}
