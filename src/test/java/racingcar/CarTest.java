package racingcar;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator.ReplaceUnderscores;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

@SuppressWarnings("NonAsciiCharacters")
@DisplayNameGeneration(ReplaceUnderscores.class)
@DisplayName("자동차 테스트")
class CarTest {

    @Nested
    class 이름_테스트 {
        @ParameterizedTest
        @ValueSource(strings = {
                "",
                "다섯글자초과",
        })
        void 이름이_1글자_미만_혹은_5글자_초과라면_예외(String invalidName) {
            // when & then
            assertThatThrownBy(() -> {
                new Car(invalidName);
            }).isInstanceOf(IllegalArgumentException.class);
        }

        @ParameterizedTest
        @CsvSource(value = {
                "김 정 재 -> 김정재",
                " 김  정   재   -> 김정재",
                "김정재 -> 김정재",
        }, delimiterString = " -> ")
        void 이름에_공백이_포함되면_해당_공백은_제거된다(String inputName, String expected) {
            // when
            Car car = new Car(inputName);

            // then
            assertThat(car.getName()).isEqualTo(expected);
        }
    }

    @Nested
    class 전진_테스트 {

        @Test
        void 전진한다() {
            // given
            Car car = new Car("김정재");

            // when
            car.go(GoingValue.GO);

            // then
            assertThat(car.getPosition()).isEqualTo(1);
        }

        @Test
        void 전진하지_않는다() {
            // given
            Car car = new Car("김정재");

            // when
            car.go(GoingValue.STOP);

            // then
            assertThat(car.getPosition()).isEqualTo(0);
        }
    }
}
