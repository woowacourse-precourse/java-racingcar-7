package racingcar;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class GameTest {

    private final Integer ROUND = 5;
    private final List<String> racingCarsName = new ArrayList<>();

    @Test
    @DisplayName("score가 가장 높은사람이 1명일 경우, 우승자는 1명이다.")
    void selectWinner_one() {
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
    @DisplayName("score가 가장 높은사람이 2명일 경우 우승자는 2명이다.")
    void selectWinner_two() {
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
    @DisplayName("모든 참가자의 score가 동점일 경우 우승자는 전체다.")
    void selectWinner_all() {
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