package racingcar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.model.Car;
import racingcar.model.RacingManager;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class RacingManagerTest {
    private RacingManager racingManager;
    @BeforeEach
    void setUp(){
        racingManager = new RacingManager();
    }

    @Test
    void 자동차_이름을_객체로_변환(){
        String carNames = "a,bb,ccc";
        List<Car>carList = racingManager.parseCarNamesToCar(carNames);

        assertThat(carList).hasSize(3);
        assertThat(carList).extracting(Car::getName)
                .containsExactly("a", "bb", "ccc");
    }

    @Test
    void 공백이_포함된_자동차_이름을_객체로_변환(){
        String carNames = "a, bb , ccc";
        List<Car>carList = racingManager.parseCarNamesToCar(carNames);

        assertThat(carList).hasSize(3);
        assertThat(carList).extracting(Car::getName)
                .containsExactly("a", "bb", "ccc");
    }

    @Test
    void 랜덤값에_따라_자동차_이동_결정(){
        Car car = new Car("Test",2);

        car.move(4);
        assertThat(car.getDistance()).isEqualTo(3);

        car.move(3);
        assertThat(car.getDistance()).isEqualTo(3);
    }

    @Test
    void 모든_자동차가_이동_또는_정지한다(){
        List<Car> carList = Arrays.asList(new Car("A"), new Car("B"), new Car("C"));

        racingManager.moveOrStop(carList);
        for (Car car : carList) {
            assertThat(car.getDistance()).isBetween(0, 1); // 자동차가 이동했거나 그대로일 수 있음
        }
    }

    @Test
    void 우승자들을_반환(){
        List<Car>carList = Arrays.asList(
                new Car("A",5),
                new Car("B",4),
                new Car("C",5),
                new Car("D",3));

        List<Car>winnerList = racingManager.getWinners(carList);

        assertThat(winnerList)
                .hasSize(2)
                .extracting(Car::getName)
                .containsExactlyInAnyOrder("A","C");
    }

}