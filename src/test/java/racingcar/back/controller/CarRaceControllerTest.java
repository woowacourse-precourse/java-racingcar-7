package racingcar.back.controller;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.*;

import java.util.List;
import java.util.stream.IntStream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.back.service.impl.CarRaceGameRunnerServiceImpl;
import racingcar.global.dto.CarRaceRequestDTO;
import racingcar.global.dto.CarRaceResponseDTO;
import racingcar.global.dto.CarRaceResult;

class CarRaceControllerTest {

    private final CarRaceController carRaceController = new CarRaceController(new CarRaceGameRunnerServiceImpl());

    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;

    @Test
    @DisplayName("컨트롤러를 통해 게임 실행 후, Valid한 ResponseDTO를 반환하는지 테스트")
    void 컨트롤러_테스트() {
        //given
        Integer gamePlayCount = 2;
        List<String> carNames = List.of("kim", "choi", "kang");
        List<List<Integer>> movePhases = List.of(List.of(0, 1), List.of(0, 1), List.of(0, 0));
        List<Boolean> isWinners = List.of(true, true, false);

        CarRaceRequestDTO carRaceRequestDTO = new CarRaceRequestDTO(carNames, gamePlayCount);
        //when
        assertRandomNumberInRangeTest(() -> {
            CarRaceResponseDTO carRaceResponseDTO = carRaceController.playRaceGame(carRaceRequestDTO);
            List<CarRaceResult> carRaceResults = carRaceResponseDTO.carRaceResults();
            //then
            IntStream.range(0, gamePlayCount).forEach(i -> {
                assertThat(carRaceResults.get(i).carName()).isEqualTo(carNames.get(i));
                assertThat(carRaceResults.get(i).racePhase()).containsAll(movePhases.get(i));
                assertThat(carRaceResults.get(i).isWinner()).isEqualTo(isWinners.get(i));
            });

        }, STOP, MOVING_FORWARD, STOP, MOVING_FORWARD, STOP, STOP);
    }
}