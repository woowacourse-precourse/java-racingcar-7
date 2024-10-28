package validator;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;

public class AttemptNumberTest {

    @Test
    void 입력값_예외_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> AttemptNumberValidator.checkAttempt("-2147483649"))
                        .isInstanceOf(IllegalArgumentException.class));

        assertSimpleTest(() ->
                assertThatThrownBy(() -> AttemptNumberValidator.checkAttempt("abc"))
                        .isInstanceOf(IllegalArgumentException.class));

        assertSimpleTest(() ->
                assertThatThrownBy(() -> AttemptNumberValidator.checkAttempt("2147483648"))
                        .isInstanceOf(IllegalArgumentException.class));

        assertSimpleTest(() ->
                assertThatThrownBy(() -> AttemptNumberValidator.checkAttempt("-1"))
                        .isInstanceOf(IllegalArgumentException.class));

        // 빈 문자열
        assertSimpleTest(() ->
                assertThatThrownBy(() -> AttemptNumberValidator.checkAttempt(""))
                        .isInstanceOf(IllegalArgumentException.class));

        // 공백 입력
        assertSimpleTest(() ->
                assertThatThrownBy(() -> AttemptNumberValidator.checkAttempt(" "))
                        .isInstanceOf(IllegalArgumentException.class));

        // 소수점 포함된 숫자
        assertSimpleTest(() ->
                assertThatThrownBy(() -> AttemptNumberValidator.checkAttempt("1.5"))
                        .isInstanceOf(IllegalArgumentException.class));

        // 특수 문자 포함된 입력
        assertSimpleTest(() ->
                assertThatThrownBy(() -> AttemptNumberValidator.checkAttempt("@123"))
                        .isInstanceOf(IllegalArgumentException.class));

    }

}
