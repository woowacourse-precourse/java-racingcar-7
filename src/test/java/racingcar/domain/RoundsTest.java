package racingcar.domain;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class RoundsTest {

    NumberGenerator forwardGenerator = () -> 4;
    NumberGenerator stopGenerator = () -> 3;

    @DisplayName("시도할 횟수 입력 실패 : 문자 입력")
    @Test
    void toIntTest() {
        String rawCount = "a";

        Assertions.assertThatThrownBy(() -> new Rounds(rawCount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("시도할 횟수로 숫자를 입력해주세요.");
    }

    @DisplayName("시도할 횟수 입력 실패 : 음수 혹은 0 입력")
    @ParameterizedTest
    @ValueSource(strings = {"-1", "0"})
    void validatePositiveTest(String rawCount) {

        Assertions.assertThatThrownBy(() -> new Rounds(rawCount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("시도할 횟수로 양수를 입력해주세요.");
    }

    @DisplayName("라운드 반복 성공")
    @Test
    void repeatTest() {
        //given
        Car pobi = new Car("pobi", forwardGenerator);
        Car woni = new Car("woni", stopGenerator);
        List<Car> cars = List.of(pobi, woni);
        Race race = new Race(cars);
        Rounds rounds = new Rounds("3");

        //when
        rounds.repeat(race::moveAll);

        //then
        Assertions.assertThat(pobi.getDistance()).isEqualTo(3);
    }
}
