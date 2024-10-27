package racingcar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class PlayerTest {

    List<Player> players;

    @BeforeEach
    void setUp() {
        players = new ArrayList<>();
        players.add(new Player("a", 0));
    }

    @Test
    @DisplayName("플레이어 정보 변경")
    void 플레이어_정보_변경() {
        Player player = new Player("a", 0);

        assertThat(player.name).isEqualTo("a");
        assertThat(player.count).isEqualTo(0);

        player.name = "b";
        player.count = 1;

        assertThat(player.name).isEqualTo("b");
        assertThat(player.count).isEqualTo(1);
    }


    @Test
    @DisplayName("리스트에 Player 정상 추가")
    void 플레이어_추가() {
        players.add(new Player("b", 0));

        assertThat(players.size()).isEqualTo(2);
        assertThat(players.stream().allMatch(player -> player.count == 0)).isEqualTo(true);
    }
}
