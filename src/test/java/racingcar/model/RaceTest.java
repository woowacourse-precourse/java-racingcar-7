package racingcar.model;

import static org.assertj.core.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RaceTest {

    @Test
    @DisplayName("자동차가 없는 경우 레이스는 빈 리스트를 반환해야 한다.")
    void 입력된_자동차가_없으면_빈리스트_반환() {
        Race race = new Race(List.of());
        assertThat(race.getWinners()).isEmpty();
    }
}
