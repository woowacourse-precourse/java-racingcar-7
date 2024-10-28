package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.Validator.CarNameValidator;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CarNameValidatorTest {
    /** 테스트 클래스 명 -> [메서드 명]_[테스트 중 상태]_[기대 행위] **/
    @ParameterizedTest
    @ValueSource(strings = {"123456", "BMW X5 M", "Porsche", "Ferrari"})
    @DisplayName("이름을 5자 이하로 작성하지 않았으면 예외 발생")
    void inputNotMoreThanFiveCharacter_InputtedOverFiveCharacter_ExceptionThrown(String carNames){
        //given
        final String expectedMessage = "이름을 5자 이하로 입력해주세요";
        final CarNameValidator carNameValidator = new CarNameValidator();

        //when & then
        assertThatThrownBy(() -> carNameValidator.inputNotMoreThanFiveCharacter(carNames))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(expectedMessage);
    }
}
