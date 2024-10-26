package racingcar.front.builder;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.back.service.CarRaceGameRunnerService;
import racingcar.back.service.impl.CarRaceGameRunnerServiceImpl;
import racingcar.global.dto.CarRaceResponseDTO;

class GameWinnerOutputBuilderTest {

    private final CarRaceGameRunnerService carRaceGameRunnerService = new CarRaceGameRunnerServiceImpl();
    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;

    @Test
    @DisplayName("서비스를 통해 게임을 싱행하고 최종 우승자 출력을 테스트")
    void 최종우승자_출력_테스트() {
        //given
        int gamePlayCount = 2;
        List<String> carNames = List.of("kim", "lee");
        //when
        assertRandomNumberInRangeTest(() -> {
            CarRaceResponseDTO carRaceResponseDTO = carRaceGameRunnerService.runGame(carNames, gamePlayCount);
            //then
            String builtGamePhaseOutput = GameWinnerOutputBuilder.build(carRaceResponseDTO);
            assertThat(builtGamePhaseOutput).contains("kim", ", ", "lee");

        }, MOVING_FORWARD, STOP, MOVING_FORWARD, STOP);
    }

}