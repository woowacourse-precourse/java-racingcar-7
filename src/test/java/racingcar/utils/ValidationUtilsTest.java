package racingcar.utils;

import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("ValidationUtils 유효성 검사 테스트")
public class ValidationUtilsTest {
    @Test
    @DisplayName("자동차 이름이 빈 문자열일 경우 예외를 던진다")
    void shouldThrowExceptionWhenCarNameIsEmpty() {
        String[] carNames = {"", "Kotlin"};
        assertThrows(IllegalArgumentException.class, () -> {
            ValidationUtils.validateCarNames(carNames);
        });
    }

    @Test
    @DisplayName("자동차 이름이 중복될 경우 예외를 던진다")
    void shouldThrowExceptionWhenCarNamesAreDuplicated() {
        String[] carNames = {"Java", "Java"};
        assertThrows(IllegalArgumentException.class, () -> {
            ValidationUtils.validateCarNames(carNames);
        });
    }

    @Test
    @DisplayName("이동 횟수가 음수일 경우 예외를 던진다")
    void shouldThrowExceptionWhenTryCountIsNegative() {
        int tryCount = -5;
        assertThrows(IllegalArgumentException.class, () -> {
            ValidationUtils.validateTryCount(tryCount);
        });
    }

    @Test
    @DisplayName("이동 횟수가 최대 값을 초과할 경우 예외를 던진다")
    void shouldThrowExceptionWhenTryCountExceedsMax() {
        int tryCount = 1001;
        assertThrows(IllegalArgumentException.class, () -> {
            ValidationUtils.validateTryCount(tryCount);
        });
    }
}
