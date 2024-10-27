package racingcar;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.model.Car;

public class CarTest {

    @Test
    public void 자동차_생성_테스트() {
        Car car = new Car("pobi");
        assertThat(car.getName()).isEqualTo("pobi");
        assertThat(car.getPosition()).isEqualTo(0);
    }

    @ParameterizedTest
    @ValueSource(strings = {"iamsix", "overfive"})
    public void 자동차_이름_길이_초과_예외_테스트(String carName) {
        assertThatThrownBy(() -> new Car(carName).validateNotExceedMaxLength())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 자동차 이름은 5자 이하여야 합니다.");
    }

    @ParameterizedTest
    @ValueSource(strings = {"pobi", "woni", "jun"})
    public void 자동차_정상이름_테스트(String carName) {
        Car car = new Car(carName);
        assertThat(car.getName()).isEqualTo(carName);
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4, 5, Integer.MAX_VALUE})
    public void 자동차_전진_테스트(int moveCount) {
        //given
        Car car = new Car("pobi");

        //when
        for (int i = 0; i < moveCount; i++) {
            car.moveFoward();
        }

        assertThat(car.getPosition()).isEqualTo(moveCount);
    }

    @Test
    public void 자동차_위치상태_테스트() {
        //given
        Car car = new Car("pobi");
        int moveTimes = 5;

        //when
        for (int i = 0; i < moveTimes; i++) {
            car.moveFoward();
        }

        //then
        assertThat(car.getStatus()).isEqualTo(car.getName() + " : " + "-".repeat(moveTimes));
    }

}
