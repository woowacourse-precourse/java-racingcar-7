package racingcar.back.service.impl;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.stream.IntStream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.back.service.CarRaceGameRunnerService;
import racingcar.global.dto.CarRaceResponseDTO;
import racingcar.global.dto.CarRaceResult;

class CarRaceGameRunnerServiceImplTest {
    private final CarRaceGameRunnerService gameRunnerService = new CarRaceGameRunnerServiceImpl();
    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;

    @Test
    @DisplayName("차들의 이름과 게임횟수가 주어졌을 때 게임 수행")
    void 게임_테스트() {
        //given
        int gamePlayCount = 2;
        // 게임 결과 물에 대한 expected 값들
        List<String> carNames = List.of("kim", "lee");
        List<List<Integer>> movePhases = List.of(List.of(1, 1), List.of(0, 0));
        List<Boolean> isWinners = List.of(true, false);
        //when
        assertRandomNumberInRangeTest(() -> {
            CarRaceResponseDTO carRaceResponseDTO = gameRunnerService.runGame(carNames, gamePlayCount);
            List<CarRaceResult> carRaceResults = carRaceResponseDTO.carRaceResults();
            //then
            IntStream.range(0, gamePlayCount).forEach(i -> {
                assertThat(carRaceResults.get(i).carName()).isEqualTo(carNames.get(i));
                assertThat(carRaceResults.get(i).racePhase()).containsAll(movePhases.get(i));
                assertThat(carRaceResults.get(i).isWinner()).isEqualTo(isWinners.get(i));
            });

        }, MOVING_FORWARD, STOP, STOP, STOP);
    }

    @Test
    @DisplayName("차들의 이름과 게임횟수가 주어졌을 때 게임 수행, 더 많은 차들과 횟수")
    void 게임_테스트2() {
        //given
        int gamePlayCount = 3;
        // 게임 결과 물에 대한 expected 값들
        List<String> carNames = List.of("kim", "lee", "choi");
        List<List<Integer>> movePhases = List.of(List.of(0, 1, 1), List.of(1, 2, 2), List.of(0, 0, 0));
        List<Boolean> isWinners = List.of(false, true, false);
        //when
        assertRandomNumberInRangeTest(() -> {
            CarRaceResponseDTO carRaceResponseDTO = gameRunnerService.runGame(carNames, gamePlayCount);
            List<CarRaceResult> carRaceResults = carRaceResponseDTO.carRaceResults();
            //then
            IntStream.range(0, gamePlayCount).forEach(i -> {
                assertThat(carRaceResults.get(i).carName()).isEqualTo(carNames.get(i));
                assertThat(carRaceResults.get(i).racePhase()).containsAll(movePhases.get(i));
                assertThat(carRaceResults.get(i).isWinner()).isEqualTo(isWinners.get(i));
            });

        }, STOP, MOVING_FORWARD, STOP, MOVING_FORWARD, MOVING_FORWARD, STOP, STOP, STOP, STOP);
    }
}