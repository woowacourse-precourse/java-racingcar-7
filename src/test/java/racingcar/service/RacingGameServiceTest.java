package racingcar.service;

import java.util.Arrays;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.domain.car.Car;
import racingcar.domain.car.CarGroup;
import racingcar.domain.car.CarInfo;
import racingcar.domain.game.GameManager;
import racingcar.domain.game.GameRound;
import racingcar.domain.game.GameRule;
import racingcar.domain.game.WinnerCalculator;
import racingcar.domain.game.WootecoRule;
import racingcar.utils.NumberGenerator;
import racingcar.utils.RandomNumberGenerator;

class RacingGameServiceTest {

    GameRule gameRule;
    NumberGenerator numberGenerator;
    WinnerCalculator winnerCalculator;
    GameManager gameManager;
    RacingGameService service;

    @BeforeEach
    void setUp() {
        gameRule = new WootecoRule();
        numberGenerator = new RandomNumberGenerator();
        winnerCalculator = new WinnerCalculator(gameRule);
        gameManager = new GameManager(gameRule, numberGenerator, winnerCalculator);
        service = new RacingGameService(gameManager);
    }


    @Test
    void 각_라운드마다_자동차_상태를_반환한다() {
        // given
        CarGroup carGroup = new CarGroup(Arrays.asList(new Car("povi"), new Car("minu")));
        GameRound gameRound = new GameRound("1");

        // when
        List<List<CarInfo>> roundResults = service.runGameRounds(gameRound, carGroup);

        // then
        Assertions.assertThat(roundResults).hasSize(1);
        Assertions.assertThat(roundResults.get(0)).hasSize(2);
        Assertions.assertThat(roundResults.get(0).get(0).getName()).isEqualTo("povi");
        Assertions.assertThat(roundResults.get(0).get(1).getName()).isEqualTo("minu");
    }

    @Test
    void 우승자_목록을_출력한다() {
        //given
        CarGroup carGroup = new CarGroup(Arrays.asList(new Car("povi"), new Car("minu")));

        // when
        List<String> winners = service.getWinners(carGroup);

        // then
        Assertions.assertThat(winners).hasSize(2);
        Assertions.assertThat(winners).contains("povi", "minu");
    }
}