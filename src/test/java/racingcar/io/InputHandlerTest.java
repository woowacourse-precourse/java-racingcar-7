package racingcar.io;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class InputHandlerTest {

    @DisplayName("사용자는 자동차 이름 입력을 검증한다.")
    @Test
    void validateCarNamesInput() {
        //given
        InputHandler inputHandler = new InputHandler();
        //when
        //then
        assertThat(inputHandler.validateCarNames("pobi,crong,honux")).isTrue();
        assertThat(inputHandler.validateCarNames("pobi")).isTrue();
        assertThat(inputHandler.validateCarNames("++++,+;1343,---------")).isTrue();
        assertThatIllegalArgumentException().isThrownBy(
            () -> inputHandler.validateCarNames(null)
        ).withMessage("자동차 이름은 공백일 수 없습니다.");
        assertThatIllegalArgumentException().isThrownBy(
            () -> inputHandler.validateCarNames("")
        ).withMessage("자동차 이름은 공백일 수 없습니다.");
        assertThatIllegalArgumentException().isThrownBy(
            () -> inputHandler.validateCarNames("        ")
        ).withMessage("자동차 이름은 공백일 수 없습니다.");
        assertThatIllegalArgumentException().isThrownBy(
            () -> inputHandler.validateCarNames("pobi, crong, honux,")
        ).withMessage("자동차 이름과 쉼표만 입력해주세요. 공백은 사용 할 수 없습니다.");
        assertThatIllegalArgumentException().isThrownBy(
            () -> inputHandler.validateCarNames("pobi, crong, honux")
        ).withMessage("자동차 이름과 쉼표만 입력해주세요. 공백은 사용 할 수 없습니다.");
        assertThat(inputHandler.validateCarNames(",,,,,,,,,,")).isTrue();

    }

}