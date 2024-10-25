package racingcar.unittest;

import static org.assertj.core.api.Assertions.assertThatCode;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.Validator;

class ValidatorTest extends NsTest {

    @Test
    @DisplayName("유효한 자동차 이름 검증 테스트")
    void validateCarNames_withValidNames_shouldPass() {
        // Given
        String[] names = {"pobi", "crong", "honux"};

        // When & Then
        assertThatCode(() -> Validator.validateCarNames(names))
                .doesNotThrowAnyException();
    }

    @Override
    public void runMain() {
    }
}
