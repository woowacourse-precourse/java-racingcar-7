package racingcar;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class GameServiceTest {
    @Nested
    @DisplayName("selectWinner()를 테스트합니다.")
    class SelectWinnerTest {
        private final Integer ROUND = 5;
        private final List<String> racingCarsName = new ArrayList<>();

        @Test
        void score가_가장_높은사람이_1명일_경우_우승자는_1명이다() {
            // given
            GameService gameService = new GameService();
            racingCarsName.add("woodz");
            racingCarsName.add("dean");
            racingCarsName.add("yuze");
            gameService.init(ROUND, racingCarsName);

            // when
            gameService.getGame().getRacingCars().get(0).addScore();
            List<String> winners = gameService.selectWinner();

            // then
            assertThat(winners.size()).isEqualTo(1);
            assertThat(winners.get(0)).isEqualTo("woodz");
        }

        @Test
        void score가_가장_높은사람이_2명일_경우_우승자는_2명이다() {
            // given
            GameService gameService = new GameService();
            racingCarsName.add("woodz");
            racingCarsName.add("dean");
            racingCarsName.add("yuze");
            gameService.init(ROUND, racingCarsName);

            // when
            gameService.getGame().getRacingCars().get(0).addScore();
            gameService.getGame().getRacingCars().get(1).addScore();
            List<String> winners = gameService.selectWinner();

            // then
            assertThat(winners.size()).isEqualTo(2);
            assertThat(winners.get(0)).isEqualTo("woodz");
            assertThat(winners.get(1)).isEqualTo("dean");
        }

        @Test
        void 참가자의_score가_모두_동일하면_우승자는_전체이다() {
            // given
            GameService gameService = new GameService();
            racingCarsName.add("woodz");
            racingCarsName.add("dean");
            racingCarsName.add("yuze");
            gameService.init(ROUND, racingCarsName);

            // when
            gameService.getGame().getRacingCars().get(0).addScore();
            gameService.getGame().getRacingCars().get(1).addScore();
            gameService.getGame().getRacingCars().get(2).addScore();
            List<String> winners = gameService.selectWinner();

            // then
            assertThat(winners.size()).isEqualTo(3);
            assertThat(winners.get(0)).isEqualTo("woodz");
            assertThat(winners.get(1)).isEqualTo("dean");
            assertThat(winners.get(2)).isEqualTo("yuze");
        }
    }
}