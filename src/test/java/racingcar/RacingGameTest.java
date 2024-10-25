package racingcar;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;

import java.util.List;

public class RacingGameTest {   // 랜덤값을 사용하는 함수 제외한 테스트
    @Test
    void CreateRacingcars() {
        String[] carNames = {"pobi", "woni", "jun"};
        Racingcar[] racingcars = RacingGame.createRacingcars(carNames);
        assertThat(racingcars).hasSize(3);
        assertThat(racingcars[0].getName()).isEqualTo("pobi");
        assertThat(racingcars[1].getName()).isEqualTo("woni");
        assertThat(racingcars[2].getName()).isEqualTo("jun");
    }

    @Test
    void FindWinner() {
        Racingcar[] racingcars = {
            new Racingcar("pobi", 3),
            new Racingcar("woni", 2),
            new Racingcar("jun", 3)
        };

        List<Racingcar> winners = RacingGame.findWinner(racingcars);
        assertThat(winners).hasSize(2); // pobi와 jun이 공동 우승
        assertThat(winners).extracting(Racingcar::getName).containsExactlyInAnyOrder("pobi", "jun");
    }
}
