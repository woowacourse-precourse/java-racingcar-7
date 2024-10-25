package racingcar.util;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class ValidatorTest {

    @Test
    @DisplayName("자동차 이름이 5글자를 넘으면 예외 발생")
    void carNameLengthTest() {
        // 5글자 이상의 이름을 포함한 리스트로 검증
        assertThatThrownBy(() -> Validator.carNameValidate(List.of("pobi", "polar", "ihavelongname")))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
