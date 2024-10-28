package racingcar.racing.domain;

import static org.assertj.core.api.Assertions.*;

import camp.nextstep.edu.missionutils.test.Assertions;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;
import racingcar.racing.domain.dto.CarRoundResult;

class RacingGameTest {
    @Test
    void 정적_팩토리_메서드_생성_성공() {
        //then
        Assertions.assertSimpleTest(() -> {
            //given
            List<String> carNames = Arrays.asList("car1", "car2");
            int attemptNumber = 5;

            //when
            RacingGame racingGame = RacingGame.of(attemptNumber, carNames);

            //then
            assertThat(racingGame).isNotNull();
            assertThat(racingGame.getAllRound()).isEqualTo(attemptNumber);
            assertThat(racingGame.getParticipants().size()).isEqualTo(carNames.size());
            assertThat(racingGame.getParticipants().get(0).getName()).isEqualTo("car1");
            assertThat(racingGame.getParticipants().get(1).getName()).isEqualTo("car2");
        });
    }

    @Test
    void start_결과_반환_성공() {
        Assertions.assertSimpleTest(() -> {
            //given
            List<String> carNames = Arrays.asList("car1", "car2");
            int attemptNumber = 2;
            RacingGame racingGame = RacingGame.of(attemptNumber, carNames);

            //when
            List<List<CarRoundResult>> allRoundResult = racingGame.start();

            //then
            assertThat(allRoundResult.size()).isEqualTo(attemptNumber);
            assertThat(allRoundResult.get(0).size()).isEqualTo(carNames.size());
            assertThat(allRoundResult.get(0).get(0).carName()).isEqualTo(carNames.get(0));
            assertThat(allRoundResult.get(0).get(0).currentDistance()).isInstanceOf(Integer.class);
            assertThat(allRoundResult.get(0).size()).isEqualTo(carNames.size());
            assertThat(allRoundResult.get(0).get(1).carName()).isEqualTo(carNames.get(1));
            assertThat(allRoundResult.get(0).get(1).currentDistance()).isInstanceOf(Integer.class);
        });
    }

    @Test
    void selectWinner_결과_반환_성공() {
        Assertions.assertSimpleTest(() -> {
            //given
            Car car1 = new Car("car1", 5);
            Car car2 = new Car("car2", 2);
            RacingGame racingGame = new RacingGame(1, Arrays.asList(car1, car2));

            //when
            List<Car> winners = racingGame.selectWinners();

            //then
            assertThat(winners.size()).isEqualTo(1);
            assertThat(winners.get(0).getName()).isEqualTo("car1");
        });
    }

}