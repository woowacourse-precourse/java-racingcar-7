package racingcar;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;
import racingcar.model.Car;
import racingcar.model.RacingCarGame;
import racingcar.model.RandomMoveStrategy;

public class RacingCarGameTest {
    @Test
    void 자동차경주게임_초기설정_테스트() {
        //given
        List<Car> cars = List.of(new Car("pobi"), new Car("woni"), new Car("jun"));
        int attemptCount = 5;

        //when
        RacingCarGame racingCarGame = new RacingCarGame(cars, attemptCount);

        //then
        assertAll(
                () -> assertThat(racingCarGame.getCars()).isEqualTo(cars),
                () -> assertThat(racingCarGame.getAttemptCount()).isEqualTo(attemptCount)
        );
    }

    @Test
    void 자동차_전진_테스트() {
        // given
        Car car1 = new Car("car1");
        Car car2 = new Car("car2");
        List<Car> cars = Arrays.asList(car1, car2);
        int attemptCount = 5;

        RandomMoveStrategy mockStrategy = new RandomMoveStrategy() {
            @Override
            public int generateRandomNumber() {
                return 4;
            }

            @Override
            public boolean isMovable(int number) {
                return true;
            }
        };

        RacingCarGame game = new RacingCarGame(cars, attemptCount, mockStrategy);

        // when
        game.raceEachCar();

        // then
        assertAll(
                () -> assertThat(car1.getPosition()).isEqualTo(1),
                () -> assertThat(car2.getPosition()).isEqualTo(1)
        );
    }

    @Test
    void 자동차_정지_테스트() {
        // given
        Car car1 = new Car("car1");
        Car car2 = new Car("car2");
        List<Car> cars = Arrays.asList(car1, car2);
        int attemptCount = 5;

        RandomMoveStrategy mockStrategy = new RandomMoveStrategy() {
            @Override
            public int generateRandomNumber() {
                return 3;
            }

            @Override
            public boolean isMovable(int number) {
                return false;
            }
        };

        RacingCarGame game = new RacingCarGame(cars, attemptCount, mockStrategy);

        // when
        game.raceEachCar();

        // then
        assertAll(
                () -> assertThat(car1.getPosition()).isEqualTo(0),
                () -> assertThat(car2.getPosition()).isEqualTo(0)
        );
    }

    @Test
    void 자동차_랜덤_이동_테스트() {
        // given
        Car car1 = new Car("car1");
        Car car2 = new Car("car2");
        List<Car> cars = Arrays.asList(car1, car2);
        int attemptCount = 5;

        RandomMoveStrategy mockStrategy = new RandomMoveStrategy() {
            private int count = 0;

            @Override
            public int generateRandomNumber() {
                return 4;
            }

            @Override
            public boolean isMovable(int number) {
                // 첫 번째 자동차는 전진, 두 번째 자동차는 정지
                return count++ % 2 == 0;
            }
        };

        RacingCarGame game = new RacingCarGame(cars, attemptCount, mockStrategy);

        // when
        game.raceEachCar();

        // then
        assertAll(
                () -> assertThat(car1.getPosition()).isEqualTo(1),
                () -> assertThat(car2.getPosition()).isEqualTo(0)
        );
    }

    @Test
    void 최대_위치_찾기_테스트() {
        // given
        Car car1 = new Car("car1");
        Car car2 = new Car("car2");
        Car car3 = new Car("car3");

        car1.moveForward();
        car2.moveForward();
        car2.moveForward();
        car3.moveForward();

        List<Car> cars = Arrays.asList(car1, car2, car3);
        int attemptCount = 5;
        RacingCarGame game = new RacingCarGame(cars, attemptCount);

        // when
        int maxPosition = game.findMaxPosition();

        // then
        assertThat(maxPosition).isEqualTo(2);
    }

    @Test
    void 모든_자동차_위치_0_테스트() {
        // given
        Car car1 = new Car("car1");
        Car car2 = new Car("car2");
        Car car3 = new Car("car3");

        List<Car> cars = Arrays.asList(car1, car2, car3);
        int attemptCount = 5;
        RacingCarGame game = new RacingCarGame(cars, 5);

        // when
        List<String> winners = game.getWinnerList();
        int maxPosition = game.findMaxPosition();

        // then
        assertAll(
                () -> assertThat(maxPosition).isEqualTo(0),
                () -> assertThat(winners).hasSize(3),
                () -> assertThat(winners).containsExactly("car1", "car2", "car3")
        );
    }

    @Test
    void 우승자_한명_테스트() {
        // given
        Car car1 = new Car("car1");
        Car car2 = new Car("car2");
        Car car3 = new Car("car3");

        car1.moveForward();
        car2.moveForward();
        car2.moveForward();
        car3.moveForward();

        List<Car> cars = Arrays.asList(car1, car2, car3);
        int attemptCount = 5;
        RacingCarGame game = new RacingCarGame(cars, attemptCount);

        // when
        List<String> winners = game.getWinnerList();

        // then
        assertAll(
                () -> assertThat(winners).hasSize(1),
                () -> assertThat(winners).containsExactly("car2")
        );
    }

    @Test
    void 우승자_여러명_테스트() {
        // given
        Car car1 = new Car("car1");
        Car car2 = new Car("car2");
        Car car3 = new Car("car3");

        car1.moveForward();
        car1.moveForward();
        car2.moveForward();
        car2.moveForward();
        car3.moveForward();

        List<Car> cars = Arrays.asList(car1, car2, car3);
        int attemptCount = 5;
        RacingCarGame game = new RacingCarGame(cars, attemptCount);

        // when
        List<String> winners = game.getWinnerList();

        // then
        assertAll(
                () -> assertThat(winners).hasSize(2),
                () -> assertThat(winners).containsExactly("car1", "car2")
        );
    }
}
