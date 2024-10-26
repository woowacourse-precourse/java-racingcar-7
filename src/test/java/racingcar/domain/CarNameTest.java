package racingcar.domain;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

@SuppressWarnings("NonAsciiCharacters")
class CarNameTest {

    @ParameterizedTest
    @ValueSource(strings = {"pobi", "??", "11", "가가", "\\n", "aaaaa"})
    void 다섯_글자_이하의_이름이_전달된다(String name) {
        // given
        CarName carName = new CarName(name);

        // when & then
        assertEquals(name, carName.getCarName());
    }

    @ParameterizedTest
    @ValueSource(strings = {"pobiii", "??????", "111111", "가가가가가가", "\\n\\n\\n"})
    void 여섯_글자_이상의_이름이_전달된다(String name) {
        // given
        String expected = "자동차 이름은 5글자를 넘을 수 없습니다.";

        // when
        IllegalArgumentException actual = assertThrows(IllegalArgumentException.class,
                () -> new CarName(name));

        // then
        assertEquals(expected, actual.getMessage());
    }
}
