package racingcar.model;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatCode;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class TryCountTest {
    @ParameterizedTest
    @ValueSource(strings = {"가", "0", "-1"})
    void 시도할_횟수_생성에_실패한다(String count) {
        assertThatThrownBy(() -> new TryCount(count))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 시도할_횟수_생성에_성공한다() {
        String count = "5";
        assertThatCode(() -> new TryCount(count))
                .doesNotThrowAnyException();
    }
}
