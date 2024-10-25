package racingcar.model;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.model.dto.CarStatusDto;
import racingcar.util.randomnumber.RandomNumberGenerator;
import racingcar.util.randomnumber.StubRandomNumberGenerator;

class RacingTest {

    @DisplayName("경주를 생성한다.")
    @Test
    void createRacing() {
        //given
        Cars cars = Cars.from(List.of(
                Car.from("pobi", new RandomNumberGenerator()),
                Car.from("woni", new RandomNumberGenerator()),
                Car.from("jun", new RandomNumberGenerator())
        ));

        RacingCount racingCount = RacingCount.from(1);

        //when
        Racing racing = Racing.of(cars, racingCount);

        //then
        assertThat(racing).isEqualTo(Racing.of(cars, racingCount));
    }

    @DisplayName("경주가 가능하다면 true를 반환한다.")
    @Test
    void canRacing() {
        //given
        Cars cars = Cars.from(List.of(
                Car.from("pobi", new RandomNumberGenerator()),
                Car.from("woni", new RandomNumberGenerator()),
                Car.from("jun", new RandomNumberGenerator())
        ));

        RacingCount racingCount = RacingCount.from(1);

        Racing racing = Racing.of(cars, racingCount);

        //when
        boolean result = racing.can();

        //then
        assertThat(result).isTrue();
    }

    @DisplayName("경주가 가능하지 않다면 false를 반환한다.")
    @Test
    void canNotRacing() {
        //given
        Cars cars = Cars.from(List.of(
                Car.from("pobi", new RandomNumberGenerator()),
                Car.from("woni", new RandomNumberGenerator()),
                Car.from("jun", new RandomNumberGenerator())
        ));

        RacingCount racingCount = RacingCount.from(1);

        Racing racing = Racing.of(cars, racingCount);

        racing.deductTryCount();

        //when
        boolean result = racing.can();

        //then
        assertThat(result).isFalse();
    }

    @DisplayName("경주를 진행한다.")
    @Test
    void run() {
        //given
        Car pobiCar = Car.from("pobi", new StubRandomNumberGenerator(4));
        Car woniCar = Car.from("woni", new StubRandomNumberGenerator(3));
        Car junCar = Car.from("jun", new StubRandomNumberGenerator(1));

        Cars cars = Cars.from(
                List.of(pobiCar, woniCar, junCar)
        );

        RacingCount racingCount = RacingCount.from(1);

        Racing racing = Racing.of(cars, racingCount);

        //when
        racing.run();

        //then
        assertThat(pobiCar.getPosition()).isEqualTo(1);
        assertThat(woniCar.getPosition()).isEqualTo(0);
        assertThat(junCar.getPosition()).isEqualTo(0);
    }

    @DisplayName("경주를 한번 진행하면 시도 횟수를 1회 차감할 수 있다.")
    @Test
    void deductTryCountByRun() {
        //given
        Car pobiCar = Car.from("pobi", new StubRandomNumberGenerator(4));
        Car woniCar = Car.from("woni", new StubRandomNumberGenerator(3));
        Car junCar = Car.from("jun", new StubRandomNumberGenerator(1));

        Cars cars = Cars.from(
                List.of(pobiCar, woniCar, junCar)
        );

        RacingCount racingCount = RacingCount.from(1);

        Racing racing = Racing.of(cars, racingCount);

        racing.run();

        //when
        racing.deductTryCount();

        //then
        assertThat(racingCount.getTryCount()).isEqualTo(0);
    }

    @DisplayName("경주 결과를 반환한다.")
    @Test
    void getResult() {
        //given
        Car pobiCar = Car.from("pobi", new StubRandomNumberGenerator(4));
        Car woniCar = Car.from("woni", new StubRandomNumberGenerator(3));
        Car junCar = Car.from("jun", new StubRandomNumberGenerator(1));

        Cars cars = Cars.from(
                List.of(pobiCar, woniCar, junCar)
        );

        RacingCount racingCount = RacingCount.from(1);

        Racing racing = Racing.of(cars, racingCount);

        racing.run();

        //when
        List<CarStatusDto> racingResults = racing.getResult();

        //then
        assertThat(racingResults).containsExactly(
                CarStatusDto.of("pobi", 1),
                CarStatusDto.of("woni", 0),
                CarStatusDto.of("jun", 0)
        );
    }

    @DisplayName("우승자를 반환한다.")
    @Test
    void winners() {
        //given
        Car pobiCar = Car.from("pobi", new StubRandomNumberGenerator(4));
        Car woniCar = Car.from("woni", new StubRandomNumberGenerator(3));
        Car junCar = Car.from("jun", new StubRandomNumberGenerator(1));

        Cars cars = Cars.from(
                List.of(pobiCar, woniCar, junCar)
        );

        RacingCount racingCount = RacingCount.from(1);

        Racing racing = Racing.of(cars, racingCount);

        racing.run();

        //when
        List<String> winners = racing.getWinners();

        //then
        assertThat(winners).containsExactly("pobi");
    }
}