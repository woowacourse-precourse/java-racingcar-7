package racingcar.repository;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;

class RacingCarRepositoryTest {

    RacingCarRepository racingCarRepository = RacingCarRepository.getInstance();

    @BeforeEach
    void setUp() {

        racingCarRepository.clear();
    }

    @Test
    @DisplayName("자동차 저장 테스트")
    void save() {

        Car car = new Car("pobi");
        racingCarRepository.save(car);

        List<Car> cars = racingCarRepository.findAll();
        Assertions.assertThat(cars).hasSize(1);
        Assertions.assertThat(cars.get(0).getName()).isEqualTo("pobi");
    }

    @Test
    @Disabled
    @DisplayName("저장된 자동차 목록 조회 테스트")
    void findAll() {

        // 저장 순서를 보장하지 않음
        Car car1 = new Car("pobi");
        Car car2 = new Car("woni");
        Car car3 = new Car("jun");

        racingCarRepository.save(car1);
        racingCarRepository.save(car2);
        racingCarRepository.save(car3);

        List<Car> cars = racingCarRepository.findAll();
        Assertions.assertThat(cars.size()).isEqualTo(3);
        Assertions.assertThat(cars.get(0).getName()).isEqualTo("pobi");
        Assertions.assertThat(cars.get(1).getName()).isEqualTo("woni");
        Assertions.assertThat(cars.get(2).getName()).isEqualTo("jun");
    }
}