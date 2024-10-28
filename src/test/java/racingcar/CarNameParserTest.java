package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CarNameParserTest {
    @Test
    @DisplayName("정상적인 경우 파싱")
    void 기능_테스트1() {
        // given
        String input = "car1,car2,car3";

        // when
        List<String> result = CarNameParser.parse(input);

        // then
        assertThat(result)
                .containsExactly("car1", "car2", "car3");
    }

    @Test
    @DisplayName("비어있거나 공백만 있는 이름의 경우 무명+숫자로 대체")
    void 기능_테스트2() {
        // given
        String input = "car1,,car2,           ,car3";

        // when
        List<String> result = CarNameParser.parse(input);

        // then
        assertThat(result)
                .containsExactly("car1", "무명1", "car2", "무명2", "car3");
    }

    @Test
    @DisplayName("앞 뒤 공백이 있는 이름의 경우 공백 제거")
    void 기능_테스트3() {
        // given
        String input = " car1, car2,car3, car4 ";

        // when
        List<String> result = CarNameParser.parse(input);

        // then
        assertThat(result)
                .containsExactly("car1", "car2", "car3", "car4");
    }

    @Test
    @DisplayName("null 입력시 예외 발생")
    void 예외_테스트1() {
        // given
        String input = null;

        assertThatThrownBy(() -> CarNameParser.parse(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("경기에 진행할 자동차가 존재하지 않습니다");
    }

    @Test
    @DisplayName("5자를 초과하는 이름이 있으면 예외 발생")
    void 예외_테스트2() {
        // given
        String input = "four,five5,sixsix";

        assertThatThrownBy(() -> CarNameParser.parse(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("자동차의 이름은 5자를 초과할 수 없습니다");
    }
}
