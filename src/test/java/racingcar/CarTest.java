package racingcar;

import java.util.Collections;
import java.util.Map;
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

    @Test
    void 숫자가_4_이상일_때_전진() {
        // give
        int giveNumber = 4;
        Car car = new Car("소정");
        Map<String, Integer> expectedResult = Collections.singletonMap("소정", 1);

        // when
        car.decideMoving(giveNumber);

        // then
        Assertions.assertThat(car.tellDecision()).isEqualTo(expectedResult);
    }

    @Test
    void 숫자가_4_미만일_때_멈춤() {
        // give
        int giveNumber = 3;
        Car car = new Car("소정");
        Map<String, Integer> expectedResult = Collections.singletonMap("소정", 0);

        // when
        car.decideMoving(giveNumber);

        // then
        Assertions.assertThat(car.tellDecision()).isEqualTo(expectedResult);
    }
}
