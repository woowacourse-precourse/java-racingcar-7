package racingcar.domain.racing;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

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

    @Test
    @DisplayName("객체 생성")
    void initWith() {
        //given
        List<String> expectedCars = List.of("test1", "test2", "test3");

        //when
        RacingConfig racingConfig = new RacingConfig(cars, rounds, cartype);
        List<String> actualCars = racingConfig.getCars().stream()
                .map(Car::getName).toList();

        //then
        assertThat(actualCars).isEqualTo(expectedCars);
        assertThat(racingConfig.getRounds()).isEqualTo(Long.valueOf(rounds));
    }

    @Test
    @DisplayName("객체 생성 - 자동차 이름이 5자보다 많은 경우")
    void initWithTooLongCarName() {
        //given
        cars = "test1,test2,test3,TooLongCarName";

        //when & then
        assertThatThrownBy(() -> new RacingConfig(cars, rounds, cartype))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("객체 생성 - 자동차 이름이 공백인 경우")
    void initWithEmptyCarName() {
        //given
        cars = "test1,,test3";

        //when & then
        assertThatThrownBy(() -> new RacingConfig(cars, rounds, cartype))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("객체 생성 - 자동차 이름이 중복된 경우")
    void initWithDuplicatedCarName() {
        //given
        cars = "test1,test1,test3";

        //when & then
        assertThatThrownBy(() -> new RacingConfig(cars, rounds, cartype))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("객체 생성 - 시도할 횟수에 문자가 들어온 경우")
    void initWithCharacterRounds() {
        //given
        rounds = "a";

        //when & then
        assertThatThrownBy(() -> new RacingConfig(cars, rounds, cartype))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("객체 생성 - 시도할 횟수가 음수인 경우")
    void initWithNegativeRounds() {
        //given
        rounds = "-1";

        //when & then
        assertThatThrownBy(() -> new RacingConfig(cars, rounds, cartype))
                .isInstanceOf(IllegalArgumentException.class);
    }
}