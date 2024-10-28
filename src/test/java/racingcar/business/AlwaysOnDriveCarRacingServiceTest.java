package racingcar.business;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.object.carEngine.AlwaysOnDriveCarEngine;
import racingcar.racingapp.business.CarRacingService;
import racingcar.racingapp.model.value.vo.CarName;
import racingcar.racingapp.model.value.vo.CarNames;
import racingcar.racingapp.model.value.vo.CarRacingResult;
import racingcar.racingapp.model.value.vo.TotalLapCount;
import racingcar.racingapp.model.value.vo.Winners;

class AlwaysOnDriveCarRacingServiceTest {

    public static final TotalLapCount LAP_COUNT_FOR_RACING = new TotalLapCount(5);
    public static final CarNames CAR_NAMES_OF_PARTICIPANTS = new CarNames(List.of(
            new CarName("1번차"),
            new CarName("2번차"),
            new CarName("3번차")
    ));

    private CarRacingResult carRacingResult;

    @BeforeEach
    void setUp() {
        CarRacingService regulationsCarRacingService = new CarRacingService(new AlwaysOnDriveCarEngine());
        carRacingResult = regulationsCarRacingService.performCarRacing(CAR_NAMES_OF_PARTICIPANTS, LAP_COUNT_FOR_RACING);
    }

    @Test
    void 성적이_모두같다면_모두우승한다() {
        Winners winnersOfTotal = carRacingResult.winners();

        assertThat(winnersOfTotal.winners().carNames().size())
                .isEqualTo(CAR_NAMES_OF_PARTICIPANTS.carNames().size());
    }

}