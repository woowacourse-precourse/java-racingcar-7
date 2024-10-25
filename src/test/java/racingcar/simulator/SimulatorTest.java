package racingcar.simulator;

import static org.junit.jupiter.api.Assertions.*;
import java.util.List;
import org.junit.jupiter.api.Test;
import racingcar.car.Car;

class SimulatorTest {

    int numberOfAttempts = 10;
    List<String> namesOfCars = List.of("pobi", "woni", "seho", "jun");
    Simulator simulator;

    @Test
    void 랜덤_숫자가_4이상일_시_전진_테스트() {

        //given
        simulator = new Simulator(numberOfAttempts, namesOfCars) {
            @Override
            protected int getRandomNumber() {
                return 4; // 테스트 시 항상 전진 조건이 되도록 4 반환
            }
        };

        //when
        simulator.simulate();

        // then, 각 자동차가 모든 시도에서 전진했으므로, 예상 전진 거리 확인
        int[] expectedRacingBoard = {10, 10, 10, 10};
        assertEquals(expectedRacingBoard[0], simulator.getRacingBoard()[0]);
        assertEquals(expectedRacingBoard[1], simulator.getRacingBoard()[1]);
        assertEquals(expectedRacingBoard[2], simulator.getRacingBoard()[2]);
    }

    @Test
    void 랜덤_숫자가_4미만일_시_전진하지_않는_테스트() {

        //given
        simulator = new Simulator(numberOfAttempts, namesOfCars) {
            @Override
            protected int getRandomNumber() {
                return 3; // 테스트 시 항상 전진 조건이 안되도록 3 반환
            }
        };

        //when
        simulator.simulate();

        // then, 각 자동차가 모든 시도에서 전진하지 않았으므로, 예상 전진 거리 확인
        int[] expectedRacingBoard = {0, 0, 0, 0};
        assertEquals(expectedRacingBoard[0], simulator.getRacingBoard()[0]);
        assertEquals(expectedRacingBoard[1], simulator.getRacingBoard()[1]);
        assertEquals(expectedRacingBoard[2], simulator.getRacingBoard()[2]);
    }

    @Test
    void 모두_무조건_전진_시_모두_우승자가_되는_지_확인_테스트() {

        //given
        simulator = new Simulator(numberOfAttempts, namesOfCars) {
            @Override
            protected int getRandomNumber() {
                return 4; // 테스트 시 항상 전진 조건이 되도록 4 반환
            }
        };

        //when
        List<Car> winners = simulator.simulate();

        // then, 모든 자동차가 같은 위치에 있으므로 우승자가 모두여야 함
        List<String> expectedWinnerNames = List.of("pobi", "woni", "seho", "jun");
        List<String> actualWinnerNames = winners.stream().map(Car::getName).toList();
        assertEquals(expectedWinnerNames, actualWinnerNames);
    }


}