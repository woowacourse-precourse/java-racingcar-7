package racingcar;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class CarTest {

    @Test
    @DisplayName("자동차의 이름은 5자를 넘지 않는다")
    public void whenFiveMoreName_thenThrowException() {
        //when & then
        assertThrows(IllegalArgumentException.class, () -> Car.from("gyunho"));
    }

    @Test
    @DisplayName("자동차가 전진하면 위치가 증가한다")
    public void whenCarMoveForward_thenIncreasesPosition() {
        //given
        Car car = Car.from("pobi");

        //when
        car.move();

        //then
        assertThat(car.getPosition()).isEqualTo(1);
    }

}