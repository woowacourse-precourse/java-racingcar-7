package racingcar;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("자동차 경주 테스트")
public class RacingGameTest {

    @Test
    @DisplayName("자동차는 무작위 값 4이상일 때 한칸 전진한다.")
    void 자동차_전진_테스트(){
        Car car = new Car("yoon");
        car.moveCar(4);
        assertThat(car.getPosition()).isEqualTo(1);
    }
}
