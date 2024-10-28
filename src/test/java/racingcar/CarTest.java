package racingcar;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CarTest {

  @Test
  void 유효한_이름으로_자동차_생성() {
    Car car = new Car("pobi");
    assertThat(car.getName()).isEqualTo("pobi");
  }

  @Test
   void 이름이_빈칸이거나_너무_길_경우_예외() {
    assertThatThrownBy(() -> new Car(" "))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining("자동차 이름은 1자 이상 5자 이하만 가능합니다.");
    assertThatThrownBy(() -> new Car("toolongname"))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining("자동차 이름은 1자 이상 5자 이하만 가능합니다.");
    assertThatThrownBy(() -> new Car(""))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining("자동차 이름은 1자 이상 5자 이하만 가능합니다.");
  }

  @Test
  void 랜덤값이_4_이상일_때_전진() {
    Car car = new Car("pobi");
    car.move(4);
    assertThat(car.getPosition()).isEqualTo(1); // 전진
  }

  @Test
  void 랜덤값이_4_미만일_때_멈춤() {
    Car car = new Car("pobi");
    car.move(3);
    assertThat(car.getPosition()).isEqualTo(0); // 전진하지 않음
  }

}