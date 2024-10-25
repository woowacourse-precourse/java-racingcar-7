package racingcar.player;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.game.GameNumberGenerator;
import racingcar.player.exception.PlayerNameException;
import racingcar.player.mock.CanMoveGameNumberGenerator;
import racingcar.player.mock.UnMoveGameNumberGenerator;

class RacingGamePlayerTest {

    @Test
    void createRacingCarGamePlayer_이름받음_생성한다(){
        // given
        final String playerName = "kim";

        // expect
        assertThatCode(() -> GamePlayer.of(playerName))
                .doesNotThrowAnyException();
    }
    @Test
    void createRacingCarGamePlayer_이동름이10자초과_예외발생(){
        assertThatThrownBy(() -> {
            GamePlayer.of("xxxxxxxxxxx");
        })
                .isInstanceOf(PlayerNameException.NameLengthExceededException.class)
                .hasMessage("플레이어 이름은 최대 10자까지 가능합니다.");
    }
    @Test
    void RacingCarGamePlayer_이름이1자미만_예외발생(){
        assertThatThrownBy(() -> {
            GamePlayer.of("");
        })
                .isInstanceOf(PlayerNameException.NameLengthShortException.class)
                .hasMessage("플레이어 이름은 최소 1자부터 가능합니다.");
    }

    @ParameterizedTest
    @ValueSource(strings = {"1","22","333","4444","55555","666666","7777777","88888888","!!!!!!!!!","ㅌㅌㅌㅌㅌㅌㅌㅌㅌㅌ"})
    void RacingCarGamePlayer_1부터10자사이_생성성공(String name){
        assertThatCode(() -> GamePlayer.of(name))
                .doesNotThrowAnyException();;
    }


    @Test
    void providePlayerName_본인이름요청시_이름반환(){
        // given
        final String playerName = "kim";
        final GamePlayer gamePlayer = GamePlayer.of(playerName);

        // when
        String playerSelfName = gamePlayer.providePlayerName();

        // then
        Assertions.assertThat(playerSelfName).isEqualTo(playerName);
    }

//    @Test
//    void createRacingCar_레이싱자동차생성요청시_레이싱카생성(){
//        // given
//        final String playerName = "kim";
//        final GamePlayer gamePlayer = GamePlayer.of(playerName);
//
//        // when
//        assertThatCode(() -> gamePlayer.createCar())
//                .doesNotThrowAnyException();
//    }

    @Test
    void pickNumberBy_메서드요청시_정상작동() {
        // given
        final String playerName = "kim";
        final GamePlayer gamePlayer = GamePlayer.of(playerName);
        final GameNumberGenerator canMoveGameNumberGenerator = new CanMoveGameNumberGenerator();

        // expect
        Assertions.assertThatCode(() -> gamePlayer.pickGameNumberBy(canMoveGameNumberGenerator))
                .doesNotThrowAnyException();
    }

    @Test
    void pickNumberBy_메서드요청시_이동가능숫뽑을수있음() {
        // given
        final String playerName = "kim";
        final GamePlayer gamePlayer = GamePlayer.of(playerName);
        final GameNumberGenerator canMoveGameNumberGenerator = new CanMoveGameNumberGenerator();

        // when
        int pickedNumber = gamePlayer.pickGameNumberBy(canMoveGameNumberGenerator);

        // then
        Assertions.assertThat(pickedNumber).isBetween(4,9);
    }

    @Test
    void pickNumberBy_메서드요청시_이동불가숫자뽑을수있음() {
        // given
        final String playerName = "kim";
        final GamePlayer gamePlayer = GamePlayer.of(playerName);
        final GameNumberGenerator canMoveGameNumberGenerator = new UnMoveGameNumberGenerator();

        // when
        int pickedNumber = gamePlayer.pickGameNumberBy(canMoveGameNumberGenerator);

        // then
        Assertions.assertThat(pickedNumber).isBetween(0,3);
    }

    @Test
    void moveCarForward_메서드요청시_정상작동(){
        // given
        final String playerName = "kim";
        final int step = 1;
        final GamePlayer gamePlayer = GamePlayer.of(playerName);

        // expect
        Assertions.assertThatCode(() -> gamePlayer.moveCarForward(step))
                        .doesNotThrowAnyException();
    }

    @Test
    void moveCarFoward_자동차이동_스텝수만큼이동시킴(){
        // given
        final String playerName = "kim";
        final int step = 1;
        final GamePlayer gamePlayer = GamePlayer.of(playerName);

        // when
        GamePlayer carMovedPlayer = gamePlayer.moveCarForward(step);

        // expect
        Assertions.assertThat(carMovedPlayer.provideRacingCarDistance()).isEqualTo(step);

    }

}

