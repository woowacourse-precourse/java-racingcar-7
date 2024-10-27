package racingcar.view.input;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.exception.view.CarNameInputErrorMessages;

import static org.junit.jupiter.api.Assertions.*;

class CarNameInputTest {
    @Test
    @DisplayName("입력된 자동차 이름이 유효하면 자동차 리스트 생성 테스트")
    void 입력된_자동차_이름이_유효하면_자동차_리스트_생성() {
        // given
        String carName = "pobi,woni,jun";

        // when
        CarNameInput carNameInput = new CarNameInput();

        // then
        assertDoesNotThrow(() -> carNameInput.process(carName));
    }

    @Test
    @DisplayName("입력된 자동차 이름이 빈 문자열이면 예외 발생 테스트")
    void 입력된_자동차_이름이_빈_문자열이면_예외_발생() {
        // given
        String carName = "";

        // when
        CarNameInput carNameInput = new CarNameInput();

        // then
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> carNameInput.process(carName));
        assertEquals(CarNameInputErrorMessages.INPUT_IS_EMPTY.getMessage(), exception.getMessage());
    }

    @Test
    @DisplayName("자동차 이름이 5자를 초과하면 예외 발생 테스트")
    void 자동차_이름이_5자를_초과하면_예외_발생() {
        // given
        String carName = "pobi,woni,junnnnn";

        // when
        CarNameInput carNameInput = new CarNameInput();

        // then
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> carNameInput.process(carName));
        assertEquals(CarNameInputErrorMessages.CAR_NAME_INVALID_LENGTH.getMessage(), exception.getMessage());
    }

    @Test
    @DisplayName("자동차 이름이 소문자 영어가 아니라면 예외 발생 테스트")
    void 자동차_이름이_소문자_영어가_아니라면_예외_발생() {
        // given
        String carName = "pobi,wonI,junnnnn";

        // when
        CarNameInput carNameInput = new CarNameInput();

        // then
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> carNameInput.process(carName));
        assertEquals(CarNameInputErrorMessages.CAR_NAME_NOT_LOWERCASE.getMessage(), exception.getMessage());
    }

    @Test
    @DisplayName("자동차 이름에 공백이 있으면 예외 발생 테스트")
    void 자동차_이름에_공백이_있으면_예외_발생() {
        // given
        String carName = "pobi,wo n";

        // when
        CarNameInput carNameInput = new CarNameInput();

        // then
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> carNameInput.process(carName));
        assertEquals(CarNameInputErrorMessages.INPUT_CONTAINS_WHITESPACE.getMessage(), exception.getMessage());
    }

    @Test
    @DisplayName("중복된 자동차 이름이 있으면 예외 발생 테스트")
    void 중복된_자동차_이름이_있으면_예외_발생() {
        // given
        String carName = "pobi,jun,pobi";

        // when
        CarNameInput carNameInput = new CarNameInput();

        // then
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> carNameInput.process(carName));
        assertEquals(CarNameInputErrorMessages.CAR_NAME_DUPLICATE.getMessage(), exception.getMessage());
    }

    @Test
    @DisplayName("쉼표가 아닌 다른 구분자가 있으면 예외 발생 테스트")
    void 쉼표가_아닌_다른_구분자가_있으면_예외_발생() {
        // given
        String carName = "pobi,wonI:jin";

        // when
        CarNameInput carNameInput = new CarNameInput();

        // then
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> carNameInput.process(carName));
        assertEquals(CarNameInputErrorMessages.INPUT_CONTAINS_INVALID_DELIMITER.getMessage(), exception.getMessage());
    }

    @Test
    @DisplayName("문자열이 쉼표로 끝나면 예외 발생 테스트")
    void 문자열이_쉼표로_끝나면_예외_발생() {
        // given
        String carName = "kim,jung,";  // 쉼표 뒤에 빈 문자열

        // when
        CarNameInput carNameInput = new CarNameInput();

        // then
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> carNameInput.process(carName));
        assertEquals(CarNameInputErrorMessages.INPUT_CONTAINS_WHITESPACE.getMessage(), exception.getMessage());
    }
}