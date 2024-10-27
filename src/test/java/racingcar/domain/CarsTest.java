package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.SoftAssertions.assertSoftly;
import static racingcar.constant.ExceptionMessage.NO_CARS;

import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.Test;
import racingcar.strategy.MovingStrategy;
import racingcar.support.AlwaysMovingStrategy;
import racingcar.support.NeverMovingStrategy;
import racingcar.vo.CarsPositionSnapshot;
import racingcar.vo.Name;
import racingcar.vo.Position;

class CarsTest {

    @Test
    void 자동차_목록으로_객체를_생성한다() {
        // given
        List<Car> carList = List.of(
                Car.withName(Name.from("car1")),
                Car.withName(Name.from("car2"))
        );

        // when
        Cars cars = Cars.from(carList);

        // then
        CarsPositionSnapshot snapshot = cars.createSnapshot();
        assertSoftly(softly -> {
            softly.assertThat(snapshot.getValue())
                    .hasSize(2);
            softly.assertThat(snapshot.getValue().keySet())
                    .extracting(Name::getValue)
                    .containsExactly("car1", "car2");
        });
    }

    @Test
    void 빈_리스트로_생성할_수_없다() {
        // when & then
        assertThatThrownBy(() -> Cars.from(List.of()))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(NO_CARS.message());
    }

    @Test
    void 모든_자동차를_이동시킨다() {
        // given
        Cars cars = Cars.from(List.of(
                Car.withName(Name.from("car1")),
                Car.withName(Name.from("car2"))
        ));
        MovingStrategy alwaysMove = new AlwaysMovingStrategy();

        // when
        cars.attemptMoveAll(alwaysMove);

        // then
        CarsPositionSnapshot snapshot = cars.createSnapshot();
        assertSoftly(softly -> {
            softly.assertThat(snapshot.getValue().values())
                    .allMatch(position -> position.getValue() == 1);
        });
    }

    @Test
    void 이동_전략에_따라_일부_자동차만_이동한다() {
        // given
        Cars cars = Cars.from(List.of(
                Car.withName(Name.from("car1")),
                Car.withName(Name.from("car2"))
        ));

        // when
        cars.attemptMoveAll(new AlwaysMovingStrategy());
        cars.attemptMoveAll(new NeverMovingStrategy());
        cars.attemptMoveAll(new AlwaysMovingStrategy());

        // then
        CarsPositionSnapshot snapshot = cars.createSnapshot();
        assertSoftly(softly -> {
            softly.assertThat(snapshot.getValue().values())
                    .allMatch(position -> position.getValue() == 2);
        });
    }

    @Test
    void 가장_멀리_이동한_자동차들을_조회한다() {
        // given
        Car car1 = Car.withName(Name.from("car1"));
        Car car2 = Car.withName(Name.from("car2"));
        Car car3 = Car.withName(Name.from("car3"));

        car1.attemptMove(new AlwaysMovingStrategy());  // 1
        car2.attemptMove(new AlwaysMovingStrategy());  // 1
        car2.attemptMove(new AlwaysMovingStrategy());  // 2
        car3.attemptMove(new AlwaysMovingStrategy());  // 1

        Cars cars = Cars.from(List.of(car1, car2, car3));

        // when
        List<Car> winners = cars.getCarsWithMaxStep();

        // then
        assertSoftly(softly -> {
            softly.assertThat(winners)
                    .hasSize(1);
            softly.assertThat(winners.get(0).getName().getValue())
                    .isEqualTo("car2");
            softly.assertThat(winners.get(0).getPosition().getValue())
                    .isEqualTo(2);
        });
    }

    @Test
    void 동일한_거리의_자동차들이_모두_조회된다() {
        // given
        Car car1 = Car.withName(Name.from("car1"));
        Car car2 = Car.withName(Name.from("car2"));
        Car car3 = Car.withName(Name.from("car3"));

        car1.attemptMove(new AlwaysMovingStrategy());  // 1
        car2.attemptMove(new AlwaysMovingStrategy());  // 1
        car3.attemptMove(new NeverMovingStrategy()); // 0

        Cars cars = Cars.from(List.of(car1, car2, car3));

        // when
        List<Car> winners = cars.getCarsWithMaxStep();

        // then
        assertSoftly(softly -> {
            softly.assertThat(winners)
                    .hasSize(2);
            softly.assertThat(winners)
                    .extracting(car -> car.getName().getValue())
                    .containsExactlyInAnyOrder("car1", "car2");
            softly.assertThat(winners)
                    .allMatch(car -> car.getPosition().getValue() == 1);
        });
    }

    @Test
    void 스냅샷을_생성한다() {
        // given
        Car car1 = Car.withName(Name.from("car1"));
        Car car2 = Car.withName(Name.from("car2"));
        car1.attemptMove(new AlwaysMovingStrategy());
        Cars cars = Cars.from(List.of(car1, car2));

        // when
        CarsPositionSnapshot snapshot = cars.createSnapshot();

        // then
        assertSoftly(softly -> {
            softly.assertThat(snapshot.getValue().keySet())
                    .extracting(Name::getValue)
                    .containsExactlyInAnyOrder("car1", "car2");

            Map<Name, Position> positions = snapshot.getValue();
            Position car1Position = positions.entrySet().stream()
                    .filter(entry -> entry.getKey().getValue().equals("car1"))
                    .map(Map.Entry::getValue)
                    .findFirst()
                    .orElseThrow();

            Position car2Position = positions.entrySet().stream()
                    .filter(entry -> entry.getKey().getValue().equals("car2"))
                    .map(Map.Entry::getValue)
                    .findFirst()
                    .orElseThrow();

            softly.assertThat(car1Position.getValue()).isEqualTo(1);
            softly.assertThat(car2Position.getValue()).isZero();
        });
    }
}
