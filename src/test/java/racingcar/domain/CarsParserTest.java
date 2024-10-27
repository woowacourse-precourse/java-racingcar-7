package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class CarsParserTest {

    @Nested
    @DisplayName("parse() 테스트")
    class whenParse {

        @Test
        @DisplayName("정상적인 자동차 이름 문자열이 입력되면 성공적으로 자동차 리스트를 파싱한다.")
        void SuccessfullyParseCarList() {
            //given
            CarsParser carsParser = new CarsParser();
            String invalidCarNames = "song,park,lee,kim";

            //when then
            assertDoesNotThrow(() -> carsParser.parse(invalidCarNames));
        }

        @Nested
        @DisplayName("parse() 실패")
        class whenInvalidParse {

            @Test
            @DisplayName("자동차 이름의 갯수가 2개 미만이라면 예외를 발생시킨다.")
            void throwExceptionWhenLengthLessThanTwo() {
                //given
                CarsParser carsParser = new CarsParser();
                String invalidCarNames = "song";

                //when then
                assertThatThrownBy(() -> carsParser.parse(invalidCarNames))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage("경주를 하기 위해서는 두대 이상의 자동차가 필요합니다.");
            }

            @Test
            @DisplayName("중복된 이름이 포함된 입력이 들어오는 경우 예외를 반환한다.")
            void throwsExceptionWhenDuplicateCarNames() {
                //given
                CarsParser carsParser = new CarsParser();
                String invalidCarNames = "song,park,kim,song";

                //when then
                assertThatThrownBy(() -> carsParser.parse(invalidCarNames))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage("중복된 이름은 사용할 수 없습니다.");
            }
        }
    }
}
