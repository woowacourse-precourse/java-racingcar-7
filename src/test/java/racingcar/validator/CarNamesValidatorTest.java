package racingcar.validator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static racingcar.exception.ErrorMessage.EMPTY_INPUT;
import static racingcar.exception.ErrorMessage.EMPTY_CAR_NAME;
import static racingcar.exception.ErrorMessage.TOO_LONG_NAME;
import static racingcar.exception.ErrorMessage.DUPLICATION;

@DisplayName("[CarNamesValidator Test]")
public class CarNamesValidatorTest {

    @Nested
    @DisplayName("리스트가 비어있는 지 확인한다")
    class validateEmptyInputTest {

        @Test
        @DisplayName("리스트가 공백이 아닌 정상적인 값이라면 통과한다")
        void Given_ValidCarNames_When_validateEmptyInput_Then_DoNothing() {
            //given
            List<String> carNames = new ArrayList<>(Arrays.asList("뽀뚜","보뚜"));

            //when & then
            assertDoesNotThrow(() -> CarNamesValidator.validate(carNames));
        }

        @Test
        @DisplayName("리스트가 비어있다면 예외를 던진다")
        void Given_Empty_When_validateEmptyInput_Then_ThrowException() {
            //given
            List<String> carNames = new ArrayList<>();

            //when & then
            assertThatThrownBy(() -> CarNamesValidator.validate(carNames))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining(EMPTY_INPUT.getMessage());
        }
    }

    @Nested
    @DisplayName("리스트 내의 원소(자동차 이름)가 옳바른지 확인한다")
    class validateListElementsTest {

        @Test
        @DisplayName("옳바른 자동차 이름이 원소로 들어온 경우 아무것도 하지 않는다")
        void Given_ValidCarNames_When_validateListElements_Then_DoNothing() {
            //given
            List<String> carNames = new ArrayList<>(Arrays.asList("뽀뚜","뚜보","커 비"));

            //when & then
            assertDoesNotThrow(() -> CarNamesValidator.validate(carNames));

        }

        @Test
        @DisplayName("자동차 이름으로 공백이 들어온 경우 예외를 던진다")
        void Given_EmptyCarNames_When_validateListElements_ThrowException() {
            //given
            List<String> carNames = new ArrayList<>(Arrays.asList("뽀뚜","보뚜","","  "));

            //when & then
            assertThatThrownBy(() -> CarNamesValidator.validate(carNames))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining(EMPTY_CAR_NAME.getMessage());

        }

        @Test
        @DisplayName("자동차 이름이의 길이가 5글자 초과인 경우 예외를 던진다")
        void Given_TooLongName_When_validateListElements_ThrowException() {
            //given
            List<String> carNames = new ArrayList<>(Arrays.asList("뽀뽀뽀뽀뚜뚜뚜","보뚜","뽀뚜"));

            //when & then
            assertThatThrownBy(() -> CarNamesValidator.validate(carNames))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining(TOO_LONG_NAME.getMessage());
        }

        @Test
        @DisplayName("동일한 이름이 두 번 들어온 경우 예외를 던진다")
        void Given_DuplicatedName_When_validateListElements_ThrowException() {
            //given
            List<String> carNames = new ArrayList<>(Arrays.asList("뽀뚜","보뚜","뽀뚜"));

            //when & then
            assertThatThrownBy(() -> CarNamesValidator.validate(carNames))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining(DUPLICATION.getMessage());
        }

    }
}
