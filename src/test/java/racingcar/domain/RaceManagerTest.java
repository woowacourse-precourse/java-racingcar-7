package racingcar.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.dto.InputDto;
import racingcar.utils.moving.MovingStrategy;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class RaceManagerTest {

    private RaceManager raceManager;

    @BeforeEach
    void setUp() {
        // given
        MovingStrategy alwaysMovableStrategy = () -> true;

        List<String> carNames = Arrays.asList("CarA", "CarB", "CarC");
        String attempts = "3";
        InputDto inputDto = new InputDto(carNames, attempts);

        raceManager = RaceManager.createRaceManager(inputDto, alwaysMovableStrategy);
    }

    @Test
    @DisplayName("레이스를 주어진 시도 횟수만큼 실행")
    void 주어진_시도_횟수만큼_레이스를_실행한다() {
        // when
        raceManager.racePerAttempt();

        // then
        List<Car> cars = raceManager.getRacingCars().getCars();
        cars.forEach(car -> assertThat(car.getPositionDistance()).isEqualTo(3));
    }

    @Test
    @DisplayName("우승자를 정확히 선정")
    void 우승자를_정확히_선정한다() {
        // when
        raceManager.racePerAttempt();
        raceManager.announceRaceResult();

        // then
        List<String> expectedWinners = Arrays.asList("CarA", "CarB", "CarC");
        assertThat(raceManager.getWinnersName()).isEqualTo(expectedWinners);
    }

    @Test
    @DisplayName("이동 불가능한 경우 자동차의 위치가 변하지 않음")
    void 이동_불가능한_경우_위치가_변하지_않는다() {
        // given
        MovingStrategy nonMovableStrategy = () -> false;
        raceManager = RaceManager.createRaceManager(
                new InputDto(Arrays.asList("CarA", "CarB", "CarC"), "5"),
                nonMovableStrategy
        );

        // when
        raceManager.racePerAttempt();

        // then
        List<Car> cars = raceManager.getRacingCars().getCars();
        cars.forEach(car -> assertThat(car.getPositionDistance()).isEqualTo(0));
    }
}