package racingcar.model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class CarTest {

  @ParameterizedTest
  @ValueSource(ints = {4, 5, 6})
  void 자동차가_전진하면_MOVECOUNT는_0이_아니어야_한다(int giveNumber) {
    // given
    Car car = new Car("yongE");
    // when
    car.move(giveNumber);
    // then
    Assertions.assertThat(car.getMoveCount()).isEqualTo(1);
  }
}
