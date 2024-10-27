package racingcar.validator;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class RaceCarsValidatorTest {

    @Test
    void 중복된_자동차_이름이_있는경우_예외테스트() {
        List<String> names = List.of("pobi", "pobi");
        assertThatThrownBy(() -> RaceCarsValidator.validate(names))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 자동차_개수가_1개_미만일_경우_예외테스트() {
        List<String> names = List.of();
        assertThatThrownBy(() -> RaceCarsValidator.validate(names))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
