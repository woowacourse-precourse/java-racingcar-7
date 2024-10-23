package racingcar;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Race 클래스 테스트")
public class RaceTest {

    @Test
    void 문자열을_파싱하여_자동차_객체를_생성한다() {
        // given
        String input = "pobi,woni,javaji";

        // when
        Race race = Race.from(input);

        // then
        Assertions.assertThat(race.getCars().size()).isEqualTo(3);
    }
}
