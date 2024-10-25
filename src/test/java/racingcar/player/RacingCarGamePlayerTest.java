package racingcar.player;

import static org.junit.jupiter.api.Assertions.*;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import racingcar.game.RacingCarGame;

class RacingCarGamePlayerTest {

    @Test
    void createRacingCarGamePlayer_이름받음_생성한다(){
        // given
        final String playerName = "kim";

        // expect
        Assertions.assertThatCode(() -> RacingCarGamePlayer.createRacingCarGamePlayer(playerName))
                .doesNotThrowAnyException();
    }

}