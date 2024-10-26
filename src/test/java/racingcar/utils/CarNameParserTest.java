package racingcar.utils;

import static java.lang.String.format;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.List;

public class CarNameParserTest {

    @Nested
    @DisplayName("파싱 기능 테스트")
    class ParsingTest {
        @Test
        void 자동차_이름은_쉼표를_기준으로_구분한다() {
            // given
            final String input = "pobi,woni,jun";

            // when
            final List<String> carNames = CarNameParser.parse(input);

            // then
            assertThat(carNames).containsExactly("pobi", "woni", "jun");
        }
    }

    @Nested
    @DisplayName("Input 값 예외 처리")
    class InputTest {
        @Test
        void 사용자_입력_값이_구분자로_끝나면_예외처리() {
            // given
            final String DELIMITER = ",";
            final String input = "pobi,woni,jun,";

            // when, then
            assertThatThrownBy(() -> CarNameParser.parse(input))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage(format("[ERROR] 입력 값은 구분자(%s)로 끝날 수 없습니다.", DELIMITER));
        }

    }

    @Nested
    @DisplayName("자동차 이름 예외 처리")
    class CarNameTest {
        @Test
        void 자동차_이름이_5자_이하가_아니면_예외처리() {
            // given
            final String input = "pobi,woni,abcdef";

            // when, then
            assertThatThrownBy(() -> CarNameParser.parse(input))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage("[ERROR] 자동차 이름은 1글자 이상 5글자 이하여야 합니다.");
        }

        @Test
        void 자동차_이름이_빈_값으로_입력되면_예외처리() {
            // given
            final String input = "pobi,,woni";

            // when, then
            assertThatThrownBy(() -> CarNameParser.parse(input))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage("[ERROR] 자동차 이름은 1글자 이상 5글자 이하여야 합니다.");
        }

        @Test
        void 자동차_이름에_공백이_포함되면_예외처리() {
            // given
            final String input = "pobi ,woni, jun";

            // when, then
            assertThatThrownBy(() -> CarNameParser.parse(input))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage("[ERROR] 자동차 이름에는 공백이 포함될 수 없습니다.");
        }

        @Test
        void 중복된_자동차_이름이_있으면_예외처리() {
            // given
            final String input = "pobi,woni,jun,pobi";

            // when, then
            assertThatThrownBy(() -> CarNameParser.parse(input))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage("[ERROR] 중복된 자동차 이름이 존재합니다.");
        }
    }
}
