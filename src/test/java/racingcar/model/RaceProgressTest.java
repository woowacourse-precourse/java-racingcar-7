package racingcar.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class RaceProgressTest {

    @DisplayName("라운드 포지션 데이터를 추가한다")
    @Test
    void addRoundPositions() {
        RaceProgress raceProgress = new RaceProgress();
        raceProgress.addRoundPositions(List.of(1, 2, 3));

        assertThat(raceProgress.getProgress()).hasSize(1);
        assertThat(raceProgress.getProgress().get(0).positions()).containsExactly(1, 2, 3);
    }

    @DisplayName("각 라운드 진행 데이터를 확인한다")
    @Test
    void verifyRoundPositions() {
        RaceProgress raceProgress = new RaceProgress();
        raceProgress.addRoundPositions(List.of(0, 1, 2));
        raceProgress.addRoundPositions(List.of(1, 2, 3));

        assertThat(raceProgress.getProgress()).hasSize(2);
        assertThat(raceProgress.getProgress().get(1).positions()).containsExactly(1, 2, 3);
    }
}
