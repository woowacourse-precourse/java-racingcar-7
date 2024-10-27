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
}