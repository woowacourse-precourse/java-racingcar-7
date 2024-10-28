package racingcar.validator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class NumberValidatorTest {
    /** 테스트 클래스 명 -> [메서드 명]_[테스트 중 상태]_[기대 행위] **/
    @ParameterizedTest
    @ValueSource(ints = {0, -1, -2, -3, -10, -100})
    @DisplayName("주어진 횟수를 양수로 입력하지 않으면 예외 발생")
    void inputPositiveNumber_NotInputtedPositiveNumber_ExceptionThrown(int number){
        //given
        final String expectedMessage = "시도할 횟수를 양수로 입력해주세요";
        final NumberValidator numberValidator = new NumberValidator();

        //when & then
        assertThatThrownBy(() -> numberValidator.inputPositiveNumber(number))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(expectedMessage);
    }
}
