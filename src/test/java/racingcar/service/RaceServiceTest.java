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
import racingcar.model.race.Race;

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
        Race race = Race.of(Lap.of("5"));

        // when
        DashBoard dashBoard = sut.startRace(race, cars);

        // then
        assertThat(dashBoard.offerWinners()).isEqualTo("a, b, c");
    }
}
