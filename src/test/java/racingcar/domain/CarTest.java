package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static racingcar.message.ErrorMessage.INVALID_NAME_INPUT;
import static racingcar.message.ErrorMessage.INVALID_NAME_LENGTH;

class CarTest {

    @Test
    @DisplayName("정상적인 자동차 이름")
    public void test1(){
        Car car = new Car("car1");
        assertThat("car1").isEqualTo(car.getName());
    }

    @Test
    @DisplayName("자동차 이름이 비어 있는 경우")
    public void test2(){
        assertThatThrownBy(() -> new Car(""))
                .isInstanceOf(IllegalArgumentException.class).hasMessage(INVALID_NAME_INPUT.getMessage());
    }

    @Test
    @DisplayName("자동차 이름이 5글자를 초과할 경우")
    public void test3(){
        assertThatThrownBy(() -> new Car("aaaaaaaaaa"))
                .isInstanceOf(IllegalArgumentException.class).hasMessage(INVALID_NAME_LENGTH.getMessage());
    }

}