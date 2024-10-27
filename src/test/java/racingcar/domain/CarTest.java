package racingcar.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CarTest {
    @Test
    @DisplayName("자동차가 움직일 수 있는 조건을 만족할 때 움직이는지 확인한다")
    void 움직임_테스트() {
        Car car = new Car("pobi");
        NumberGenerator numberGenerator = () -> 4;

        car.move(numberGenerator.generateNumber());

        Assertions.assertThat(car.getLocation()).isEqualTo(2);
    }
}
