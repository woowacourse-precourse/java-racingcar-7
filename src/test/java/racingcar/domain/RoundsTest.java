package racingcar.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RoundsTest {

    @DisplayName("시도할 횟수 입력 실패 : 문자 입력")
    @Test
    void toIntTest() {
        String rawCount = "a";

        Assertions.assertThatThrownBy(() -> new Rounds(rawCount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("시도할 횟수로 숫자를 입력해주세요.");
    }

    @DisplayName("라운드 반복 성공")
    @Test
    void repeatTest() {
        Race race = new Race("pobi", () -> 4);
        Rounds rounds = new Rounds("3");

        rounds.repeat(race::moveAll);

        Assertions.assertThat(race.getCars().get(0).getDistance()).isEqualTo(3);
    }
}
