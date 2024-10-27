package racingcar.domain.racing;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.car.Car;
import racingcar.domain.car.CarType;

class RacingConfigTest {
    String cars;
    String rounds;
    CarType cartype;

    @BeforeEach
    void init() {
        cars = "test1,test2,test3";
        rounds = "5";
        cartype = CarType.REGULAR;
    }

    @Test
    @DisplayName("자동차 목록 조회")
    void getCars() {
        //given
        RacingConfig racingConfig = new RacingConfig(cars, rounds, cartype);
        List<String> expectedCars = List.of("test1", "test2", "test3");

        //when
        List<String> actualCars = racingConfig.getCars().stream()
                .map(Car::getName).toList();

        //then
        assertThat(actualCars).isEqualTo(expectedCars);
    }

    @Test
    @DisplayName("라운드 수 조회")
    void getRounds() {
        //given
        RacingConfig racingConfig = new RacingConfig(cars, rounds, cartype);

        //when
        long actualRounds = racingConfig.getRounds();

        //then
        assertThat(actualRounds).isEqualTo(Long.valueOf(rounds));
    }
}