package racingcar.racingGame;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RacingGameImplTest {

    @Test
    @DisplayName("레이싱 게임 자동차 초기 셋업")
    void 레이싱_게임_자동차_초기_셋업_TEST(){
        String userInput = "kang,su,min";

        RacingGame racingGame = new RacingGameImpl(userInput);

        Assertions.assertThat(racingGame.getNumberOfRacingCars()).isEqualTo(3);
    }

}