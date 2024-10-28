package racingcar.view;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import racingcar.exception.InputException;
import racingcar.mock.TestInputView;

class InputViewTest {
    @DisplayName("이름 입력")
    @Nested
    class 이름_입력 {
        @DisplayName("정상적인 이름 입력 시 이름 목록 반환")
        @Test
        void 정상적인_이름입력시_이름목록_반환() {
            // given
            String input = "p1,p2,p3";
            InputView inputView = new TestInputView(input);

            // when
            List<String> names = inputView.readNames();

            // then
            assertThat(names).containsExactly("p1", "p2", "p3");
        }

        @DisplayName("빈 문자열 입력 시도")
        @Test
        void 빈문자열_입력_시도() {
            // given
            String input = "";
            InputView inputView = new TestInputView(input);

            // when & then
            assertThatThrownBy(() -> inputView.readNames())
                    .isInstanceOf(InputException.InvalidNameFormatException.class);
        }

        @DisplayName("Null 입력 시도")
        @Test
        void Null_입력_시도() {
            // given
            String input = null;
            InputView inputView = new TestInputView(null);

            // when & then
            assertThatThrownBy(() -> inputView.readNames())
                    .isInstanceOf(InputException.InvalidNameFormatException.class);
        }
    }

    @DisplayName("라운드 수 입력")
    @Nested
    class 라운드_수_입력 {
        @DisplayName("정상적인_숫자입력시_라운드수_반환")
        @Test
        void 정상적인_숫자입력시_라운드수_반환() {
            // given
            String input = "5";
            InputView inputView = new TestInputView(input);

            // when
            int rounds = inputView.readRounds();

            // then
            assertThat(rounds).isEqualTo(5);
        }

        @DisplayName("숫자가 아닌 걸로 입력 시도")
        @Test
        void 숫자가_아닌걸로_입력_시도() {
            // given
            String input = "invalid";
            InputView inputView = new TestInputView(input);

            // when & then
            assertThatThrownBy(() -> inputView.readRounds())
                    .isInstanceOf(InputException.InvalidRoundInputException.class);
        }
    }
}