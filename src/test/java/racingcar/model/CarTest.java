package racingcar.model;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class CarTest {

    @Test
    void 자동차_이름이_5글자_초과할_경우_예외_발생() {
        // given
        String name = "여섯글자이름";

        // when & then
        assertThatThrownBy(() -> new Car(name))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동차 이름 입력 길이를 초과하였습니다. (최대 5자)");
    }

    @Test
    void 자동차_이름이_공백일_경우_예외_발생() {
        // given
        String whiteSpaceName = " ";
        String emptyName = "";

        // when & then
        assertThatThrownBy(() -> new Car(whiteSpaceName))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동차 이름이 공백으로 입력되었습니다.");
        assertThatThrownBy(() -> new Car(emptyName))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동차 이름이 공백으로 입력되었습니다.");
    }

    @Test
    void 자동차_이름_일치_테스트() {
        // given
        String name = "gyeom";
        Car car = new Car(name);

        // when & then
        assertEquals(name, car.getName());
    }

    @Test
    void 자동차_이동_후_위치_테스트() {
        // given
        String name = "gyeom";
        Car car = new Car(name);
        int movableNumber = 4;
        int immovableNumber = 3;

        // when
        car.moveFront(movableNumber);
        car.moveFront(movableNumber);
        car.moveFront(immovableNumber);
        car.moveFront(movableNumber);
        car.moveFront(immovableNumber);

        // then
        assertEquals(3, car.getPosition());
    }
}
