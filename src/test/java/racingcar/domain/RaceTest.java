package racingcar.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class RaceTest {

    private static final String CAR_NAMES = "pobi,woni,jun";
    private static final int ATTEMPT_COUNT = 5;
    private Race race;

    @BeforeEach
    void setUp() {
        race = Race.createRace(CAR_NAMES, ATTEMPT_COUNT);
    }

    @Test
    @DisplayName("자동차 경주 진행 후 각 자동차의 위치 표시한다.")
    void printPositionAfterRacing() {
        String racingProgress = race.displayRacingProgress();

        assertThat(racingProgress).isNotEmpty();
        assertThat(racingProgress).contains(CAR_NAMES);
    }

    @Test
    @DisplayName("최대 위치에 있는 자동차들이 우승자로 추출되는지 검증한다.")
    void validateWinnersHaveMaxPosition() {
        race.displayRacingProgress();

        List<Car> winners = race.getWinners();

        int maxPosition = winners.getFirst()
                .getPosition();
        assertThat(winners).allMatch(car -> car.getPosition() == maxPosition);
    }
}