package racingcar;

import java.util.List;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class InputValidatorTest {

    @Test
    void 자동차_이름_검증_테스트() {
        // 비어 있는 입력값
        assertThatThrownBy(() -> InputValidator.validateNames(""))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동차 이름을 입력해 주세요.");

        // 콤마 이후 빈 입력값
        assertThatThrownBy(() -> InputValidator.validateNames("pobi, "))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동차 이름은 빈 값일 수 없습니다.");

        // 5자 초과일 경우 예외 발생
        assertThatThrownBy(() -> InputValidator.validateNames("pobi,javaji"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동차 이름은 5자 이하여야 합니다.");

        // 쉼표가 없는 단일 입력값
        List<String> carNames = InputValidator.validateNames("pobi");
        assertThat(carNames).containsExactly("pobi");

        // 정상일 경우 이름 리스트 반환
        List<String> validCarNames = InputValidator.validateNames("pobi,woni,jun");
        assertThat(validCarNames).containsExactly("pobi", "woni", "jun");
    }
        assertThatThrownBy(() ->
                InputValidator.validateNames("pobi,javaji")
        ).isInstanceOf(IllegalArgumentException.class).hasMessage("자동차 이름은 5자 이하여야 합니다.");

        // 정상일 경우 이름 리스트 반환
        List<String> carNames = InputValidator.validateNames("pobi,woni,jun");
        assertThat(carNames).containsExactly("pobi", "woni", "jun");
    }
}
