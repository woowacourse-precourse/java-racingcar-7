package racingcar.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarTest {

    NumberGenerator moveGenerator = () -> 4;
    NumberGenerator stopGenerator = () -> 3;

    @DisplayName("자동차 생성 성공")
    @Test
    void carTest() {
        String carName = "pobi";

        Car car = new Car(carName, stopGenerator);

        Assertions.assertThat(car.getName()).isEqualTo(carName);
    }

    @DisplayName("자동차 생성 실패 : 길이가 6자 이상인 이름")
    @Test
    void validateNameLengthTest() {
        String carName = "javaji";

        Assertions.assertThatThrownBy(() -> new Car(carName, stopGenerator))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동차 이름은 5자 이하여야 합니다.");
    }

    @DisplayName("자동차 생성 실패 : 공백이 포함된 이름")
    @Test
    void validateNoSpaceTest() {
        String carName = " pobi";

        Assertions.assertThatThrownBy(() -> new Car(carName, stopGenerator))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동차 이름에 공백을 포함할 수 없습니다.");
    }

    @DisplayName("자동차 전진 성공")
    @Test
    void moveTest() {
        Car car = new Car("pobi", moveGenerator);

        car.move();

        Assertions.assertThat(car.getDistance()).isEqualTo(1);
    }

    @DisplayName("자동차 전진 실패")
    @Test
    void stopTest() {
        Car car = new Car("pobi", stopGenerator);

        car.move();

        Assertions.assertThat(car.getDistance()).isEqualTo(0);
    }
}
