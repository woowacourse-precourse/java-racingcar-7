package racingcar.domain.race;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.car.Car;
import racingcar.domain.member.Member;

class RaceTest {

    @Test
    @DisplayName("Race 객체 생성 테스트")
    void race_객체_생성_테스트() {
        Car car = Car.of(new Member("member"));
        Race race = new Race(List.of(car));
        Assertions.assertThat(race.getCars()).isEqualTo(List.of(car));
    }

    @Test
    @DisplayName("Race객체의 car의 이동 거리 내림차순으로 순위를 정렬하여 list로 반환한다.")
    void race_car_순위_정렬_테스트() {
        Car carWithDistance0 = new Car(new Member("member0"), 0);
        Car carWithDistance1 = new Car(new Member("member1"), 1);
        Car carWithDistance2 = new Car(new Member("member2"), 2);
        Car carWithDistance3 = new Car(new Member("member3"), 3);
        List<Car> cars = List.of(carWithDistance0, carWithDistance1, carWithDistance2, carWithDistance3);

        Race race = new Race(cars);
        Assertions.assertThat(race.getSortedRaceResults())
                .isEqualTo(List.of(carWithDistance3, carWithDistance2, carWithDistance1, carWithDistance0));
    }
}