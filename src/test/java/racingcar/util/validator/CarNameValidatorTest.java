package racingcar.util.validator;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatCode;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class CarNameValidatorTest {
    private CarNameValidator validator;

    @BeforeEach
    void setUp() {
        validator = new CarNameValidator();
    }

    @Nested
    class invalidInputTest {
        @DisplayName("2개 미만의 이름은 예외 처리")
        @ParameterizedTest
        @ValueSource(strings = {"버피", "우텍호"})
        void 이름_개수_테스트(String input) {
            assertThatThrownBy(() -> validator.validate(input))
                    .isInstanceOf(IllegalArgumentException.class);
        }

        @DisplayName("6글자 이상의 이름은 예외 처리")
        @ParameterizedTest
        @ValueSource(strings = {"가나다라마바사,뿌우", "기차칙칙폭폭,버피아주아주사랑해"})
        void 이름_길이_테스트(String input) {
            assertThatThrownBy(() -> validator.validate(input))
                    .isInstanceOf(IllegalArgumentException.class);
        }

        @DisplayName("맨 마지막 자동차 이름 뒤에 ,로 끝나는 경우 예외 처리")
        @ParameterizedTest
        @ValueSource(strings = {"버피,윤정,혜선,"})
        void 이름_끝_콤마_테스트(String input) {
            assertThatThrownBy(() -> validator.validate(input))
                    .isInstanceOf(IllegalArgumentException.class);
        }

        @DisplayName("맨 처음에 ,로 시작하는 경우 예외 처리")
        @ParameterizedTest
        @ValueSource(strings = {",윤정,혜선"})
        void 콤마_시작_이름_테스트(String input) {
            assertThatThrownBy(() -> validator.validate(input))
                    .isInstanceOf(IllegalArgumentException.class);
        }

        @DisplayName("이름들 사이에 ,가 두 개 연속으로 나오는 경우 예외 처리")
        @ParameterizedTest
        @ValueSource(strings = {"윤성빈,,아모띠", "파워리프팅,,하이"})
        void 이름_중간_두_콤마_테스트(String input) {
            assertThatThrownBy(() -> validator.validate(input))
                    .isInstanceOf(IllegalArgumentException.class);
        }
    }

    @Nested
    class validInputTest {
        @DisplayName("정상적인 입력은 예외가 발생하지 않음")
        @ParameterizedTest
        @ValueSource(strings = {"버피,버핑,우테코"})
        void 정상_입력(String input) {
            assertThatCode(() -> validator.validate(input))
                    .doesNotThrowAnyException();
        }
    }
}