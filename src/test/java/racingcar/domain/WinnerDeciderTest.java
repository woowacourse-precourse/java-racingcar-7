package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static racingcar.exception.ErrorMessage.RACE_RESULT_EMPTY;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import racingcar.dto.RaceResult;
import racingcar.exception.RacingCarException;

import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

class WinnerDeciderTest {

    private final WinnerDecider winnerDecider = new WinnerDecider();

    @ParameterizedTest
    @MethodSource("provideRaceProgressForSingleWinner")
    @DisplayName("우승자 결정 - 최대 진척도를 가진 단일 우승자를 반환")
    void determineWinner_withSingleWinner(Map<String, Integer> raceProgress, String expectedWinner) {
        RaceResult raceResult = new RaceResult(raceProgress);

        List<String> winners = winnerDecider.determineWinners(raceResult);

        assertThat(winners).containsExactly(expectedWinner);
    }

    @ParameterizedTest
    @MethodSource("provideRaceProgressForMultipleWinners")
    @DisplayName("우승자 결정 - 최대 진척도를 가진 공동 우승자를 반환")
    void determineWinner_withMultipleWinners(Map<String, Integer> raceProgress, List<String> expectedWinners) {
        RaceResult raceResult = new RaceResult(raceProgress);

        List<String> winners = winnerDecider.determineWinners(raceResult);

        assertThat(winners).containsExactlyInAnyOrderElementsOf(expectedWinners);
    }

    @Test
    @DisplayName("빈 경주 결과로 우승자 결정 시 예외 발생")
    void determineWinner_withEmptyRaceProgress() {
        Map<String, Integer> emptyRaceProgress = Map.of();
        RaceResult raceResult = new RaceResult(emptyRaceProgress);

        assertThatThrownBy(() -> winnerDecider.determineWinners(raceResult))
                .isInstanceOf(RacingCarException.class)
                .hasMessage(RACE_RESULT_EMPTY.getMessage());
    }

    private static Stream<Arguments> provideRaceProgressForSingleWinner() {
        return Stream.of(
                Arguments.of(Map.of("Tesla", 5, "BMW", 3, "Audi", 2), "Tesla"),
                Arguments.of(Map.of("Ford", 7, "Kia", 5, "Mini", 1), "Ford")
        );
    }

    private static Stream<Arguments> provideRaceProgressForMultipleWinners() {
        return Stream.of(
                Arguments.of(Map.of("Tesla", 5, "BMW", 5, "Audi", 3), List.of("Tesla", "BMW")),
                Arguments.of(Map.of("Ford", 7, "Kia", 7, "Mini", 2), List.of("Ford", "Kia"))
        );
    }
}
