package util;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;

import camp.nextstep.edu.missionutils.test.NsTest;
import dto.RacingParam;
import java.util.ArrayList;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.Application;
import repository.CarRepository;

class CarTest extends NsTest {
    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;
    private Car car;

    @BeforeEach
    void beforeEach() {
        this.car = new Car("car1");
        ArrayList<Car> cars = new ArrayList<>();
        cars.add(car);
        RacingParam racingParam = new RacingParam(cars, 4);
        CarRepository.saveCarsAndRepeatCount(racingParam);
    }

    @Test
    void moveForward() {
        // given
        Car car = new Car("car1");

        // when
        car.moveForward();
        ArrayList<Integer> actual = car.forwardCount;

        ArrayList<Integer> expected = new ArrayList<>();
        expected.add(1);

        // then
        Assertions.assertThat(actual).isEqualTo(expected);

    }

    @Test
    void doNotMoveForward() {
        // given
        Car car = new Car("car1");

        // when
        car.doNotMoveForward();
        ArrayList<Integer> actual = car.forwardCount;

        ArrayList<Integer> expected = new ArrayList<>();
        expected.add(0);

        // then
        Assertions.assertThat(actual).isEqualTo(expected);

    }

    @Test
    void moveForwardRandomly() {
        assertRandomNumberInRangeTest(
                () -> {
                    // when
                    car.moveForwardRandomly();

                    ArrayList<Integer> actual = car.forwardCount;
                    ArrayList<Integer> expected = new ArrayList<>();
                    expected.add(0);

                    // then
                    Assertions.assertThat(actual).isEqualTo(expected);
                },
                STOP
        );

        assertRandomNumberInRangeTest(
                () -> {
                    // when
                    car.moveForwardRandomly();

                    ArrayList<Integer> actual = car.forwardCount;
                    ArrayList<Integer> expected = new ArrayList<>();
                    expected.add(1);

                    // then
                    Assertions.assertThat(actual).isEqualTo(expected);
                },
                MOVING_FORWARD
        );
    }

    @Test
    void isMoveAllowed() {
        assertRandomNumberInRangeTest(
                () -> {
                    boolean carStop = car.isMoveAllowed();

                    Assertions.assertThat(carStop).isEqualTo(false);
                },
                STOP
        );

        assertRandomNumberInRangeTest(
                () -> {
                    boolean carStop = car.isMoveAllowed();

                    Assertions.assertThat(carStop).isEqualTo(true);
                },
                MOVING_FORWARD
        );
    }

    @Test
    void startRacing() {
        assertRandomNumberInRangeTest(
                () -> {
                    // when
                    car.startRacing();

                    ArrayList<Integer> expected = new ArrayList<>();
                    expected.add(1);
                    expected.add(0);
                    expected.add(1);
                    expected.add(0);

                    // then
                    Assertions.assertThat(car.forwardCount).isEqualTo(expected);
                },
                MOVING_FORWARD, STOP, MOVING_FORWARD, MOVING_FORWARD
        );
    }

    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }
}