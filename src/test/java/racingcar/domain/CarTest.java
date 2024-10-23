package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;

class CarTest {

    @Test
    void 자동차_이름길이_범위_초과_예외처리() {

        assertThatThrownBy(() -> new Car("가마바사아아아"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("자동차 이름은 5자 이하까지 입력 가능합니다.");
    }

    @Test
    void 자동차_이름_공백_예외처리() {

        assertThatThrownBy(() -> new Car(""))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("공백으로 입력된 이름이 있습니다.");
    }

    @Test
    void 자동차_이름길이_특수문자_예외처리() {

        assertThatThrownBy(() -> new Car("%%"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("자동차 이름에 특수문자는 사용 불가합니다.");
    }

    @Test
    void 자동차_이름길이_특수문자_포함_예외처리() {

        assertThatThrownBy(() -> new Car("%%현대"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("자동차 이름에 특수문자는 사용 불가합니다.");
    }


}