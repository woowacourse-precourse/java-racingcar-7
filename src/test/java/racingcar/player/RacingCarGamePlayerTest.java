package racingcar.player;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.junit.jupiter.api.Assertions.*;

import org.assertj.core.api.Assert;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import racingcar.car.Car;
import racingcar.game.RacingCarGame;

class RacingCarGamePlayerTest {

    @Test
    void createRacingCarGamePlayer_이름받음_생성한다(){
        // given
        final String playerName = "kim";

        // expect
        assertThatCode(() -> RacingCarGamePlayer.createRacingCarGamePlayer(playerName))
                .doesNotThrowAnyException();
    }

    @Test
    void providePlayerName_본인이름요청시_이름반환(){
        // given
        final String playerName = "kim";
        final RacingCarGamePlayer racingCarGamePlayer = RacingCarGamePlayer.createRacingCarGamePlayer(playerName);

        // when
        String playerSelfName = racingCarGamePlayer.provideSelfName();

        // then
        Assertions.assertThat(playerSelfName).isEqualTo(playerName);
    }

    @Test
    void createRacingCar_레이싱자동차생성요청시_레이싱카생성(){
        // given
        final String playerName = "kim";
        final RacingCarGamePlayer racingCarGamePlayer = RacingCarGamePlayer.createRacingCarGamePlayer(playerName);

        // when
        assertThatCode(() -> racingCarGamePlayer.createRacingCar())
                .doesNotThrowAnyException();
    }

}