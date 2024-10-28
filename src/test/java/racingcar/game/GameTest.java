package racingcar.game;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.Test;
import racingcar.player.Player;

class GameTest {

    @Test
    void winner_함수테스트() {
        List<Player> players = List.of(new Player("a"), new Player("b"), new Player("c"));
        Game game = new Game(players);

        game.play(1, (player) -> player.getName().equals("a"));
        game.play(1, (player) -> player.getName().equals("c"));
        game.play(1, (player) -> player.getName().equals("c"));

        List<String> result = game.winner();
        assertThat(result).isEqualTo(List.of("c"));
    }
    @Test
    void winner_동점자테스트() {
        List<Player> players = List.of(new Player("a"), new Player("b"), new Player("c"));
        Game game = new Game(players);

        game.play(1, (player) -> player.getName().equals("a"));
        game.play(1, (player) -> player.getName().equals("c"));

        List<String> result = game.winner();
        assertThat(result).isEqualTo(List.of("a", "c"));
    }

    @Test
    void play_함수테스트() {
        List<Player> players = List.of(new Player("a"), new Player("b"), new Player("c"));
        Game game = new Game(players);

        game.play(1, (player) -> player.getName().equals("a"));
        List<Player> result = game.play(1, (player) -> player.getName().equals("c"));
        List<Integer> scores = result.stream().map(Player::getScore).toList();

        assertThat(scores).isEqualTo(List.of(1, 0, 1));
    }
}