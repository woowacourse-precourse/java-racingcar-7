package racingcar.application.util.validator;

import racingcar.application.util.io.vo.Input;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class InputValidatorTest {

    @Nested
    @DisplayName("[입력값 - 검증 성공 테스트]")
    class 입력값_검증_성공_테스트 {

        @ParameterizedTest(name = "({index}) {0}")
        @ValueSource(
                strings = {
                        "pobi,jun,woni", "  pobi , jun  ,  woni  ", "pobi", " pobi ",
                        "12Car, Car12", "=지존=", "-붕붕이-"
                }
        )
        @DisplayName("올바른 형식으로 이름을 입력할 경우, 정상 종료")
        void 올바른_형식의_이름_입력_성공(String availableNamesInput) {
            // given
            Input input = new Input(availableNamesInput);

            // when & then
            assertThatCode(() -> InputValidator.validateNamesInput(input))
                    .doesNotThrowAnyException();
        }

        @ParameterizedTest(name = "({index}) {0}")
        @ValueSource(
                strings = {
                        "0", "9", "123", "123456789"
                }
        )
        @DisplayName("올바른 형식으로 시도횟수를 입력할 경우, 정상 종료")
        void 올바른_형식의_시도횟수_입력_성공(String availableTrialInput) {
            // given
            Input input = new Input(availableTrialInput);

            // when & then
            assertThatCode(() -> InputValidator.validateTrialInput(input))
                    .doesNotThrowAnyException();
        }

    }

    @Nested
    @DisplayName("[입력값 - 검증 실패 테스트]")
    class 입력값_검증_실패_테스트 {

        @ParameterizedTest(name = "({index}) {0} ==> IllegalArgumentException")
        @ValueSource(
                strings = {
                        "   ", "\n", ",woni,jun", ",,,", ",woni,", "pobi,pobi,pobi"
                }
        )
        @DisplayName("잘못된 형식으로 이름을 입력할 경우, IllegalArgumentException 발생")
        void 잘못된_형식의_이름_입력_예외_발생(String invalidNamesInput) {
            // given
            Input input = new Input(invalidNamesInput);

            // when & then
            assertThatThrownBy(() -> InputValidator.validateNamesInput(input))
                    .isInstanceOf(IllegalArgumentException.class);
        }

        @ParameterizedTest(name = "({index}) {0} ==> IllegalArgumentException")
        @ValueSource(
                strings = {
                        "  ", " \n ", "abced", "1abc", "123ㄱ", "ㄱㄴㄷ", "-()="
                }
        )
        @DisplayName("잘못된 형식으로 시도횟수를 입력할 경우, IllegalArgumentException 발생")
        void 잘못된_형식의_시도횟수_입력_예외_발생(String invalidTrialInput) {
            // given
            Input input = new Input(invalidTrialInput);

            // when & then
            assertThatThrownBy(() -> InputValidator.validateTrialInput(input))
                    .isInstanceOf(IllegalArgumentException.class);
        }

    }

}