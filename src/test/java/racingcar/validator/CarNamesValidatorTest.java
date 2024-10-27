package racingcar.validator;

import java.util.ArrayList;
import java.util.Arrays;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

@DisplayName("[CarNamesValidator Test]")
public class CarNamesValidatorTest {

    @Nested
    @DisplayName("어레이리스트가 비어있는 지 확인한다")
    class validateEmptyInputTest {

        @Test
        @DisplayName("어레이리스트가 공백이 아닌 정상적인 값이라면 통과한다")
        void Given_ValidCarNames_When_validateEmptyInput_Then_DoNothing() {
            //given
            ArrayList<String> carNames = new ArrayList<>(Arrays.asList("뽀뚜","보뚜"));

            //when & then
            assertDoesNotThrow(() -> CarNamesValidator.validate(carNames));
        }

        @Test
        @DisplayName("어레이가 비어있다면 예외를 던진다")
        void Given_Empty_When_validateEmptyInput_Then_ThrowException() {
            //given
            ArrayList<String> carNames = new ArrayList<>();

            //when & then
            assertThatThrownBy(() -> CarNamesValidator.validate(carNames));
        }
    }

    @Nested
    @DisplayName("어레이리스트 내의 원소가 옳바른지 확인한다")
    class validateListElementsTest {

        @Test
        @DisplayName("자동차 이름으로 공백이 들어온 경우 예외를 던진다")
        void Given_ValidCarNames_When_validateListElements_ThrowException() {
            //given
            ArrayList<String> carNames = new ArrayList<>(Arrays.asList("뽀뚜","보뚜","","  "));

            //when & then
            assertThatThrownBy(() -> CarNamesValidator.validate(carNames));

        }

        @Test
        @DisplayName("자동차 이름이의 길이가 5글자 초과인 경우 예외를 던진다")
        void Given_TooLongName_When_validateListElements_ThrowException() {
            //given
            ArrayList<String> carNames = new ArrayList<>(Arrays.asList("뽀뽀뽀뽀뚜뚜뚜","보뚜","뽀뚜"));

            //when & then
            assertThatThrownBy(() -> CarNamesValidator.validate(carNames));
        }

        @Test
        @DisplayName("동일한 이름이 두 번 들어온 경우 예외를 던진다")
        void Given_DuplicatedName_When_validateListElements_ThrowException() {
            //given
            ArrayList<String> carNames = new ArrayList<>(Arrays.asList("뽀뚜","보뚜","뽀뚜"));

            //when & then
            assertThatThrownBy(() -> CarNamesValidator.validate(carNames));
        }

    }
}
