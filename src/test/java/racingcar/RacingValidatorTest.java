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
    void isNameLengthEmpty() {
        String input = ",test,21";
        assertThatThrownBy(() -> RacingValidator.isCarNameInput(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("이름이 중복일 경우 오류 테스트")
    @Test
    void isDuplicateName() {
        String input = "java,test,test";
        assertThatThrownBy(() -> RacingValidator.isCarNameInput(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("이동 횟수 입력이 숫자가 아닐 경우 오류 테스트")
    @Test
    void isValidMoveCount() {
        String input = "1,";
        assertThatThrownBy(() -> RacingValidator.isInteger(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

}
