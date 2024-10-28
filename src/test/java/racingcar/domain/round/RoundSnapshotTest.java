package racingcar.domain.round;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RoundSnapshotTest {

    List<RoundResult> roundResult;

    @BeforeEach
    void setUp() {
        roundResult = new ArrayList<>();
        roundResult.add(new RoundResult("car1", 1));
        roundResult.add(new RoundResult("car2", 2));
        roundResult.add(new RoundResult("car3", 3));

    }

    @Test
    @DisplayName("3개의 라운드 정보가 주어질 경우, 승자는 1명이다.")
    void givenRoundSnapshot_whenGetWinners_thenOneWinner() {
        // given
        RoundSnapshot roundSnapshot = RoundSnapshot.from(roundResult);

        // when
        List<String> result = roundSnapshot.getWinners();

        // then
        assertThat(result).isEqualTo(List.of("car3"));
    }

    @Test
    @DisplayName("4개의 라운드 정보가 주어질 경우, 승자는 2명이다.")
    void givenRoundSnapshot_whenGetWinners_thenTwoWinner() {
        // given
        roundResult.add(new RoundResult("car4", 3));
        RoundSnapshot roundSnapshot = RoundSnapshot.from(roundResult);

        // when
        List<String> result = roundSnapshot.getWinners();

        // then
        assertThat(result).isEqualTo(List.of("car3", "car4"));
    }

}