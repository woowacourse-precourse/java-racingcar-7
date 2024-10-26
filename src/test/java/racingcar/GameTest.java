package racingcar;

import static org.assertj.core.api.Assertions.assertThat;
import static racingcar.RacingCar.createRacingCar;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class GameTest {

    @Test
    @DisplayName("score가 가장 높은사람이 1명일 경우, 우승자는 1명이다.")
    void selectWinner_one() {
        // given
        List<RacingCar> racingCars = new ArrayList<>();
        racingCars.add(createRacingCar("dean"));
        racingCars.add(createRacingCar("yuze"));
        racingCars.add(createRacingCar("woodz"));
        Game game = new Game();

        // when
        racingCars.get(2).addScore();
        List<String> winners = game.selectWinner(racingCars);

        // then
        assertThat(winners.size()).isEqualTo(1);
        assertThat(winners.get(0)).isEqualTo("woodz");
    }

    @Test
    @DisplayName("score가 가장 높은사람이 2명일 경우 우승자는 2명이다.")
    void selectWinner_two() {
        // given
        List<RacingCar> racingCars = new ArrayList<>();
        racingCars.add(createRacingCar("dean"));
        racingCars.add(createRacingCar("yuze"));
        racingCars.add(createRacingCar("woodz"));
        Game game = new Game();

        // when
        racingCars.get(0).addScore();
        racingCars.get(2).addScore();
        List<String> winners = game.selectWinner(racingCars);

        // then
        assertThat(winners.size()).isEqualTo(2);
        assertThat(winners.get(0)).isEqualTo("dean");
        assertThat(winners.get(1)).isEqualTo("woodz");
    }

    @Test
    @DisplayName("모든 참가자의 score가 동점일 경우 우승자는 전체다.")
    void selectWinner_all() {
        // given
        List<RacingCar> racingCars = new ArrayList<>();
        racingCars.add(createRacingCar("dean"));
        racingCars.add(createRacingCar("yuze"));
        racingCars.add(createRacingCar("woodz"));
        Game game = new Game();

        // when
        racingCars.get(0).addScore();
        racingCars.get(1).addScore();
        racingCars.get(2).addScore();
        List<String> winners = game.selectWinner(racingCars);

        // then
        assertThat(winners.size()).isEqualTo(racingCars.size());
        assertThat(winners.get(0)).isEqualTo("dean");
        assertThat(winners.get(1)).isEqualTo("yuze");
        assertThat(winners.get(2)).isEqualTo("woodz");
    }
}