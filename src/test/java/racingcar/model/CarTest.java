package racingcar.model;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarTest {

    private final Car car = new Car("pobi");

    @DisplayName("Car_생성_테스트")
    @Test
    public void newCarTest() {
        //given
        //when
        //then
        assertThat(car).isNotNull();
        assertThat(car)
                .extracting("name")
                .isEqualTo("pobi");
    }

    @DisplayName("Car_이름_조회_테스트")
    @Test
    public void getNameTest() {
        //given
        //when
        String carName = car.getName();
        //then
        assertThat(carName).isEqualTo("pobi");
    }

    @DisplayName("Car_이동_테스트")
    @Test
    public void canMoveUsingTest() {
        //given
        //when
        boolean moveResult = car.canMoveUsing(4);
        boolean stopResult = car.canMoveUsing(3);
        //then
        assertThat(moveResult).isTrue();
        assertThat(stopResult).isFalse();
    }


}