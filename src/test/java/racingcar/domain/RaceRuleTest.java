package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.List;
import java.util.stream.IntStream;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.utils.generator.NumberGenerator;

class RaceRuleTest {
    @ParameterizedTest
    @CsvSource({
            "0, false",
            "3, false",
            "4, true",
            "9, true"
    })
    void 숫자에_따른_이동_가능_여부를_판단한다(int number, boolean expected) {
        // given
        NumberGenerator generator = () -> number;

        // when
        RaceRule rule = new RaceRule(generator);

        // then
        assertThat(rule.canMove()).isEqualTo(expected);
    }

    @Test
    void 가장_많이_전진한_자동차가_우승한다() {
        // given
        Car car1 = new Car("car1", 5);
        Car car2 = new Car("car2", 1);
        Car car3 = new Car("car3", 4);
        List<Car> cars = List.of(car1, car2, car3);

        // when
        List<Car> winners = RaceRule.findWinners(cars);

        // then
        assertThat(winners).containsExactly(car1);
    }

    @Test
    void 동일한_이동거리의_자동차들이_모두_우승자가_된다() {
        // given
        Car car1 = new Car("car1", 5);
        Car car2 = new Car("car2", 4);
        Car car3 = new Car("car3", 5);
        List<Car> cars = List.of(car1, car2, car3);

        // when
        List<Car> winners = RaceRule.findWinners(cars);

        // then
        assertThat(winners).containsExactlyInAnyOrder(car1, car3);
    }

    @ParameterizedTest
    @ValueSource(ints = {-1, 10})
    void 전진_시_제공되는_숫자는_0에서_9_사이여야한다(int number) {
        // given
        NumberGenerator invalidGenerator = () -> number;
        RaceRule rule = new RaceRule(invalidGenerator);

        // then
        assertThrows(IllegalArgumentException.class, rule::canMove);
    }

    @Test
    void 중복된_이름이_있으면_예외발생() {
        List<String> names = List.of("car1", "car1", "car3");

        // when
        assertThrows(IllegalArgumentException.class, () -> {
            RaceRule.validateNames(names);
        });
    }

    @Test
    void 자동차_수가_허용_범위를_벗어나면_예외가_발생한다() {
        assertThrows(IllegalArgumentException.class, () ->
                RaceRule.validateNames(List.of("car1"))
        );

        assertThrows(IllegalArgumentException.class, () -> {
                    List<String> names = IntStream.rangeClosed(1, 11).mapToObj(i -> "car" + i).toList();
                    RaceRule.validateNames(names);
                }
        );
    }
}