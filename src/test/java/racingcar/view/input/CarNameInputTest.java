package racingcar.view.input;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

class CarNameInputTest {
    @Test
    @DisplayName("입력된 자동차 이름이 유효하면 자동차 리스트 생성")
    void 입력된_자동차_이름이_유효하면_자동차_리스트_생성() {
        // given
        String input = "pobi,woni,jun";

        // when
        CarNameInput carNameInput = new CarNameInput();

        // then
        assertDoesNotThrow(() -> carNameInput.processInput(input));
    }

    @Test
    @DisplayName("자동차 이름이 5자를 초과하면 예외 발생")
    void 자동차_이름이_5자를_초과하면_예외_발생() {
        // given
        String input = "pobi,woni,junnnnn";

        // when
        CarNameInput carNameInput = new CarNameInput();

        // then
        assertThrows(IllegalArgumentException.class, () -> carNameInput.processInput(input));
    }

    @Test
    @DisplayName("자동차 이름이 소문자 영어가 아니라면 예외 발생")
    void 자동차_이름이_소문자_영어가_아니라면_예외_발생() {
        // given
        String input = "pobi,wonI,junnnnn";

        // when
        CarNameInput carNameInput = new CarNameInput();

        // then
        assertThrows(IllegalArgumentException.class, () -> carNameInput.processInput(input));
    }

    @Test
    @DisplayName("자동차 이름에 공백이 있으면 예외 발생")
    void 자동차_이름에_공백이_있으면_예외_발생() {
        // give
        String input = "pobi,wo n";

        // when
        CarNameInput carNameInput = new CarNameInput();

        // then
        assertThrows(IllegalArgumentException.class, () -> carNameInput.processInput(input));
    }

    @Test
    @DisplayName("중복된 자동차 이름이 있으면 예외 발생")
    void 중복된_자동차_이름이_있으면_예외_발생() {
        // given
        String input = "pobi,jun,pobi";

        // when
        CarNameInput carNameInput = new CarNameInput();

        // then
        assertThrows(IllegalArgumentException.class, () -> carNameInput.processInput(input));
    }

    @Test
    @DisplayName("쉼표가 아닌 다른 구분자가 있으면 예외 발생")
    void 쉼표가_아닌_다른_구분자가_있으면_예외_발생() {
        // given
        String input = "pobi,wonI:jin";

        // when
        CarNameInput carNameInput = new CarNameInput();

        // then
        assertThrows(IllegalArgumentException.class, () -> carNameInput.processInput(input));
    }
}
