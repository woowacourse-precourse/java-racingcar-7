package racingcar.utils;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class ValidatorTest {
    @Test
    @DisplayName("유효한 자동차이름 배열 테스트")
    void testValidCarNames() {
        // Given: 유효한 자동차 이름 문자열
        String validCarNames = "car1,car2,car3";

        // When: 자동차 이름 검증 메서드 실행
        List<String> names = assertDoesNotThrow(() -> Validator.validateCarNames(validCarNames));

        // Then: 변형된 배열이 null이 아니고, 올바른 길이를 가지고 있어야 함.
        assertNotNull(names);
        assertEquals(3, names.size());
    }

    @DisplayName("유효하지 않은 자동차이름 배열 테스트")
    @ParameterizedTest
    @ValueSource(strings = {"car123456,car", ",,", ",sumi", "sumi,", "sumi,,"})
    void testInvalidCarNames(String names) {
        // Given: 유효하지 않은 자동차 이름 문자열
        // When: 자동차 이름 검증 메서드 실행
        // Then: IllegalArgumentException 발생해야 함.
        assertThatThrownBy(() -> Validator.validateCarNames(names)).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("유효한 시도 횟수 테스트")
    @ParameterizedTest
    @ValueSource(strings = {"5", "200", "1023"})
    void testValidAttemptCount(final String attempt) {
        // Given: 유효한 시도 횟수
        // When: 시도 횟수 검증 메서드 실행
        int count = assertDoesNotThrow(() -> Validator.validateAttemptCount(attempt));

        // Then: 반환된 횟수가 입력값과 동일해야 함.
        assertThat(count).isInstanceOf(Integer.class);
    }

    @DisplayName("유효하지 않은 시도 횟수 테스트")
    @ParameterizedTest
    @ValueSource(strings = {"-200", "0", "", "hi"})
    void testInvalidAttemptCount(final String attempt) {
        // Given: 유효하지 않은 시도 횟수
        // When: 시도 횟수 검증 메서드 실행
        // Then: IllegalArgumentException 발생해야 함.
        assertThatThrownBy(() -> Validator.validateAttemptCount(attempt)).isInstanceOf(IllegalArgumentException.class);
    }
}
