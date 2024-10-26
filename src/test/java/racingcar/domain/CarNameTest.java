package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;

public class CarNameTest {

    @Test
    void 자동차_이름이_5자를_초과하면_예외_발생() {
        assertThatThrownBy(() -> new CarName("자동차이름초과"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동차 이름은 1자 이상 5자 이하만 가능합니다.");
    }

    @Test
    void 자동차_이름에_공백이_포함될_경우_예외_발생() {
        assertThatThrownBy(() -> new CarName("이 름"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동차 이름은 공백을 포함할 수 없습니다.");
    }

    @Test
    void 자동차_이름이_비어있거나_공백만_포함될_경우_예외_발생() {
        assertThatThrownBy(() -> new CarName(" "))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동차 이름은 비어있거나 공백만 포함할 수 없습니다.");
    }

    @Test
    void 자동차_이름이_null일_경우_예외_발생() {
        assertThatThrownBy(() -> new CarName(null))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동차 이름은 비어있거나 공백만 포함할 수 없습니다.");
    }

    @Test
    void 자동차_이름이_유효한_이름일_경우_객체_생성() {
        CarName carName = new CarName("차량1");
        assertThat(carName.value()).isEqualTo("차량1");
    }

    @Test
    void 자동차_이름에_유효하지_않은_특수문자가_포함되면_예외_발생() {
        assertThatThrownBy(() -> new CarName("차량@"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동차 이름은 영문자, 숫자, 대시(-), 밑줄(_) 및 완성된 한글만 가능합니다.");
    }
}
