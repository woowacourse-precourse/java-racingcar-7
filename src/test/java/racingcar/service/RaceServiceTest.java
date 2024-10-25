package racingcar.service;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.common.config.AppConfig;
import racingcar.helper.CarsHelper;
import racingcar.model.car.Cars;
import racingcar.model.dashboard.DashBoard;
import racingcar.model.race.Lap;

public class RaceServiceTest {

    private final RaceService sut = new RaceService();

    @AfterEach
    void resetProfile() {
        AppConfig.resetProfile();
    }

    @Test
    @DisplayName("우승자 3명")
    void startRace() {
        // given
        AppConfig.setTestProfileWithValue("4");
        Cars cars = CarsHelper.mockInitial();
        Lap lap = Lap.from("5");
        // when
        DashBoard dashBoard = sut.startRace(lap, cars);

        // then
        assertThat(dashBoard.rankWinners()).isEqualTo("a, b, c");
    }
}
