package racingcar;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.utils.Validator;

public class ValidatorTest {
    @Test
    @DisplayName("자동차의 이름이 빈칸일 경우 예외가 발생한다")
    void check_name_empty() {
        String name = "";
        assertThatThrownBy(() -> Validator.isEmpty(name)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("자동차의 이름이 5글자 가 넘을 경우 예외가 발생한다")
    void check_name_range() {
        String name = "namerangefiveover";
        assertThatThrownBy(() -> Validator.isCarNameRange(name)).isInstanceOf(IllegalArgumentException.class);
    }
}
