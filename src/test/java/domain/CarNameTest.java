package domain;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import domain.car.CarName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
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
            assertEquals(validName, carName.getName());
        }

        @Test
        void 이름이_빈_문자열일_때_CarName_객체를_생성할_수_없다() {
            // given
            String blankName = "   ";

            // when & then
            IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                    () -> CarName.from(blankName));

            assertEquals(ErrorMessage.BLANK_INPUT_NOT_ALLOWED.getMessage(), exception.getMessage());
        }

        @Test
        void 이름이_5자를_초과할_때_객체를_생성할_수_없다() {
            // given
            String longName = "LongName";

            // when & then
            IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                    () -> CarName.from(longName));

            assertEquals(ErrorMessage.INVALID_NAME_LENGTH.getMessage(), exception.getMessage());
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