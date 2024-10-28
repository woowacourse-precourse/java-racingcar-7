package racingcar;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


class RacingGameTest {
    @Test
    @DisplayName("정상적인 이름으로 게임 실행")
    void valid_names() {
        String[] names = {"pobi", "woni", "jun"};
        RacingGame game = new RacingGame(names, 5);
        game.start();
        String[] winners = game.getWinners();
        assertThat(winners).isNotNull();
        assertThat(winners.length).isGreaterThanOrEqualTo(1);
    }

    @Test
    @DisplayName("빈 문자열이 포함된 이름으로 게임 실행")
    void empty_name() {
        String[] names = {"pobi", "", "jun"};
        RacingGame game = new RacingGame(names, 5);
        game.start();
        String[] winners = game.getWinners();
        assertThat(winners).isNotNull();
        assertThat(winners.length).isGreaterThanOrEqualTo(1);
    }

    @Test
    @DisplayName("공백이 포함된 이름으로 게임 실행")
    void spaced_names() {
        String[] names = {" pobi ", "woni", " jun "};
        RacingGame game = new RacingGame(names, 5);
        game.start();
        String[] winners = game.getWinners();
        assertThat(winners).isNotNull();
        assertThat(winners.length).isGreaterThanOrEqualTo(1);
    }
}