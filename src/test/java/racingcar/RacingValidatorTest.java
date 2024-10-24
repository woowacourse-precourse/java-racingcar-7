package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.util.RacingValidator;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class RacingValidatorTest {

    @DisplayName("참여자가 1명일 때 오류 테스트")
    @Test
    void isTwoOrMore() {
        String input = "pobi";
        assertThatThrownBy(() -> RacingValidator.isCarNameInput(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("이름의 길이가 5자 이상일 경우 오류 테스트")
    @Test
    void isNameLengthFiveOrMore() {
        String input = "pobi,javaji,1";
        assertThatThrownBy(() -> RacingValidator.isCarNameInput(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("이름의 길이가 비어있을 경우 오류 테스트")
    @Test
    void inNameLengthEmpty() {
        String input = ",test,21";
        assertThatThrownBy(() -> RacingValidator.isCarNameInput(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

}
