package racingcar.domain.race;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.car.Car;
import racingcar.domain.car.CarName;
import racingcar.domain.car.CarStatus;
import racingcar.domain.car.Cars;

class RaceTest {

    @DisplayName("자동차 경주를 플레이한다.")
    @Test
    void play() {
        //given
        List<Car> cars = List.of(
                new Car(new CarName("lee"), () -> true),
                new Car(new CarName("jae"), () -> false),
                new Car(new CarName("hun"), () -> true));
        int raceRound = 2;
        Race race = Race.from(raceRound, Cars.from(cars));

        //when
        race.play();

        //then
        assertThat(race.getRaceLogs()).extracting("carStatuses")
                .containsExactly(
                        List.of(new CarStatus("lee", 1),
                                new CarStatus("jae", 0),
                                new CarStatus("hun", 1)),
                        List.of(new CarStatus("lee", 2),
                                new CarStatus("jae", 0),
                                new CarStatus("hun", 2))
                );
    }

    @DisplayName("레이스 경주의 우승 자동차를 반환한다.")
    @Test
    void getVictoryCars() {
        //given
        List<Car> cars = List.of(
                new Car(new CarName("lee"), () -> true),
                new Car(new CarName("jae"), () -> false),
                new Car(new CarName("hun"), () -> true));
        int raceRound = 3;
        Race race = Race.from(raceRound, Cars.from(cars));

        //when
        race.play();

        //then
        assertThat(race.getVictoryCars()).extracting("name")
                .contains("lee", "hun");
    }
}