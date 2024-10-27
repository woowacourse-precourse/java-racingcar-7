package racingcar;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class CarTest {

    @Test
    void 자동차이름_5자_이하인지_검사() {
        String carName = "5자초과이름";

        Assertions.assertThatThrownBy(() -> {
                    new Car(carName);
                }).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동차 이름은 최대 5자여야 합니다.");
    }

    @Test
    void 자동차이름_1자_이상인지_검사() {
        String carName = "";

        Assertions.assertThatThrownBy(() -> {
                    new Car(carName);
                }).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동차 이름은 최소 1자여야 합니다.");
    }

    @Test
    void 자동차이름_공백인지_검사() {
        String carName = " ";

        Assertions.assertThatThrownBy(() -> {
                    new Car(carName);
                }).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동차 이름은 공백이 될 수 없습니다.");
    }
}
