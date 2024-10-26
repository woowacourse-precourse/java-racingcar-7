package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarsTest {
    private final NumberGenerator numberGenerator = new TestNumberGenerator();

    @Test
    @DisplayName("생성된 값이 4이상이면 자동차들 전진한다.")
    void carsMoveTest() {
        // given
        List<Car> carList = List.of(
                new Car("pobi"),
                new Car("woni"),
                new Car("jun"));
        Cars cars = Cars.from(carList);

        // when
        cars.move(numberGenerator);

        // then
        List<Integer> positions = cars.getPositions();
        List<Integer> movedPositions = positions.stream().filter(position -> position == 1).toList();
        assertThat(positions.size()).hasSameClassAs(movedPositions.size());
        assertThat(movedPositions).containsExactly(1, 1, 1);
    }

    static class TestNumberGenerator implements NumberGenerator {
        @Override
        public int generate() {
            return Randoms.pickNumberInRange(4, 9);
        }
    }
}