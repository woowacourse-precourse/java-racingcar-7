package domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import domain.car.CarName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.enums.ErrorMessage;

class CarNameTest {

    @Nested
    class CarName_생성_테스트 {

        @Test
        void 유효한_이름으로_CarName_객체를_생성할_수_있다() {
            // given
            String validName = "pobi";

            // when
            CarName carName = CarName.from(validName);

            // then
            assertThat(validName).isEqualTo(carName.getName());
        }

        @Test
        void 이름이_빈_문자열일_때_CarName_객체를_생성할_수_없다() {
            // given
            String blankName = "   ";

            // when & then
            assertThatThrownBy(() -> CarName.from(blankName))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage(ErrorMessage.BLANK_INPUT_NOT_ALLOWED.getMessage());
        }

        @Test
        void 이름이_5자를_초과할_때_객체를_생성할_수_없다() {
            // given
            String longName = "LongName";

            // when & then
            assertThatThrownBy(() -> CarName.from(longName))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage(ErrorMessage.INVALID_NAME_LENGTH.getMessage());
        }

        @ParameterizedTest
        @ValueSource(strings = {"a\\n", "b\\t", "c\\r", "d\\b"})
        void 이름에_제어_문자가_포함될_경우_CarName_객체를_생성할_수_없다(String invalidName) {
            // when & then

            assertThatThrownBy(() -> CarName.from(invalidName))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage(ErrorMessage.INVALID_SPECIAL_CHARACTER.getMessage());
        }
    }

    @Nested
    class CarName_동등성_테스트 {

        @Test
        void 동일한_이름을_가진_CarName_객체는_동일하다() {
            // given
            String name = "povi";
            CarName carName1 = CarName.from(name);
            CarName carName2 = CarName.from(name);

            // when & then
            assertEquals(carName1, carName2);
            assertEquals(carName1.hashCode(), carName2.hashCode());
        }

        @Test
        void 다른_이름을_가진_CarName_객체는_동일하지_않다() {
            // given
            CarName carName1 = CarName.from("povi");
            CarName carName2 = CarName.from("woni");

            // when & then
            assertNotEquals(carName1, carName2);
        }
    }
}