package racingcar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;
import racingcar.dto.UserInputDTO;
import racingcar.service.RaceService;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class RaceServiceTest {

    private UserInputDTO userInputDTO;
    private RaceService raceService;

    @BeforeEach
    void setUp() {
        userInputDTO = new UserInputDTO("A,B,C", 3);
        raceService = new RaceService();
        raceService.initialize(userInputDTO);
    }

    @Test
    void 무작위_값이_4_이상이면_전진한다() {
        // given
        Car carA = raceService.getCarList().get(0);

        // when
        if (carA.getRandomNumber() >= 4) {
            carA.move(0);

            // then
            assertEquals(carA.getMoveHistoryAtStage(0), "-");
        }
        // when
        else {
            carA.stop(0);

            // then
            assertEquals(carA.getMoveHistoryAtStage(0), "");
        }
    }

    @Test
    void 자동차의_전진횟수를_비교하여_우승자를_결정한다() {
        // given

        // when
        raceService.raceStart();

        // then
        assertNotNull(raceService.getWinnerList());
    }
}