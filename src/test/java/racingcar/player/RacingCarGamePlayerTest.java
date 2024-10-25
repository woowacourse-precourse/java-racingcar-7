package racingcar.player;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.player.exception.PlayerNameException;

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
    void createRacingCarGamePlayer_이동름이10자초과_예외발생(){
        assertThatThrownBy(() -> {
            RacingCarGamePlayer.createRacingCarGamePlayer("xxxxxxxxxxx");
        })
                .isInstanceOf(PlayerNameException.NameLengthExceededException.class)
                .hasMessage("플레이어 이름은 최대 10자까지 가능합니다.");
    }
    @Test
    void RacingCarGamePlayer_이름이1자미만_예외발생(){
        assertThatThrownBy(() -> {
            RacingCarGamePlayer.createRacingCarGamePlayer("");
        })
                .isInstanceOf(PlayerNameException.NameLengthShortException.class)
                .hasMessage("플레이어 이름은 최소 1자부터 가능합니다.");
    }

    @ParameterizedTest
    @ValueSource(strings = {"1","22","333","4444","55555","666666","7777777","88888888","!!!!!!!!!","ㅌㅌㅌㅌㅌㅌㅌㅌㅌㅌ"})
    void RacingCarGamePlayer_1부터10자사이_생성성공(String name){
        assertThatCode(() -> RacingCarGamePlayer.createRacingCarGamePlayer(name))
                .doesNotThrowAnyException();;
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