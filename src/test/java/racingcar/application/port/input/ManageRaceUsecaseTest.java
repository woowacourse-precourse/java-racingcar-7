package racingcar.application.port.input;

import static org.assertj.core.api.Assertions.*;
import static racingcar.domain.race.constants.RaceCriterion.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.application.dto.request.RaceRequest;
import racingcar.application.dto.response.RaceResponse;
import racingcar.application.service.ManageRaceCommand;
import racingcar.domain.acceleration.FixedAcceleration;
import racingcar.domain.race.service.RaceHelper;
import racingcar.domain.race.vo.Round;

@DisplayName("ManageRaceUsecase 인터페이스 테스트")
class ManageRaceUsecaseTest {

    private RaceHelper raceHelper = new RaceHelper();
    private ManageRaceUsecase manageRaceUsecase = new ManageRaceCommand(raceHelper,
        new FixedAcceleration(
            MOVING_FORWARD.getCriterion()));

    @Test
    void 레이스를_실행한다() {
        // given
        RaceRequest raceRequest = new RaceRequest("pobi,woni", new Round(3));

        // when
        RaceResponse raceResponse = manageRaceUsecase.run(raceRequest);

        // then
        assertThat(raceResponse).isNotNull();
        assertThat(raceResponse.raceResult().rounds().size()).isEqualTo(3);
        assertThat(raceResponse.winners().winnerNames().size()).isEqualTo(2);
    }

}