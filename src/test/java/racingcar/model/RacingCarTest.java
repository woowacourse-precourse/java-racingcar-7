package racingcar.model;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class RacingCarTest {

    @Test
    void racingCar_WhenCarNameIsProvided_ShouldStoreNameAndInitializePosition() {
        // 자동차 이름이 정상적으로 저장되고 초기 위치가 0인지 확인
        RacingCar car = new RacingCar("pobi");

        assertThat(car.getName()).isEqualTo("pobi");
        assertThat(car.getPosition()).isEqualTo(0);
    }

    @Test
    void racingCar_WhenAdvanceIsCalled_ShouldMoveForward() {
        // advance() 호출 시 자동차가 전진하는지 확인
        RacingCar car = new RacingCar("pobi");
        car.advance();
        assertThat(car.getPosition()).isEqualTo(1);

        car.advance();
        assertThat(car.getPosition()).isEqualTo(2);
    }

}
