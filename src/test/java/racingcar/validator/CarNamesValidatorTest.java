package racingcar.validator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CarNamesValidatorTest {
    /** 테스트 클래스 명 -> [메서드 명]_[테스트 중 상태]_[기대 행위] **/
    @ParameterizedTest
    @ValueSource(strings = {"Ahn;Seong;Mo", "Ahn,Seong;Mo", "Ahn/Seong,Mo"})
    @DisplayName("자동차 이름들을 쉼표(,)로 구분하지 않았으면 예외 발생")
    void separateByComma_NotSeparatedByComma_ExceptionThrown(String carNames) {
        //given
        final String expectedMessage = "쉼표(,)로 구분하여 자동차 이름들을 입력해주세요";
        final CarNamesValidator carNamesValidator = new CarNamesValidator();

        //when & then
        assertThatThrownBy(() -> carNamesValidator.separateByComma(carNames))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(expectedMessage);
    }

    @ParameterizedTest
    @ValueSource(strings = {"Ahn", "Ahn,"})
    @DisplayName("자동차 이름을 두 개 이상으로 입력하지 않았으면 예외 발생")
    void inputMoreThanTwo_NotInputtedMoreThanTwo_ExceptionThrown(String carNames) {
        //given
        final String expectedMessage = "자동차 이름을 두 개 이상으로 입력해주세요";
        final CarNamesValidator carNamesValidator = new CarNamesValidator();

        //when & then
        assertThatThrownBy(() -> carNamesValidator.inputMoreThanTwo(carNames))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(expectedMessage);
    }

    @Test
    @DisplayName("같은 이름을 입력하였으면 예외 발생")
    void inputSameName_InputtedSameName_ExceptionThrown() {
        //given
        final String carNames = "Ahn,Seong,Ahn";
        final String expectedMessage = "중복되지 않는 이름을 입력해주세요";
        final CarNamesValidator carNamesValidator = new CarNamesValidator();

        //when & then
        assertThatThrownBy(() -> carNamesValidator.inputSameName(carNames))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(expectedMessage);
    }
}
