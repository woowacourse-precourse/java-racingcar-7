package racingcar.domain.race;

import java.util.ArrayList;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.car.Car;
import racingcar.domain.member.Member;

class RaceResultTest {

    private Car carWithDistance3_1;
    private Car carWithDistance3_2;
    private List<Race> raceList;

    @BeforeEach
    void setUp() {
        Car carWithDistance0 = new Car(new Member("member0"), 0);
        Car carWithDistance1 = new Car(new Member("member1"), 1);
        Car carWithDistance2 = new Car(new Member("member2"), 2);
        carWithDistance3_1 = new Car(new Member("member3_1"), 3);
        carWithDistance3_2 = new Car(new Member("member3_2"), 3);

        List<Car> carListRace1 = new ArrayList<>(
                List.of(carWithDistance1, carWithDistance3_1, carWithDistance0, carWithDistance2));
        List<Car> carListRace2 = new ArrayList<>(
                List.of(carWithDistance3_2, carWithDistance3_1, carWithDistance0, carWithDistance2));

        Race race1 = new Race(carListRace1);
        Race race2 = new Race(carListRace2);
        raceList = new ArrayList<>(List.of(race1, race2));
    }

    @Test
    @DisplayName("RaceResult 객체 생성 테스트")
    void raceResult_객체_생성_테스트() {
        RaceResult raceResult = new RaceResult(raceList);
        Assertions.assertThat(raceResult.getRaces()).isEqualTo(raceList);
    }


    @Test
    @DisplayName("RaceResult 객체에서 우승자를 반환한다.")
    void 우승자_반환_테스트() {
        RaceResult raceResult = new RaceResult(raceList);
        Assertions.assertThat(raceResult.getRaceWinnerList()).hasSize(2)
                .containsExactlyInAnyOrder(carWithDistance3_1, carWithDistance3_2);
    }

}