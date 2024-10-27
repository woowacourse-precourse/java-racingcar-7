package racingcar.domain;

import static org.assertj.core.api.SoftAssertions.assertSoftly;

import org.junit.jupiter.api.Test;
import racingcar.strategy.MovingStrategy;
import racingcar.vo.Name;
import racingcar.vo.Position;

class CarTest {

    private static class AlwaysMoveStrategy implements MovingStrategy {
        @Override
        public boolean shouldMove() {
            return true;
        }
    }

    private static class NeverMoveStrategy implements MovingStrategy {
        @Override
        public boolean shouldMove() {
            return false;
        }
    }

    @Test
    void 이름으로_자동차를_생성한다() {
        // given
        Name name = Name.from("pobi");

        // when
        Car car = Car.withName(name);

        // then
        assertSoftly(softly -> {
            softly.assertThat(car.getName()).isEqualTo(name);
            softly.assertThat(car.getPosition().getValue()).isZero();
        });
    }

    @Test
    void 이동_조건이_참이면_전진한다() {
        // given
        Car car = Car.withName(Name.from("pobi"));
        MovingStrategy alwaysMove = new AlwaysMoveStrategy();

        // when
        car.attemptMove(alwaysMove);

        // then
        assertSoftly(softly -> {
            softly.assertThat(car.getPosition().getValue()).isEqualTo(1);
            softly.assertThat(car.getName().getValue()).isEqualTo("pobi");
        });
    }

    @Test
    void 이동_조건이_거짓이면_정지한다() {
        // given
        Car car = Car.withName(Name.from("pobi"));
        MovingStrategy neverMove = new NeverMoveStrategy();
        Position initialPosition = car.getPosition();

        // when
        car.attemptMove(neverMove);

        // then
        assertSoftly(softly -> {
            softly.assertThat(car.getPosition()).isEqualTo(initialPosition);
            softly.assertThat(car.getPosition().getValue()).isZero();
        });
    }

    @Test
    void 여러번_이동을_시도한다() {
        // given
        Car car = Car.withName(Name.from("pobi"));
        MovingStrategy alwaysMove = new AlwaysMoveStrategy();
        MovingStrategy neverMove = new NeverMoveStrategy();

        // when
        car.attemptMove(alwaysMove);  // 1
        car.attemptMove(neverMove);   // 1
        car.attemptMove(alwaysMove);  // 2
        car.attemptMove(alwaysMove);  // 3

        // then
        assertSoftly(softly -> {
            softly.assertThat(car.getPosition().getValue()).isEqualTo(3);
            softly.assertThat(car.getName().getValue()).isEqualTo("pobi");
        });
    }

    @Test
    void 자동차의_위치를_기준으로_비교한다() {
        // given
        Car car1 = Car.withName(Name.from("car1"));
        Car car2 = Car.withName(Name.from("car2"));
        Car car3 = Car.withName(Name.from("car3"));
        MovingStrategy alwaysMove = new AlwaysMoveStrategy();

        car2.attemptMove(alwaysMove);
        car3.attemptMove(alwaysMove);
        car3.attemptMove(alwaysMove);

        // then
        assertSoftly(softly -> {
            softly.assertThat(car1.compareTo(car2)).isNegative();
            softly.assertThat(car2.compareTo(car3)).isNegative();
            softly.assertThat(car3.compareTo(car1)).isPositive();
            softly.assertThat(car1.compareTo(car1)).isZero();
        });
    }

    @Test
    void 이름이_다르고_위치가_같은_자동차를_비교한다() {
        // given
        Car car1 = Car.withName(Name.from("car1"));
        Car car2 = Car.withName(Name.from("car2"));

        // then
        assertSoftly(softly -> {
            softly.assertThat(car1.compareTo(car2)).isZero();
            softly.assertThat(car2.compareTo(car1)).isZero();
        });
    }

    @Test
    void 자동차의_이름은_불변이다() {
        // given
        Name name = Name.from("pobi");
        Car car = Car.withName(name);

        // when
        Name newName = Name.from("woni");

        // then
        assertSoftly(softly -> {
            softly.assertThat(car.getName().getValue()).isEqualTo("pobi");
            softly.assertThat(car.getName()).isEqualTo(name);
        });
    }

    @Test
    void 자동차는_이동_전략에_따라_한_칸씩만_이동한다() {
        // given
        Car car = Car.withName(Name.from("pobi"));
        MovingStrategy alwaysMove = new AlwaysMoveStrategy();

        // when
        car.attemptMove(alwaysMove);

        // then
        assertSoftly(softly -> {
            softly.assertThat(car.getPosition().getValue()).isEqualTo(1);

            car.attemptMove(alwaysMove);
            softly.assertThat(car.getPosition().getValue()).isEqualTo(2);
        });
    }
}
