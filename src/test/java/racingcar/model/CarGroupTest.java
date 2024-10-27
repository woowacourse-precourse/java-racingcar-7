package racingcar.model;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

class CarGroupTest {

    @Test
    void 자동차_수_테스트() {
        // given
        List<String> carNames = Arrays.stream("ghim,yu,gyeom".split(",")).toList();
        CarGroup carGroup = new CarGroup(carNames);

        // when & then
        assertEquals(3, carGroup.getCars().size());
    }

    @Test
    void 자동차_수가_2보다_작을_경우_예외_발생() {
        // given
        List<String> carNames = Arrays.stream("gyeom".split(",")).toList();

        // when & then
        assertThatThrownBy(() -> new CarGroup(carNames))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동차 이름은 적어도 두 개 입력해야 합니다.");
    }

    @Test
    void 자동차_이름이_중복될_경우_예외_발생() {
        // given
        List<String> carNames = Arrays.stream("gyeom,gyeom".split(",")).toList();

        // when & then
        assertThatThrownBy(() -> new CarGroup(carNames))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("중복된 자동차 이름이 존재합니다.");
    }

    @Test
    void 우승자_여러명_테스트() {
        // given
        List<String> carNames = Arrays.stream("gyeom,yu,ghim".split(",")).toList();
        CarGroup carGroup = new CarGroup(carNames);

        int movableNumber = 4;
        List<Car> cars = carGroup.getCars().stream().toList();
        cars.get(0).moveFront(movableNumber);
        cars.get(2).moveFront(movableNumber);

        // when
        List<Car> winners = carGroup.getWinners();

        // then
        assertEquals(cars.get(0), winners.get(0));
        assertEquals(cars.get(2), winners.get(1));
    }

    @Test
    void 우승자_모두_테스트() {
        // given
        List<String> carNames = Arrays.stream("gyeom,yu,ghim".split(",")).toList();
        CarGroup carGroup = new CarGroup(carNames);

        int movableNumber = 4;
        List<Car> cars = carGroup.getCars().stream().toList();
        cars.get(0).moveFront(movableNumber);
        cars.get(1).moveFront(movableNumber);
        cars.get(2).moveFront(movableNumber);

        // when
        List<Car> winners = carGroup.getWinners();

        // then
        assertEquals(cars.get(0), winners.get(0));
        assertEquals(cars.get(1), winners.get(1));
        assertEquals(cars.get(2), winners.get(2));
    }

    @Test
    void 우승자_한명_테스트() {
        // given
        List<String> carNames = Arrays.stream("gyeom,yu,ghim".split(",")).toList();
        CarGroup carGroup = new CarGroup(carNames);

        int movableNumber = 4;
        List<Car> cars = carGroup.getCars().stream().toList();
        cars.get(2).moveFront(movableNumber);

        // when
        List<Car> winners = carGroup.getWinners();

        // then
        assertEquals(cars.get(2), winners.get(0));
    }
}
