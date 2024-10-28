package racingcar.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class CarTest {
    @ParameterizedTest
    @ValueSource(ints = {4, 9})
    @DisplayName("자동차가 움직일 수 있는 조건을 만족할 때 움직이는지 확인한다")
    void 움직일_수_있는_경우_테스트(int i) {
        Car car = new Car("pobi");
        NumberGenerator numberGenerator = () -> i;

        car.move(numberGenerator.generateNumber());

        Assertions.assertThat(car.getLocation()).isEqualTo(1);
    }


    @Test
    @DisplayName("이름 길이 테스트")
    void 이름_길이_테스트() {
        Assertions.assertThatThrownBy(() -> new Car("javajigi"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("이름의 길이가 5자를 넘을 수 없습니다");
    }

}
