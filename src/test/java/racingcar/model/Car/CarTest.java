package racingcar.model.Car;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarTest {

    @Test
    @DisplayName("자동차 이름이 5글자를 초과하면 예외를 발생한다.")
    public void carNameValidateLength() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            Car car = new Car("abcdef");
        });
    }

    @Test
    @DisplayName("자동차 이름이 5글자 이하이면 정상작동한다.")
    public void setCarName() {
        Car car = new Car("abcde");
        org.assertj.core.api.Assertions.assertThat(car.getCarName()).isEqualTo("abcde");
    }
}