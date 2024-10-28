package racingcar.service;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.dto.CarDto.CarOutputDto;
import racingcar.model.domain.Car;
import racingcar.repository.InMemoryCarRepository;
import racingcar.repository.InMemoryRacingHistoryRepository;

class RacingServiceImplTest {
    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;
    RacingServiceImpl racingService;
    InMemoryRacingHistoryRepository racingHistoryRepository;
    InMemoryCarRepository carRepository;

    @BeforeEach
    void setUp() {
        racingHistoryRepository = InMemoryRacingHistoryRepository.getInstance();
        carRepository = InMemoryCarRepository.getInstance();
        racingService = new RacingServiceImpl(carRepository, racingHistoryRepository);
        carRepository.updateAll(new ArrayList<>());
        racingHistoryRepository.clear();
    }

    @Test
    void 레이싱_기능_테스트() {

        //given
        Car car1 = new Car("test1");
        carRepository.save(car1);
        int attemptCount = 3;

        //when, then
        assertRandomNumberInRangeTest(
                () -> {
                    racingService.startRacing(attemptCount);
                    assertThat(2)
                            .isEqualTo(carRepository.findAll().getFirst().getMovedDistance());
                },
                MOVING_FORWARD, STOP, MOVING_FORWARD
        );
    }

    @Test
    void 레이스_기록_저장_기능_테스트() {

        //given
        Car car1 = new Car("test1");
        carRepository.save(car1);
        int attemptCount = 3;

        //when, then
        assertRandomNumberInRangeTest(
                () -> {
                    racingService.startRacing(attemptCount);
                    assertThat(1)
                            .isEqualTo(racingHistoryRepository.findByRoundNumber(0).getFirst().getTotalMovedDistance());
                    assertThat(1)
                            .isEqualTo(racingHistoryRepository.findByRoundNumber(1).getFirst().getTotalMovedDistance());
                    assertThat(2)
                            .isEqualTo(racingHistoryRepository.findByRoundNumber(2).getFirst().getTotalMovedDistance());
                },
                MOVING_FORWARD, STOP, MOVING_FORWARD
        );
    }

    @Test
    void 단독_우승자_선정_기능_테스트() {
        //given
        Car car1 = new Car("test1");
        Car car2 = new Car("test2");
        carRepository.save(car1);
        carRepository.save(car2);

        int attemptCount = 2;

        //when, then
        assertRandomNumberInRangeTest(
                () -> {
                    racingService.startRacing(attemptCount);
                    List<CarOutputDto> winnerList = racingService.selectWinner();
                    assertThat(List.of("test1"))
                            .isEqualTo(winnerList.stream().map(CarOutputDto::carName).collect(Collectors.toList()));
                },
                MOVING_FORWARD, STOP, MOVING_FORWARD, MOVING_FORWARD
        );
    }

    @Test
    void 공동_우승자_선정_기능_테스트() {
        //given
        Car car1 = new Car("test1");
        Car car2 = new Car("test2");
        carRepository.save(car1);
        carRepository.save(car2);

        int attemptCount = 2;

        //when, then
        assertRandomNumberInRangeTest(
                () -> {
                    racingService.startRacing(attemptCount);
                    List<CarOutputDto> winnerList = racingService.selectWinner();
                    assertThat(List.of("test1", "test2"))
                            .isEqualTo(winnerList.stream().map(CarOutputDto::carName).collect(Collectors.toList()));
                },
                MOVING_FORWARD, STOP, STOP, MOVING_FORWARD
        );
    }
}
