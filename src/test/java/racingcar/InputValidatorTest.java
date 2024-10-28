package racingcar;

import java.util.List;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class InputValidatorTest {

    @Test
    void 자동차_이름_검증_테스트() {
        // 5자 초과일 경우 예외 발생
        assertThatThrownBy(() ->
                InputValidator.validateNames("pobi,javaji")
        ).isInstanceOf(IllegalArgumentException.class).hasMessage("자동차 이름은 5자 이하여야 합니다.");

        // 정상일 경우 이름 리스트 반환
        List<String> carNames = InputValidator.validateNames("pobi,woni,jun");
        assertThat(carNames).containsExactly("pobi", "woni", "jun");
    }
}
