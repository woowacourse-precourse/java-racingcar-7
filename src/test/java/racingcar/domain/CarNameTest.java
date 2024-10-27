package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

@SuppressWarnings("NonAsciiCharacters")
class CarNameTest {

    @ParameterizedTest
    @ValueSource(strings = {"pobi", "??", "11", "가가", "\\n", "aaaaa"})
    void 다섯_글자_이하의_이름이_전달된다(String name) {
        // given
        CarName carName = new CarName(name);

        // when & then
        assertThat(carName.getCarName()).isEqualTo(name);
    }

    @ParameterizedTest
    @ValueSource(strings = {"pobiii", "??????", "111111", "가가가가가가", "\\n\\n\\n"})
    void 여섯_글자_이상의_이름이_전달된면_예외가_발생한다(String name) {
        // given
        String expected = "자동차 이름은 5글자를 넘을 수 없습니다.";

        // when
        Throwable thrown = catchThrowable(() -> new CarName(name));

        // then
        assertThat(thrown)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(expected);
    }

    @Test
    void 입력으로_공백이_들어오면_예외가_발생한다() {
        // given
        String expected = "자동차 이름을 입력해주세요.";

        // when
        Throwable thrown = catchThrowable(() -> new CarName(" "));

        // then
        assertThat(thrown)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(expected);
    }
}
