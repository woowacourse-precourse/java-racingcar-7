package racingcar.repository;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.model.domain.Car;

class InMemoryCarRepositoryTest {
    InMemoryCarRepository carRepository;

    @BeforeEach
    void setUp() {
        carRepository = InMemoryCarRepository.getInstance();
        carRepository.updateAll(List.of()); //초기화
    }

    @Test
    void 저장_테스트() {
        //given
        Car car = new Car("ho");

        //when
        carRepository.save(car);

        //then
        assertThat(car.getName())
                .isEqualTo(carRepository.findAll().getFirst().getName());
    }

    @Test
    void findAll_메서드_테스트() {
        //given
        Car car1 = new Car("t1");
        Car car2 = new Car("t2");

        //when
        carRepository.save(car1);
        carRepository.save(car2);

        //then
        assertThat(List.of("t1", "t2"))
                .isEqualTo(carRepository.findAll().stream().map(Car::getName).collect(Collectors.toList()));
    }

    @Test
    void updateAll() {
        //given
        Car car1 = new Car("t1");
        Car car2 = new Car("t2");

        //when
        carRepository.save(car1);
        carRepository.save(car2);
        carRepository.updateAll(new ArrayList<>());

        //then
        assertThat(new ArrayList<>())
                .isEqualTo(carRepository.findAll());


    }
}
