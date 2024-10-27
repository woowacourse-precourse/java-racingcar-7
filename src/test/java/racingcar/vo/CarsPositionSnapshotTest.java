package racingcar.vo;

import static org.assertj.core.api.SoftAssertions.assertSoftly;

import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;

class CarsPositionSnapshotTest {

    @Test
    void 자동차들의_위치_정보로_스냅샷을_생성한다() {
        // given
        Name name1 = Name.from("car1");
        Name name2 = Name.from("car2");
        Car car1 = Car.withName(name1);
        Car car2 = Car.withName(name2);
        List<Car> cars = List.of(car1, car2);

        // when
        CarsPositionSnapshot snapshot = CarsPositionSnapshot.from(cars);

        // then
        assertSoftly(softly -> {
            softly.assertThat(snapshot.getValue())
                    .hasSize(2);
            softly.assertThat(snapshot.getValue())
                    .containsKey(name1)
                    .containsKey(name2);
            softly.assertThat(snapshot.getValue().values())
                    .allMatch(position -> position.getValue() == 0);
        });
    }

    @Test
    void 빈_리스트로_스냅샷을_생성한다() {
        // given
        List<Car> emptyCars = List.of();

        // when
        CarsPositionSnapshot snapshot = CarsPositionSnapshot.from(emptyCars);

        // then
        assertSoftly(softly -> {
            softly.assertThat(snapshot.getValue())
                    .isEmpty();
            softly.assertThat(snapshot.getValue())
                    .hasSize(0);
        });
    }

    @Test
    void 자동차들의_순서가_보존된다() {
        // given
        Name name3 = Name.from("car3");
        Name name1 = Name.from("car1");
        Name name2 = Name.from("car2");
        List<Car> cars = List.of(
                Car.withName(name3),
                Car.withName(name1),
                Car.withName(name2)
        );

        // when
        CarsPositionSnapshot snapshot = CarsPositionSnapshot.from(cars);

        // then
        assertSoftly(softly -> {
            softly.assertThat(snapshot.getValue().keySet())
                    .extracting(Name::getValue)
                    .containsExactly("car3", "car1", "car2");
        });
    }

    @Test
    void 스냅샷은_불변이다() {
        // given
        Name name = Name.from("car");
        Car car = Car.withName(name);
        List<Car> cars = List.of(car);
        CarsPositionSnapshot snapshot = CarsPositionSnapshot.from(cars);
        Map<Name, Position> originalPositions = snapshot.getValue();

        // when
        car.attemptMove(() -> true);

        // then
        assertSoftly(softly -> {
            softly.assertThat(snapshot.getValue())
                    .isEqualTo(originalPositions);
            softly.assertThat(snapshot.getValue().get(name).getValue())
                    .isZero();
        });
    }

    @Test
    void 다양한_위치값을_가진_자동차들의_스냅샷을_생성한다() {
        // given
        Name name1 = Name.from("car1");
        Name name2 = Name.from("car2");
        Car car1 = Car.withName(name1);
        Car car2 = Car.withName(name2);
        car1.attemptMove(() -> true);
        car1.attemptMove(() -> true);
        car2.attemptMove(() -> true);
        List<Car> cars = List.of(car1, car2);

        // when
        CarsPositionSnapshot snapshot = CarsPositionSnapshot.from(cars);

        // then
        assertSoftly(softly -> {
            softly.assertThat(snapshot.getValue().get(name1).getValue())
                    .isEqualTo(2);
            softly.assertThat(snapshot.getValue().get(name2).getValue())
                    .isEqualTo(1);
        });
    }

    @Test
    void 동일_이름의_자동차들은_각각_다른_엔트리로_저장된다() {
        // given
        Car car1 = Car.withName(Name.from("same"));
        Car car2 = Car.withName(Name.from("same"));
        car2.attemptMove(() -> true);
        List<Car> cars = List.of(car1, car2);

        // when
        CarsPositionSnapshot snapshot = CarsPositionSnapshot.from(cars);

        // then
        assertSoftly(softly -> {
            softly.assertThat(snapshot.getValue())
                    .hasSize(2);
            softly.assertThat(snapshot.getValue().values())
                    .extracting(Position::getValue)
                    .containsExactly(0, 1);
        });
    }
}
