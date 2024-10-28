package racingcar.domain.car;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.exception.car.InvalidCarNameException.NameLengthExceededExceptionInvalid;
import racingcar.exception.car.InvalidCarNameException.NameLengthShortExceptionInvalid;

@DisplayName("자동차 이름(Name) 유스케이스")
class NameTest {

    @Nested
    @DisplayName("생성 메서드")
    class 생성_메서드 {
        @DisplayName("생성_성공")
        @Test
        void 생성_성공() {
            // given
            final String sufficientLengthName = "kim";

            // expect
            assertThatCode(() -> Name.of(sufficientLengthName))
                    .doesNotThrowAnyException();
        }

        @DisplayName("생성_실패_Null")
        @Test
        void 생성_실패_Null() {
            // given
            final String Null = null;

            // expect
            assertThatThrownBy(() -> Name.of(Null))
                    .isInstanceOf(NullPointerException.class);
        }

        @DisplayName("생성_실패_이름길이초과")
        @Test
        void 생성_실패_이름길이초과() {
            // given
            final String elevenWords = "123456789**";

            // expect
            final String expectMessage = "자동차 이름은 최대 10자까지 가능합니다.";

            assertThatThrownBy(() -> {
                Name.of(elevenWords);
            })
                    .isInstanceOf(NameLengthExceededExceptionInvalid.class)
                    .hasMessage(expectMessage);
        }

        @DisplayName("생성_실패_이름길이미달")
        @ParameterizedTest
        @ValueSource(strings = {""})
        void 생성_실패_이름길이미달(String inSufficientLengthName) {
            //expect
            final String expectMessage = "자동차 이름은 최소 1자부터 가능합니다.";

            assertThatThrownBy(() -> {
                Name.of(inSufficientLengthName);
            })
                    .isInstanceOf(NameLengthShortExceptionInvalid.class)
                    .hasMessage(expectMessage);
        }

        @DisplayName("생성_성공_유효길이이름")
        @ParameterizedTest
        @ValueSource(strings = {"1", "22", "333", "4444", "55555", "666666", "7777777", "88888888", "!!!!!!!!!",
                "ㅌㅌㅌㅌㅌㅌㅌㅌㅌㅌ"})
        void 생성_성공_유효길이이름(String sufficientLengthName) {
            //expect
            assertThatCode(() -> Name.of(sufficientLengthName))
                    .doesNotThrowAnyException();
        }
    }
}