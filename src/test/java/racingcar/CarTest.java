package racingcar;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.model.Car;

public class CarTest {

    private Car car;

    @BeforeEach
    void setUp() {
        car = new Car("pobi", "");
    }

    @Test
    @DisplayName("Car 객체를 생성할 수 있다")
    void Car_객체를_생성할_수_있다() {
        Car newCar = new Car("woni", "");
        assertThat(newCar.getName()).isEqualTo("woni");
    }

    @Test
    @DisplayName("자동차의 이름이 5자 초과면 에외가 발생합니다.")
    void 자동차의_이름이_5자_초과면_에외가_발생합니다() {
        assertThatThrownBy(() -> new Car("minjukwak", ""))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동차 이름은 5자 이하여야 합니다.");

    }

    @Test
    @DisplayName("앞으로 전진하는 기능이 정상적으로 작동합니다.")
    void 앞으로_전진하는_기능이_정상적으로_작동하는지_테스트() {
        //given
        String curLocation = "";

        //when
        car.moveForward();

        //then
        assertEquals("-", car.getCurLocation());
    }

    @Test
    @DisplayName("최대 이동거리가 자동차의 현재 위치와 일치하면 True를 반환합니다.")
    void 최대_이동거리가_자동차의_현재_위치와_일치하면_True를_반환합니다() {
        //given
        int maximum = 4;

        //4만큼 이동
        car.moveForward();
        car.moveForward();
        car.moveForward();
        car.moveForward();

        //when
        Boolean result = car.isSamePosition(maximum);

        //then
        assertEquals(true, result);
    }
}
