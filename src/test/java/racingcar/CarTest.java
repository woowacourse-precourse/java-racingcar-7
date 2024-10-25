package racingcar;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;

class CarTest {
    @Test
    @DisplayName("자동차가 전진했을때 위치가 1씩 증가하는지 테스트")
    void randomlyMove() {
        //given
        Car car1 = new Car("pobi");
        Car car2 = new Car("jun");

        //when
        car1.tryMove(true);
        car1.tryMove(true);
        car2.tryMove(false);
        int car1Position= car1.getPosition();
        int car2Position= car2.getPosition();

        //then
        Assertions.assertThat(car1Position).isEqualTo(2);
        Assertions.assertThat(car2Position).isEqualTo(0);

    }
}