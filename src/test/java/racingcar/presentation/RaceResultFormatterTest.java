package racingcar.presentation;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import racingcar.domain.Car;
import racingcar.domain.Cars;
import racingcar.domain.RacingGame;
import racingcar.domain.RoundCount;
import racingcar.domain.ScoreBoard;

class RaceResultFormatterTest {

    private RaceResultFormatter raceResultFormatter;

    @BeforeEach
    void setUp() {
        raceResultFormatter = new RaceResultFormatter();
    }

    @ParameterizedTest
    @MethodSource("provideTestCases")
    @DisplayName("자동차들의 위치를 올바른 형식으로 포맷한다.")
    void formatScoreBoard(Cars cars, String expected) {
        // given
        RacingGame racingGame = new RacingGame(cars, new RoundCount(1), ScoreBoard.ofEmpty());
        ScoreBoard play = racingGame.play();

        // when
        String result = raceResultFormatter.formatScoreBoard(play);

        // then
        assertThat(result.trim()).isEqualTo(expected.trim());
    }

    private static Stream<Arguments> provideTestCases() {
        return Stream.of(
                // 모두 움직인 케이스
                Arguments.of(
                        new Cars(List.of(
                                new Car("pobi", () -> true),
                                new Car("woni", () -> true),
                                new Car("jun", () -> true)
                        )),
                        """
                        pobi : -
                        woni : -
                        jun : -
                        
                        최종 우승자 : pobi, woni, jun
                        """
                ),
                // 모두 움직이지 않은 케이스
                Arguments.of(
                        new Cars(List.of(
                                new Car("pobi", () -> false),
                                new Car("woni", () -> false),
                                new Car("jun", () -> false)
                        )),
                        """
                        pobi :\s
                        woni :\s
                        jun :\s
                        
                        최종 우승자 : pobi, woni, jun
                        """
                ),
                // 어떤 것은 움직이고, 어떤 것은 움직이지 않은 케이스
                Arguments.of(
                        new Cars(List.of(
                                new Car("pobi", () -> true),
                                new Car("woni", () -> false)
                        )),
                        """
                        pobi : -
                        woni :\s
                        
                        최종 우승자 : pobi
                        """
                )
        );
    }
}

