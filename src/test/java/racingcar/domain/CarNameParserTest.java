package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

import java.util.List;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

@SuppressWarnings("NonAsciiCharacters")
class CarNameParserTest {

    @ParameterizedTest
    @NullAndEmptySource
    void 빈_문자열과_null_값이_입력된다(String name){
        // given
        String expected = "자동차 이름을 입력해주세요.";

        // when
        Throwable thrown = catchThrowable(() -> CarNameParser.parseCarNames(name));

        // then
        assertThat(thrown)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(expected);
    }

    @ParameterizedTest
    @ValueSource(strings = {"pobi,woni,jun", "가가,나나,다다", "11,22,33","??,\\n,**"})
    void 올바른_값이_입력된다(String name){
        // given
        List<CarName> names = CarNameParser.parseCarNames(name);

        // when & then
        assertThat(names).hasSize(3);
        assertThat(names)
                .extracting(CarName::getCarName)
                .containsExactly(name.split(","));
    }
}
