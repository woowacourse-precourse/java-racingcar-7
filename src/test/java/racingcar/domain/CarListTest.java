package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;

class CarListTest {

    @Test
    void 자동차_이름_입력_빈값_실패() {
        // given
        String carNames = "test1,,test2";

        // when
        assertThatThrownBy(() -> CarList.from(carNames))
            // then
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage("자동차 이름은 공백일 수 없습니다.");
    }

    @Test
    void 자동차_이름_입력_중복_실패() {
        // given
        String carNames = "test,test,test";

        // when
        assertThatThrownBy(() -> CarList.from(carNames))
            // then
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage("중복된 자동차 이름이 존재합니다.");
    }

    @Test
    void 자동차_2대_미만_실패() {
        // given
        String carNames = "test";

        // when
        assertThatThrownBy(() -> CarList.from(carNames))
            // then
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage("자동차는 2대 이상이어야 합니다.");
    }
}