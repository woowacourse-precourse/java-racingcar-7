package racingcar.persistence;

import static org.assertj.core.api.Assertions.*;

import camp.nextstep.edu.missionutils.test.Assertions;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.racing.RacingCar;

class InMemoryRacingCarRepositoryTest {

    InMemoryRacingCarRepository repository = InMemoryRacingCarRepository.getInstance();

    @DisplayName("RacingCar로 구성된 리스트를 한번에 저장할 수 있다.")
    @Test
    void addAll() {
        Assertions.assertSimpleTest(() -> {
            RacingCar car = new RacingCar("car1");
            RacingCar car2 = new RacingCar("car2");

            repository.addAll(List.of(car, car2));
            assertThat(repository.getAll()).hasSize(2);
            assertThat(repository.getAll().get(0)).isEqualTo(car);
            assertThat(repository.getAll().get(1)).isEqualTo(car2);
        });
    }
}
