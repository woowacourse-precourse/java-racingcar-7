package racingcar.view;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.Assertions.assertThat;
import java.util.List;

public class CarNameInputValidatorTest {

    private final CarNameInputValidator validator = new CarNameInputValidator();

    @DisplayName("유효한 자동차 이름 목록을 입력할 경우 정확한 이름 목록 반환")
    @Test
    void validCarNames() {
        String input = "car1,car2,car3";
        List<String> carNames = validator.validateCarNames(input);

        assertThat(carNames).containsExactly("car1", "car2", "car3");
    }

    @DisplayName("빈 이름이 포함된 경우 IllegalArgumentException 발생")
    @Test
    void emptyNameThrowsException() {
        String input = "car1,,car3";

        assertThatThrownBy(() -> validator.validateCarNames(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동차 이름은 빈 문자열일 수 없습니다.");
    }


    @DisplayName("자동차 이름이 최대 길이를 초과하는 경우 IllegalArgumentException 발생")
    @Test
    void nameTooLongThrowsException() {
        String input = "car1,car2,car12345";

        assertThatThrownBy(() -> validator.validateCarNames(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동차 이름은 1자 이상 5자 이하여야 합니다.");
    }

    @DisplayName("중복된 자동차 이름이 포함된 경우 IllegalArgumentException 발생")
    @Test
    void duplicateNameThrowsException() {
        String input = "car1,car2,car1";

        assertThatThrownBy(() -> validator.validateCarNames(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("동일한 이름의 자동차가 있을 수 없습니다.");
    }
}
