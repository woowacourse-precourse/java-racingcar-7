package racingcar.application.service.car;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.infrastructure.persistence.InMemoryRacingCarRepository;
import racingcar.infrastructure.util.NameParser;

import static org.junit.jupiter.api.Assertions.*;
class RacingCarServiceTest {

    private RacingCarService racingCarService;
    private InMemoryRacingCarRepository repository;

    @BeforeEach
    public void before(){
        repository = InMemoryRacingCarRepository.getInstance();
        repository.clear();
        racingCarService = new RacingCarService(new NameParser());
    }

    @Test
    void 레이싱_카_저장하기() {
        String names = "name, test, jaz";

        racingCarService.inputCarName(names);

        assertEquals(repository.getRacingCars().getFirst().getName(), "name");
    }
}