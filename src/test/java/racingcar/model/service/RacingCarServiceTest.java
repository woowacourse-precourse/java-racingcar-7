package racingcar.model.service;

import org.junit.jupiter.api.Test;
import racingcar.config.AppConfig;
import racingcar.dto.RacingCarRequest;
import racingcar.dto.RacingCarResponse;
import racingcar.model.car.Car;

import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;
import static racingcar.model.movement.RandomMovement.MOVE_MIN_NUMBER;

class RacingCarServiceTest {
    private AppConfig appConfig = new AppConfig();

    @Test
    void 자동차_경주_게임을_시작한다() {
        //given
        RacingCarService racingCarService = appConfig.racingCarService();
        String carName1 = "name1";
        String carName2 = "name2";

        assertRandomNumberInRangeTest(() ->
                {
                    //when
                    RacingCarResponse racingCarResponse
                            = racingCarService.startGame(
                            new RacingCarRequest(List.of(carName1, carName2), 3)
                    );
                    //then
                    assertThat(racingCarResponse.winCars())
                            .isEqualTo(
                                    List.of(Car.of(carName1, appConfig.movement()))
                            );
                },
                MOVE_MIN_NUMBER, MOVE_MIN_NUMBER - 1,
                MOVE_MIN_NUMBER, MOVE_MIN_NUMBER,
                MOVE_MIN_NUMBER, MOVE_MIN_NUMBER
        );
    }
}