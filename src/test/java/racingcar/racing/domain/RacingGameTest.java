package racingcar.racing.domain;

import static org.assertj.core.api.Assertions.*;

import camp.nextstep.edu.missionutils.test.Assertions;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

class RacingGameTest {
    @Test
    void 정적_팩토리_메서드_생성_성공() {
        //then
        Assertions.assertSimpleTest(() -> {
            //given
            List<String> carNames = Arrays.asList("car1", "car2");
            int attemptNumber = 5;

            //when
            RacingGame racingGame = RacingGame.of(5, carNames);

            //then
            assertThat(racingGame.getAllRound()).isEqualTo(attemptNumber);
            assertThat(racingGame.getParticipants().get(0).getName()).isEqualTo("car1");
            assertThat(racingGame.getParticipants().get(1).getName()).isEqualTo("car2");
        });
    }

    @Test
    void start_결과_반환_성공() {
        //given
        //when
        //then
    }

    @Test
    void selectWinner_결과_반환_성공() {
        //given
        //when
        //then
    }

}