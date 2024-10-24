package racingcar.race;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class RaceTest {

    Race race = new Race();

    @BeforeEach
    void setUp() {
        race = new Race(new String[]{"Test", "Case", "List"});
    }

    @Test
    void 레이스_생성_테스트() {
        List<Racer> racers = race.getRacers();

        assertThat(racers.size()).isEqualTo(3);
    }
}
