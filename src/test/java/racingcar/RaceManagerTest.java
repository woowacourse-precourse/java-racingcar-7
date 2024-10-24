package racingcar;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.Test;

class RaceManagerTest {

    @Test
    void doRace_and_getLog() {
        List<String> participants = List.of("pobi", "woni", "jun");
        RaceManager raceManager = new RaceManager(participants);

        raceManager.doRace(2);

        List<List<String>> log = raceManager.getLog();

        assertThat(log).hasSize(2);

        assertThat(log.get(0)).hasSize(3);  // 첫 번째 레이스
        assertThat(log.get(1)).hasSize(3);  // 두 번째 레이스

        assertThat(log.get(0).get(0)).contains("pobi : ");
        assertThat(log.get(0).get(1)).contains("woni : ");
        assertThat(log.get(0).get(2)).contains("jun : ");
    }
}