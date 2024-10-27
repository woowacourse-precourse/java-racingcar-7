package racingcar.application.service.car;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.car.RacingCar;
import racingcar.infrastructure.persistence.InMemoryRacingCarRepository;

import static org.junit.jupiter.api.Assertions.*;
class RacingCarServiceTest {

    private RacingCarService racingCarService;
    private InMemoryRacingCarRepository repository;

    @BeforeEach
    public void before(){
        repository = InMemoryRacingCarRepository.getInstance();
        repository.clear();
        racingCarService = new RacingCarService();
    }

    @Test
    void 레이싱_카_저장하기() {
        String names = "name, test, jaz";

        racingCarService.inputCarName(names);

        assertEquals(repository.getRacingCars().getFirst().getName(), "name");
    }

    @Test
    void 게임을_정상적으로_진행할_수_있다() {
        racingCarService.inputCarName("car1,car2");
        racingCarService.inputTryNumber(3);

        racingCarService.startGame();

        for (RacingCar car : repository.getRacingCars()) {
            assertTrue(car.getDistance() >= 0);
        }
    }
}