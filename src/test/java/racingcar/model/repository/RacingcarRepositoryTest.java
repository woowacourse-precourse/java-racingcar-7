package racingcar.model.repository;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.model.domain.Car;

class RacingcarRepositoryTest {

    private RacingcarRepository racingcarRepository;

    @BeforeEach
    void setUp() {
        racingcarRepository = new RacingcarRepository();
    }

    @Test
    void 자동차_저장_테스트() {
        // given
        Car pobi = new Car("pobi");

        // when
        Car savedCar = racingcarRepository.save(pobi);

        // then
        assertThat(savedCar).isNotNull();
        assertThat(savedCar.getName()).isEqualTo("pobi");
    }

    @Test
    void 자동차_이름_조회_테스트() {
        // given
        Car crong = new Car("crong");
        racingcarRepository.save(crong);

        // when
        Car foundCar = racingcarRepository.findByName("crong");

        // then
        assertThat(foundCar).isNotNull();
        assertThat(foundCar.getName()).isEqualTo("crong");
    }

    @Test
    void 모든_자동차_조회_테스트() {
        // given
        Car pobi = new Car("pobi");
        Car crong = new Car("crong");
        Car honux = new Car("honux");
        racingcarRepository.save(pobi);
        racingcarRepository.save(crong);
        racingcarRepository.save(honux);

        // when
        List<Car> cars = racingcarRepository.findAll();

        // then
        assertThat(cars).hasSize(3);
        assertThat(cars)
                .extracting(Car::getName)
                .containsExactlyInAnyOrder("pobi", "crong", "honux");
    }
}
