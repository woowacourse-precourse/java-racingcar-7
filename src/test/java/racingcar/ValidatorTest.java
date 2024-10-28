package racingcar;

import org.junit.jupiter.api.Test;
import racingcar.validator.Validator;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class ValidatorTest {
    @Test
    void 이름_길이가_제한을_넘어설_경우_예외를_발생() {
        List<String> carNames = List.of("car", "toolongname");

        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> Validator.validateNameLength(carNames))
                .withMessageContaining("자동차 이름은 5자 이하만 가능합니다");
    }

    @Test
    void 이름에_잘못된_문자가_포함될_경우_예외를_발생() {
        List<String> carNames = List.of("car", "car@");

        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> Validator.validateNameFormat(carNames))
                .withMessageContaining("자동차 이름은 알파벳 문자만 포함해야 합니다");
    }

    @Test
    void 시도_횟수가_1보다_작을_경우_예외를_발생() {
        int attemptCount = 0;

        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> Validator.validateAttemptCount(attemptCount))
                .withMessageContaining("시도 횟수는 1 이상의 정수여야 합니다");
    }
}
