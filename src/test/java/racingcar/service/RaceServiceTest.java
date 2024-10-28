package racingcar.service;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import racingcar.model.RaceResult;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class RaceServiceTest {

    private static RaceService raceService;

    @BeforeAll
    static void setup() {
        raceService = new RaceService();
    }

    @DisplayName("경주 결과는 시도 횟수와 같은 수의 포지션 데이터를 가진다")
    @ParameterizedTest
    @MethodSource("provideRaceData")
    void raceResultHasCorrectNumberOfRounds(List<String> carNames, int attempts) {
        RaceResult result = raceService.start(carNames, attempts);
        assertThat(result.roundPositions().getProgress()).hasSize(attempts);
    }

    @DisplayName("우승자는 최대 포지션에 도달한 자동차들이다")
    @ParameterizedTest
    @MethodSource("provideRaceData")
    void raceResultHasCorrectWinners(List<String> carNames, int attempts) {
        RaceResult result = raceService.start(carNames, attempts);
        List<String> winners = result.winners();

        assertThat(winners).isNotEmpty();
        assertThat(winners).allMatch(carNames::contains);
    }

    static Stream<Arguments> provideRaceData() {
        return Stream.of(
                Arguments.of(List.of("car1", "car2", "car3"), 5),
                Arguments.of(List.of("carA", "carB"), 3),
                Arguments.of(List.of("apple", "bana", "cat", "dog"), 7)
        );
    }
}
