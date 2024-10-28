package racingcar;

import org.junit.jupiter.api.Test;
import java.util.List;
import static org.assertj.core.api.Assertions.*;

class WinnerDeterminerTest {

    @Test
    void 단일_우승자_결정_테스트() {
        List<String> winners = WinnerDeterminer.determineWinners(
                List.of("pobi", "crong", "honux"), List.of(3, 5, 2)
        );
        assertThat(winners).containsExactly("crong");
    }

    @Test
    void 공동_우승자_결정_테스트() {
        List<String> winners = WinnerDeterminer.determineWinners(
                List.of("pobi", "crong", "honux"), List.of(5, 5, 3)
        );
        assertThat(winners).containsExactly("pobi", "crong");
    }
}
