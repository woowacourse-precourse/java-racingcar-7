package racingcar;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CarsTest {

    private Cars cars;

    @BeforeEach
    void Cars_객체_생성() {
        cars = new Cars(List.of("pobi", "woni", "jun"));
    }

    @Test
    void 자동차_이름_리스트_초기화_확인() {
        List<Car> carList = cars.getCars();
        assertThat(carList).hasSize(3);
        assertThat(carList.get(0).getName()).isEqualTo("pobi");
        assertThat(carList.get(1).getName()).isEqualTo("woni");
        assertThat(carList.get(2).getName()).isEqualTo("jun");
    }

    @Test
    void 자동차들_랜덤_숫자_이동_확인() {
        cars.getCars().get(0).move(4);
        cars.getCars().get(0).move(9);
        cars.getCars().get(1).move(3);
        cars.getCars().get(2).move(5);

        assertThat(cars.getCars().get(0).getMoveDisctance()).isEqualTo(2);
        assertThat(cars.getCars().get(1).getMoveDisctance()).isEqualTo(0);
        assertThat(cars.getCars().get(2).getMoveDisctance()).isEqualTo(1);
    }

    @Test
    void 최대_이동_거리_계산_확인() {
        cars.getCars().get(0).move(4);
        cars.getCars().get(0).move(4);
        cars.getCars().get(1).move(3);
        cars.getCars().get(2).move(5);

        int maxMoveDistance = cars.maxMoveDistance();
        assertThat(maxMoveDistance).isEqualTo(2);
    }

    @Test
    void 우승자_결정_확인_한명() {
        cars.getCars().get(0).move(3);
        cars.getCars().get(1).move(3);
        cars.getCars().get(2).move(5);

        List<String> winners = cars.findWinners(1);
        assertThat(winners).containsExactlyInAnyOrder("jun");
    }

    @Test
    void 우승자_결정_확인_여러명() {
        cars.getCars().get(0).move(4);
        cars.getCars().get(0).move(4);
        cars.getCars().get(1).move(3);
        cars.getCars().get(2).move(5);
        cars.getCars().get(2).move(5);

        List<String> winners = cars.findWinners(2);
        assertThat(winners).containsExactlyInAnyOrder("pobi", "jun");
    }
}