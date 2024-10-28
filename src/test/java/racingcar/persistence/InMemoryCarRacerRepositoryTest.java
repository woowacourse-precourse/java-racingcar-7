package racingcar.persistence;

import static org.assertj.core.api.Assertions.*;

import camp.nextstep.edu.missionutils.test.Assertions;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.racing.CarRacer;

class InMemoryCarRacerRepositoryTest {

    InMemoryRacingCarRepository repository = InMemoryRacingCarRepository.getInstance();

    @AfterEach
    void tearDown() {
        repository.clear();
    }

    @DisplayName("RacingCar로 구성된 리스트를 한번에 저장할 수 있다.")
    @Test
    void addAll() {
        Assertions.assertSimpleTest(() -> {
            CarRacer car = CarRacer.from("car1");
            CarRacer car2 = CarRacer.from("car2");

            repository.addAll(List.of(car, car2));
            assertThat(repository.getAll()).hasSize(2);
            assertThat(repository.getAll().get(0)).isEqualTo(car);
            assertThat(repository.getAll().get(1)).isEqualTo(car2);
        });
    }
}
