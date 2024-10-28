package racingcar;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarArgumentResolverTest {

    private static final String ERROR_MESSAGE = "비어있는 입력은 불가능합니다.";

    CarArgumentResolver carArgumentResolver = new CarArgumentResolver();

    @Test
    @DisplayName("자동차 이름 String이 주어졌을 때 ,를 기준으로 정상 parse")
    public void parse_테스트() {
        // given
        String rawCarNames = "a,b,c";

        // when
        List<String> carNames = carArgumentResolver.parse(rawCarNames);

        // then
        assertThat(carNames).contains("a");
        assertThat(carNames).contains("b");
        assertThat(carNames).contains("c");
    }

    @Test
    @DisplayName("앞뒤로 공백이 있을 경우, 공백을 제거하고 정상 parse")
    public void parse_trim_테스트() {
        // given
        String rawCarNames = " a , b , c ";

        // when
        List<String> carNames = carArgumentResolver.parse(rawCarNames);

        // then
        assertThat(carNames).contains("a");
        assertThat(carNames).contains("b");
        assertThat(carNames).contains("c");
    }

    @Test
    @DisplayName("구분자가 앞에 있을 경우 살려서 정상 parse")
    public void parseSplitWithBlankFront_테스트() {
        // given
        String rawCarNames = ",b";

        // when
        List<String> carNames = carArgumentResolver.parse(rawCarNames);

        // then
        assertThat(carNames).contains("");
        assertThat(carNames).contains("b");
    }

    @Test
    @DisplayName("구분자가 뒤에 있을 경우 살려서 정상 parse")
    public void parseSplitWithBlankBack_테스트() {
        // given
        String rawCarNames = "b,";

        // when
        List<String> carNames = carArgumentResolver.parse(rawCarNames);

        // then
        assertThat(carNames).contains("");
        assertThat(carNames).contains("b");
    }

    @Test
    @DisplayName("비어있거나 null 값이 입력으로 주어질 때 에러 발생")
    void parse_비어있는_값이_입력으로_주어질_때() {
        // given
        String nullString = null;
        String emptyString = "";

        // when & then
        assertThatThrownBy(() -> carArgumentResolver.parse(nullString))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ERROR_MESSAGE);

        assertThatThrownBy(() -> carArgumentResolver.parse(emptyString))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ERROR_MESSAGE);
    }

}