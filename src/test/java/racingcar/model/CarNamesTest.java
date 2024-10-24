package racingcar.model;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static racingcar.constants.ErrorMessage.NOT_ALLOWED_FIRST_LAST_BLANK;

class CarNamesTest {
    @Test
    void 문장_맨_앞에_공백이_포함되는_경우_예외가_발생한다() {
        // given
        String rawCarNames = " car1,car2,car3";

        // when & then
        assertThatThrownBy(() -> new CarNames(rawCarNames))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(NOT_ALLOWED_FIRST_LAST_BLANK);
    }

    @Test
    void 문장_맨_뒤에_공백이_포함되는_경우_예외가_발생한다() {
        // given
        String rawCarNames = "car1,car2,car3 ";

        // when & then
        assertThatThrownBy(() -> new CarNames(rawCarNames))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(NOT_ALLOWED_FIRST_LAST_BLANK);
    }

    @Test
    void 문장_맨_앞과_맨_뒤에_공백이_포함되는_경우_예외가_발생한다() {
        // given
        String rawCarNames = " car1,car2,car3 ";

        // when & then
        assertThatThrownBy(() -> new CarNames(rawCarNames))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(NOT_ALLOWED_FIRST_LAST_BLANK);
    }

    @Test
    void 쉼표를_기준으로_구분하는_데_성공한다() {
        // given
        String rawCarNames = "car1,car2,car3";
        List<String> expected = List.of("car1", "car2", "car3");

        // when
        CarNames carNames = new CarNames(rawCarNames);
        List<String> real = carNames.splitByComma();

        // then
        assertThat(real).isEqualTo(expected);
    }
}
