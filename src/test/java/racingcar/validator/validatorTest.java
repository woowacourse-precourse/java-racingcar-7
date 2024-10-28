package racingcar.validator;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class validatorTest {

    Validator validator = new Validator();

    @Test
    void 이름_검증_기능_테스트() {
        // given
        String names = "a,b,c,d";

        // when
        boolean result = validator.validateNames(names);

        // then
        Assertions.assertThat(result).isEqualTo(true);
    }

    @Test
    void 이름_검증_예외_테스트() {
        String names = "a,b,c,defghi";

        Assertions.assertThatThrownBy(() -> {
            validator.validateNames(names);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 시행_횟수_검증_테스트() {
        Long times = 10L;
        validator.validateTimes(times);
    }

    @Test
    void 시행_횟수_예외_테스트() {
        Long times = 0L;
        Assertions.assertThatThrownBy(() -> validator.validateTimes(times))
                .isInstanceOf(IllegalArgumentException.class);
    }
}