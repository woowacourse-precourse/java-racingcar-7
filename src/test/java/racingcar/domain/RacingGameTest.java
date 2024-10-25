package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import racingcar.util.MockRandomGenerator;
import racingcar.util.RandomGenerator;

class RacingGameTest {

    @Nested
    @DisplayName("승자 이름 반환 테스트(song,park,lee,kim)")
    class whenFindWinnerCarNames {

        @Test
        @DisplayName("song, park이 승자인 경우")
        void successfullyWinnerIsSongAndPark() {
            //given
            RandomGenerator randomGenerator = new MockRandomGenerator(List.of(9, 9, 0, 0));
            RacingGame racingGame = new RacingGame("song,park,lee,kim", randomGenerator);
            String expected = "song, park";

            //when
            racingGame.proceedRound();
            String actual = racingGame.findWinnerCarNames();

            //then
            assertThat(actual).isEqualTo(expected);
        }

        @Test
        @DisplayName("lee, kim이 승자인 경우")
        void successfullyWinnerIsLeeAndKim() {
            //given
            RandomGenerator randomGenerator = new MockRandomGenerator(List.of(0, 0, 9, 9));
            RacingGame racingGame = new RacingGame("song,park,lee,kim", randomGenerator);
            String expected = "lee, kim";

            //when
            racingGame.proceedRound();
            String actual = racingGame.findWinnerCarNames();

            //then
            assertThat(actual).isEqualTo(expected);
        }

    }

}