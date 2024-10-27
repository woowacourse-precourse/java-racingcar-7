package racingcar.validation;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class MoveNumberValidatorTest {
    @ParameterizedTest
    @ValueSource(ints = {0, -1})
    void 이동_횟수가_1이하면_예외(int testNum) {
        Validator<Integer> validator = new MoveNumberValidator();

        assertThatThrownBy(() -> validator.validate(testNum))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("1회 이상의 이동 횟수를 입력해주세요.");
    }
}
