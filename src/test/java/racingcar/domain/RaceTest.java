package racingcar.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.exception.RacingCarGameException;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class RaceTest {
    private Race race;

    @BeforeEach
    void setUp() {
        List<String> carNames = Arrays.asList("pobi", "woni", "jane");
        int totalRounds = 5;
        race = new Race(carNames, totalRounds);
    }

    @Test
    void 모든_자동차가_이동한다() {
        NumberGenerator numberGenerator = () -> 4;

        race.moveAllCarsAndGetStatus(numberGenerator);

        List<Car> raceCars = race.getWinners();
        assertThat(raceCars).hasSize(3);
    }

    @Test
    void 경주가_완료되었는지_확인() {
        assertThat(race.isRaceComplete()).isFalse();

        for (int i = 0; i < 5; i++) {
            race.moveAllCarsAndGetStatus(() -> 4);
        }

        assertThat(race.isRaceComplete()).isTrue();
    }

    @Test
    void 우승자를_결정하기() {
        race.moveAllCarsAndGetStatus(() -> 4);
        List<Car> winners = race.getWinners();

        assertThat(winners).hasSize(3);
    }

    @Test
    void 자동차가_두대_이상_있어야한다() {
        assertThatThrownBy(() -> new Race(List.of("pobi"), 3))
                .isInstanceOf(RacingCarGameException.class)
                .hasMessageContaining("경주에 참가하는 자동차는 2개 이상이어야 합니다.");
    }
}